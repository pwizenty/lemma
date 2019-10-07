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
 * Represents the further specification of a service being deployed to an
 * intermediate operation node
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getService <em>Service</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationNode <em>Operation Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification()
 * @model
 * @generated
 */
public interface IntermediateServiceDeploymentSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' containment reference.
	 * @see #setService(OperationMicroserviceReference)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_Service()
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getSpecification
	 * @model opposite="specification" containment="true"
	 * @generated
	 */
	OperationMicroserviceReference getService();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getService <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' containment reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(OperationMicroserviceReference value);

	/**
	 * Returns the value of the '<em><b>Property Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Values</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_PropertyValues()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getSpecification
	 * @model opposite="specification" containment="true"
	 * @generated
	 */
	EList<IntermediateTechnologySpecificPropertyValue> getPropertyValues();

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_Endpoints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateEndpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Operation Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getSpecifications <em>Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Node</em>' container reference.
	 * @see #setOperationNode(IntermediateOperationNode)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateServiceDeploymentSpecification_OperationNode()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getSpecifications
	 * @model opposite="specifications" transient="false"
	 * @generated
	 */
	IntermediateOperationNode getOperationNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationNode <em>Operation Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Node</em>' container reference.
	 * @see #getOperationNode()
	 * @generated
	 */
	void setOperationNode(IntermediateOperationNode value);

} // IntermediateServiceDeploymentSpecification
