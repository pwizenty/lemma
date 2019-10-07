/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An intermediate operation node is a node to which services may be deployed, e.g., a container or some
 * infrastructure component like a configuration provider or database
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateOperationEnvironment <em>Intermediate Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getOperationMicroserviceReferences <em>Operation Microservice References</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode()
 * @model abstract="true"
 * @generated
 */
public interface IntermediateOperationNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Intermediate Import</b></em>' reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Import</em>' reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_IntermediateImport()
	 * @model required="true"
	 * @generated
	 */
	EList<IntermediateImport> getIntermediateImport();

	/**
	 * Returns the value of the '<em><b>Intermediate Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Operation Environment</em>' reference.
	 * @see #setIntermediateOperationEnvironment(IntermediateOperationEnvironment)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_IntermediateOperationEnvironment()
	 * @model
	 * @generated
	 */
	IntermediateOperationEnvironment getIntermediateOperationEnvironment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateOperationEnvironment <em>Intermediate Operation Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Operation Environment</em>' reference.
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 */
	void setIntermediateOperationEnvironment(IntermediateOperationEnvironment value);

	/**
	 * Returns the value of the '<em><b>Operation Microservice References</b></em>' reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Microservice References</em>' reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_OperationMicroserviceReferences()
	 * @model
	 * @generated
	 */
	EList<OperationMicroserviceReference> getOperationMicroserviceReferences();

	/**
	 * Returns the value of the '<em><b>Intermediate Service Deployment Specification</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateOperationNode <em>Intermediate Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Service Deployment Specification</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_IntermediateServiceDeploymentSpecification()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateOperationNode
	 * @model opposite="intermediateOperationNode" containment="true"
	 * @generated
	 */
	EList<IntermediateServiceDeploymentSpecification> getIntermediateServiceDeploymentSpecification();

} // IntermediateOperationNode
