#!/usr/bin/env bash
#
# Decide whether a proposed refactoring actually resolved the security smell.
#
# A patch is not evidence. ADR-0010 admits an AI into this toolchain only on the
# condition that what it produces is measured rather than trusted, and this is
# the measurement. Four gates, all of which must pass:
#
#   1. clean   the patch applies to a clean checkout and the build is green
#              there, with no generated key material present
#   2. inplace the build is green in a tree where the material has been
#              generated
#   3. smell   the finding count fell, against a baseline taken before
#   4. starts  the system still comes up
#
# Gate 1 and gate 2 are deliberately separate. A patch whose tests read a key
# store from disk passes the second and fails the first, which is exactly what
# the second proposal of this work did - and nothing but a clean-room build
# found it.
#
# Usage:
#   tools/verify-refactoring.sh --proposal <folder> --source <checkout> \
#       --models <generated-models> [--mrf <mrf-repo>] [--base <ref>]
#       [--plugins "<list>"] [--build-command "<command>"]
#       [--skip-start] [--skip-smell] [--certs <command>]
#
# Verifying a system other than Lakeside Mutual needs two of these. --plugins
# is the MRF plugin selection for that system, and getting it wrong is the one
# mistake this script cannot catch: the smell gate would compare a baseline
# against a reconstruction of a different fact set and still print a number.
# --build-command says how to build a system that is not per-service Maven;
# without it, a system with no Maven wrapper skips the build gates rather than
# passing them.
#
# --base is the commit the patch is measured against, defaulting to HEAD. It
# matters when a patch depends on a prerequisite: a refactoring of a system
# whose container images no longer build has to be judged against the commit
# that fixes them, or the start gate can only ever skip.
#
# The proposal folder is one written by ProposalRecord: it must hold patch.diff,
# and the result is appended to verification.md inside it.
#
# Environment:
#   LEMMA_ECLIPSE   Eclipse installation the LEMMA tools take their classpath
#                   from (see detect-smells.sh)
set -uo pipefail

BUNDLE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORKSPACE="$(cd "$BUNDLE/.." && pwd)"

PROPOSAL=""; SOURCE=""; MODELS=""; MRF=""; CERTS=""; BASE="HEAD"
SKIP_START=0; SKIP_SMELL=0
# Defaults fit Lakeside Mutual. Both are options because they are the two
# places this script would otherwise be specific to one system - and getting
# either wrong is worse than it looks: the smell gate would compare a baseline
# against a reconstruction of a different fact set, and the build gates would
# pass without building anything.
PLUGINS="Java Spring Communication Docker Protobuf Node"
BUILD_COMMAND=""
while [[ $# -gt 0 ]]; do
    case "$1" in
        --proposal) PROPOSAL="$2"; shift 2 ;;
        --source)   SOURCE="$2";   shift 2 ;;
        --models)   MODELS="$2";   shift 2 ;;
        --mrf)      MRF="$2";      shift 2 ;;
        --certs)    CERTS="$2";    shift 2 ;;
        --base)     BASE="$2";     shift 2 ;;
        --plugins)  PLUGINS="$2";  shift 2 ;;
        --build-command) BUILD_COMMAND="$2"; shift 2 ;;
        --skip-start) SKIP_START=1; shift ;;
        --skip-smell) SKIP_SMELL=1; shift ;;
        -h|--help) sed -n '2,32p' "${BASH_SOURCE[0]}" | sed 's/^# \{0,1\}//'; exit 0 ;;
        *) echo "Unknown option: $1" >&2; exit 2 ;;
    esac
done

for required in PROPOSAL SOURCE MODELS; do
    if [[ -z "${!required}" ]]; then
        echo "Missing --${required,,}. See --help." >&2
        exit 2
    fi
done
PATCH="$PROPOSAL/patch.diff"
[[ -f "$PATCH" ]] || { echo "No patch.diff in $PROPOSAL" >&2; exit 2; }
[[ -d "$SOURCE/.git" ]] || { echo "Not a git checkout: $SOURCE" >&2; exit 2; }

PASSED=(); FAILED=(); SKIPPED=()
pass() { PASSED+=("$1"); printf '  PASS  %s\n' "$1"; }
fail() { FAILED+=("$1: $2"); printf '  FAIL  %s\n        %s\n' "$1" "$2"; }
skip() { SKIPPED+=("$1: $2"); printf '  SKIP  %s (%s)\n' "$1" "$2"; }

# Build and test the system in a tree.
#
# Returns 0 when everything built, the number of failures when something did
# not, and BUILD_NOTHING when there was nothing recognisable to build. That
# third case has to be distinguishable: a silent "no projects found" would
# otherwise be indistinguishable from success, and a gate that passes without
# building anything is worse than no gate.
#
# --build-command overrides the default for a system this does not fit. It runs
# once, from the root of the tree, and its exit status decides.
BUILD_NOTHING=250

build_all() {
    local tree="$1" log="$2"

    if [[ -n "$BUILD_COMMAND" ]]; then
        if (cd "$tree" && bash -c "$BUILD_COMMAND") >> "$log" 2>&1; then
            return 0
        fi
        echo "FAILED: $BUILD_COMMAND" >> "$log"
        return 1
    fi

    # The default: each Maven project under the root has its own wrapper, so
    # this is "every project", not one reactor build.
    local failures=0 projects=0
    while IFS= read -r wrapper; do
        local project
        project="$(dirname "$wrapper")"
        projects=$((projects + 1))
        if ! (cd "$project" && ./mvnw -q -DskipTests=false test) >> "$log" 2>&1; then
            echo "FAILED: ${project#$tree/}" >> "$log"
            failures=$((failures + 1))
        fi
    done < <(find "$tree" -maxdepth 2 -name mvnw -not -path "*/.git/*")

    if (( projects == 0 )); then
        echo "NOTHING TO BUILD: no Maven wrapper found under $tree" >> "$log"
        return $BUILD_NOTHING
    fi
    return $failures
}

echo "Verifying $(basename "$PROPOSAL")"
echo

# ---------------------------------------------------------------- gate 3 (before)
BEFORE=""
if [[ "$SKIP_SMELL" == 0 ]]; then
    BEFORE_REPORT="$(mktemp -t lemma-before)"
    if "$BUNDLE/tools/detect-smells.sh" "$MODELS" --report "$BEFORE_REPORT" > /dev/null 2>&1 \
        || [[ $? -eq 1 ]]; then
        BEFORE="$(grep -m1 '^| Findings |' "$BEFORE_REPORT" | tr -dc '0-9')"
    fi
    if [[ -z "$BEFORE" ]]; then
        skip "baseline" "the finding count could not be read before patching"
        SKIP_SMELL=1
    else
        echo "  baseline: $BEFORE finding(s) before the patch"
    fi
fi

# ---------------------------------------------------------------- gate 1: clean
CLEAN="$(mktemp -d -t lemma-clean)"
rm -rf "$CLEAN"
if git -C "$SOURCE" worktree add --detach "$CLEAN" "$BASE" > /dev/null 2>&1; then
    if git -C "$CLEAN" apply "$PATCH" > /dev/null 2>&1; then
        CLEAN_LOG="$(mktemp -t lemma-clean-build)"
        build_all "$CLEAN" "$CLEAN_LOG"; CLEAN_STATUS=$?
        if (( CLEAN_STATUS == 0 )); then
            pass "clean: the patch applies to a clean checkout and the build is green"
        elif (( CLEAN_STATUS == BUILD_NOTHING )); then
            skip "clean" "nothing recognisable to build in this system; pass --build-command to say how"
        else
            fail "clean" "the build fails on a clean checkout with no generated key material: $(grep -m2 '^FAILED:' "$CLEAN_LOG" | tr '\n' ' ')see $CLEAN_LOG"
        fi
    else
        fail "clean" "the patch does not apply to a clean checkout of $BASE"
    fi
    git -C "$SOURCE" worktree remove --force "$CLEAN" > /dev/null 2>&1
else
    fail "clean" "a clean worktree could not be created"
fi

# ---------------------------------------------------------------- gate 2: in place
WORK="$(mktemp -d -t lemma-work)"
rm -rf "$WORK"
BRANCH="refactoring/$(basename "$PROPOSAL")"
if git -C "$SOURCE" worktree add --detach "$WORK" "$BASE" > /dev/null 2>&1 \
    && git -C "$WORK" apply "$PATCH" > /dev/null 2>&1; then
    git -C "$WORK" checkout -q -b "$BRANCH" 2>/dev/null || true

    # Without key material this gate is gate 1 again, so it has to either
    # generate the material or admit it measured nothing. Mutual TLS needs a
    # key store per peer, and a patch that does it properly ships the script
    # that makes them - rc1 and rc2 both did, under slightly different names.
    MATERIAL=""
    if [[ -n "$CERTS" ]]; then
        MATERIAL="$CERTS"
    else
        GENERATOR="$(find "$WORK" -maxdepth 1 -name 'generate*certificate*' -o \
                     -maxdepth 1 -name 'generate*certs*' | head -1)"
        [[ -n "$GENERATOR" ]] && MATERIAL="bash '$GENERATOR'"
    fi

    if [[ -z "$MATERIAL" ]]; then
        skip "inplace" "no key-material command and none found in the patch, so this would only repeat the clean gate"
    else
        if ! (cd "$WORK" && bash -c "$MATERIAL") > /dev/null 2>&1; then
            fail "inplace" "the key-material command failed, so the patch cannot be built at all"
        else
            WORK_LOG="$(mktemp -t lemma-work-build)"
            build_all "$WORK" "$WORK_LOG"; WORK_STATUS=$?
            if (( WORK_STATUS == 0 )); then
                pass "inplace: the build is green once key material exists"
            elif (( WORK_STATUS == BUILD_NOTHING )); then
                skip "inplace" "nothing recognisable to build in this system; pass --build-command to say how"
            else
                fail "inplace" "the build fails even with key material: $(grep -m2 '^FAILED:' "$WORK_LOG" | tr '\n' ' ')see $WORK_LOG"
            fi
        fi
    fi
else
    fail "inplace" "the patch could not be applied to a working tree"
fi

# ---------------------------------------------------------------- gate 3: smell
if [[ "$SKIP_SMELL" == 1 ]]; then
    skip "smell" "not measured"
elif [[ -z "$MRF" ]]; then
    skip "smell" "no --mrf given, so the system cannot be re-reconstructed"
else
    AFTER_MODELS="$(mktemp -d -t lemma-after-models)"
    # shellcheck disable=SC2086
    if (cd "$MRF" && uv run mrf -r -p $PLUGINS -t "$WORK") > /dev/null 2>&1 \
        && "$WORKSPACE/de.fhdo.lemma.reconstruction/tools/reconstruct.sh" \
            --target "$AFTER_MODELS" > /dev/null 2>&1; then
        AFTER_REPORT="$(mktemp -t lemma-after)"
        "$BUNDLE/tools/detect-smells.sh" "$AFTER_MODELS" --report "$AFTER_REPORT" \
            > /dev/null 2>&1
        AFTER="$(grep -m1 '^| Findings |' "$AFTER_REPORT" | tr -dc '0-9')"
        if [[ -z "$AFTER" ]]; then
            fail "smell" "the finding count could not be read after patching"
        elif (( AFTER < BEFORE )); then
            pass "smell: findings fell from $BEFORE to $AFTER"
        else
            fail "smell" "findings did not fall: $BEFORE before, $AFTER after"
        fi
    else
        fail "smell" "the system could not be re-reconstructed from the patched tree"
    fi
fi

# ---------------------------------------------------------------- gate 4: starts
if [[ "$SKIP_START" == 1 ]]; then
    skip "starts" "asked to skip"
elif [[ ! -f "$WORK/docker-compose.yml" ]]; then
    skip "starts" "the system has no docker-compose.yml"
elif ! command -v docker > /dev/null 2>&1; then
    skip "starts" "docker is not available"
else
    # --build matters: the compose file names published images as well as build
    # contexts, so without it a stale image would be started and the gate would
    # report on code the patch never touched.
    START_LOG="$(mktemp -t lemma-start)"
    if (cd "$WORK" && docker compose up -d --build --wait) > "$START_LOG" 2>&1; then
        pass "starts: the system comes up with the patch applied"
        (cd "$WORK" && docker compose down -v) >> "$START_LOG" 2>&1
    else
        # Which services are unhealthy is the whole value of this gate, so it
        # is captured before the stack is torn down.
        (cd "$WORK" && docker compose ps -a) >> "$START_LOG" 2>&1
        (cd "$WORK" && docker compose logs --tail 40) >> "$START_LOG" 2>&1
        UNHEALTHY="$(grep -oE "(container|service) \"?[a-z0-9_-]+\"? is unhealthy" "$START_LOG" \
            | head -3 | tr '\n' ' ')"
        (cd "$WORK" && docker compose down -v) >> "$START_LOG" 2>&1

        # This gate needs a baseline as much as the smell gate does. A sample
        # system whose base image has been withdrawn from the registry, or whose
        # build is broken for any other reason of its own, does not come up
        # patched or unpatched - and blaming the patch for that is a false
        # finding. The control runs only on failure, because it costs a second
        # full build.
        CONTROL="$(mktemp -d -t lemma-control)"; rm -rf "$CONTROL"
        CONTROL_LOG="$(mktemp -t lemma-control)"
        CONTROL_STARTS=1
        if git -C "$SOURCE" worktree add --detach "$CONTROL" "$BASE" > /dev/null 2>&1; then
            if ! (cd "$CONTROL" && docker compose up -d --build --wait) \
                > "$CONTROL_LOG" 2>&1; then
                CONTROL_STARTS=0
            fi
            (cd "$CONTROL" && docker compose down -v) >> "$CONTROL_LOG" 2>&1
            git -C "$SOURCE" worktree remove --force "$CONTROL" > /dev/null 2>&1
        fi

        if [[ "$CONTROL_STARTS" == 0 ]]; then
            WHY="$(grep -oE "[^ ]+: not found|failed to solve: [^ ]+" "$CONTROL_LOG" \
                | head -1)"
            skip "starts" "the system does not come up unpatched either${WHY:+ ($WHY)}, so this gate cannot attribute anything to the patch; see $CONTROL_LOG"
        else
            fail "starts" "the system does not come up with the patch applied, though it does unpatched: ${UNHEALTHY:+$UNHEALTHY, }see $START_LOG"
        fi
    fi
fi

git -C "$SOURCE" worktree remove --force "$WORK" > /dev/null 2>&1
git -C "$SOURCE" worktree prune > /dev/null 2>&1

# ---------------------------------------------------------------- the verdict
echo
VERDICT="VERIFIED"
if (( ${#FAILED[@]} > 0 )); then
    VERDICT="NOT VERIFIED"
elif (( ${#SKIPPED[@]} > 0 )); then
    VERDICT="PARTIAL"
fi
echo "$VERDICT — ${#PASSED[@]} passed, ${#FAILED[@]} failed, ${#SKIPPED[@]} skipped"

{
    echo
    echo "## Verification, $(date -u '+%Y-%m-%dT%H:%M:%SZ')"
    echo
    echo "**$VERDICT** — ${#PASSED[@]} passed, ${#FAILED[@]} failed, ${#SKIPPED[@]} skipped."
    echo
    for entry in "${PASSED[@]:-}";  do [[ -n "$entry" ]] && echo "- PASS $entry"; done
    for entry in "${FAILED[@]:-}";  do [[ -n "$entry" ]] && echo "- FAIL $entry"; done
    for entry in "${SKIPPED[@]:-}"; do [[ -n "$entry" ]] && echo "- SKIP $entry"; done
    echo
    echo "A skipped gate is not a passed one: PARTIAL means the refactoring has"
    echo "not been shown to resolve the smell, only that nothing checked"
    echo "contradicts it."
} >> "$PROPOSAL/verification.md"

(( ${#FAILED[@]} == 0 )) || exit 1
(( ${#SKIPPED[@]} == 0 )) || exit 3
exit 0
