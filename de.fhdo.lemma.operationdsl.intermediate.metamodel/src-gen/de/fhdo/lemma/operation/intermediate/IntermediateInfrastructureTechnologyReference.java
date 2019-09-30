/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to a infrastructure technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureTechnology <em>Intermediate Infrastructure Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference()
 * @model
 * @generated
 */
public interface IntermediateInfrastructureTechnologyReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Intermediate Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Import</em>' reference.
	 * @see #setIntermediateImport(IntermediateImport)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference_IntermediateImport()
	 * @model
	 * @generated
	 */
	IntermediateImport getIntermediateImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateImport <em>Intermediate Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Import</em>' reference.
	 * @see #getIntermediateImport()
	 * @generated
	 */
	void setIntermediateImport(IntermediateImport value);

	/**
	 * Returns the value of the '<em><b>Intermediate Infrastructure Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Infrastructure Technology</em>' reference.
	 * @see #setIntermediateInfrastructureTechnology(IntermediateInfrastructureTechnology)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference_IntermediateInfrastructureTechnology()
	 * @model
	 * @generated
	 */
	IntermediateInfrastructureTechnology getIntermediateInfrastructureTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureTechnology <em>Intermediate Infrastructure Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Infrastructure Technology</em>' reference.
	 * @see #getIntermediateInfrastructureTechnology()
	 * @generated
	 */
	void setIntermediateInfrastructureTechnology(IntermediateInfrastructureTechnology value);

	/**
	 * Returns the value of the '<em><b>Intermediate Infrastructure Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateInfrastructureTechnologyReference <em>Intermediate Infrastructure Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Infrastructure Node</em>' container reference.
	 * @see #setIntermediateInfrastructureNode(IntermediateInfrastructureNode)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference_IntermediateInfrastructureNode()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateInfrastructureTechnologyReference
	 * @model opposite="intermediateInfrastructureTechnologyReference" transient="false"
	 * @generated
	 */
	IntermediateInfrastructureNode getIntermediateInfrastructureNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Infrastructure Node</em>' container reference.
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	void setIntermediateInfrastructureNode(IntermediateInfrastructureNode value);

} // IntermediateInfrastructureTechnologyReference
