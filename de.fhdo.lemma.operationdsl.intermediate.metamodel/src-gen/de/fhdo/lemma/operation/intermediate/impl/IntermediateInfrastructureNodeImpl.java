/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getDependsOnNodes <em>Depends On Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getUsedByNodes <em>Used By Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateInfrastructureNodeImpl extends IntermediateOperationNodeImpl implements IntermediateInfrastructureNode {
	/**
	 * The cached value of the '{@link #getDependsOnNodes() <em>Depends On Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOnNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateOperationNode> dependsOnNodes;

	/**
	 * The cached value of the '{@link #getUsedByNodes() <em>Used By Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedByNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateOperationNode> usedByNodes;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected IntermediateInfrastructureTechnologyReference reference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateInfrastructureNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_INFRASTRUCTURE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateOperationNode> getDependsOnNodes() {
		if (dependsOnNodes == null) {
			dependsOnNodes = new EObjectResolvingEList<IntermediateOperationNode>(IntermediateOperationNode.class, this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDS_ON_NODES);
		}
		return dependsOnNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateOperationNode> getUsedByNodes() {
		if (usedByNodes == null) {
			usedByNodes = new EObjectResolvingEList<IntermediateOperationNode>(IntermediateOperationNode.class, this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_NODES);
		}
		return usedByNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureTechnologyReference getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReference(IntermediateInfrastructureTechnologyReference newReference, NotificationChain msgs) {
		IntermediateInfrastructureTechnologyReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE, oldReference, newReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(IntermediateInfrastructureTechnologyReference newReference) {
		if (newReference != reference) {
			NotificationChain msgs = null;
			if (reference != null)
				msgs = ((InternalEObject)reference).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE, IntermediateInfrastructureTechnologyReference.class, msgs);
			if (newReference != null)
				msgs = ((InternalEObject)newReference).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE, IntermediateInfrastructureTechnologyReference.class, msgs);
			msgs = basicSetReference(newReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE, newReference, newReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationModel getOperationModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL) return null;
		return (IntermediateOperationModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationModel basicGetOperationModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL) return null;
		return (IntermediateOperationModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationModel(IntermediateOperationModel newOperationModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperationModel, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationModel(IntermediateOperationModel newOperationModel) {
		if (newOperationModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL && newOperationModel != null)) {
			if (EcoreUtil.isAncestor(this, newOperationModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperationModel != null)
				msgs = ((InternalEObject)newOperationModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES, IntermediateOperationModel.class, msgs);
			msgs = basicSetOperationModel(newOperationModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL, newOperationModel, newOperationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE:
				if (reference != null)
					msgs = ((InternalEObject)reference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE, null, msgs);
				return basicSetReference((IntermediateInfrastructureTechnologyReference)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperationModel((IntermediateOperationModel)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE:
				return basicSetReference(null, msgs);
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL:
				return basicSetOperationModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES, IntermediateOperationModel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDS_ON_NODES:
				return getDependsOnNodes();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_NODES:
				return getUsedByNodes();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE:
				return getReference();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL:
				if (resolve) return getOperationModel();
				return basicGetOperationModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDS_ON_NODES:
				getDependsOnNodes().clear();
				getDependsOnNodes().addAll((Collection<? extends IntermediateOperationNode>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_NODES:
				getUsedByNodes().clear();
				getUsedByNodes().addAll((Collection<? extends IntermediateOperationNode>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE:
				setReference((IntermediateInfrastructureTechnologyReference)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL:
				setOperationModel((IntermediateOperationModel)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDS_ON_NODES:
				getDependsOnNodes().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_NODES:
				getUsedByNodes().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE:
				setReference((IntermediateInfrastructureTechnologyReference)null);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL:
				setOperationModel((IntermediateOperationModel)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDS_ON_NODES:
				return dependsOnNodes != null && !dependsOnNodes.isEmpty();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_NODES:
				return usedByNodes != null && !usedByNodes.isEmpty();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE:
				return reference != null;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL:
				return basicGetOperationModel() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateInfrastructureNodeImpl
