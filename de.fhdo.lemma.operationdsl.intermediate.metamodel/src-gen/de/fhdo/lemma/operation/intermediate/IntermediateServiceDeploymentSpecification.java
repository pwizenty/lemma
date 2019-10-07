/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Deployment Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents the further specification of a service being deployed to an intermediate operation node
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationMicroserviceReference <em>Operation Microservice Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateTechnologySpecificPropertyValue <em>Intermediate Technology Specific Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateEndpoints <em>Intermediate Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateOperationNode <em>Intermediate Operation Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification()
 * @model
 * @generated
 */
public interface IntermediateServiceDeploymentSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation Microservice Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Microservice Reference</em>' reference.
	 * @see #setOperationMicroserviceReference(OperationMicroserviceReference)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_OperationMicroserviceReference()
	 * @model
	 * @generated
	 */
	OperationMicroserviceReference getOperationMicroserviceReference();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationMicroserviceReference <em>Operation Microservice Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Microservice Reference</em>' reference.
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	void setOperationMicroserviceReference(OperationMicroserviceReference value);

	/**
	 * Returns the value of the '<em><b>Intermediate Technology Specific Property Value</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Technology Specific Property Value</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_IntermediateTechnologySpecificPropertyValue()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateServiceDeploymentSpecification
	 * @model opposite="intermediateServiceDeploymentSpecification" containment="true"
	 * @generated
	 */
	EList<IntermediateTechnologySpecificPropertyValue> getIntermediateTechnologySpecificPropertyValue();

	/**
	 * Returns the value of the '<em><b>Intermediate Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_IntermediateEndpoints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateEndpoint> getIntermediateEndpoints();

	/**
	 * Returns the value of the '<em><b>Intermediate Operation Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Operation Node</em>' container reference.
	 * @see #setIntermediateOperationNode(IntermediateOperationNode)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_IntermediateOperationNode()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateServiceDeploymentSpecification
	 * @model opposite="intermediateServiceDeploymentSpecification" transient="false"
	 * @generated
	 */
	IntermediateOperationNode getIntermediateOperationNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateOperationNode <em>Intermediate Operation Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Operation Node</em>' container reference.
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	void setIntermediateOperationNode(IntermediateOperationNode value);

} // IntermediateServiceDeploymentSpecification
