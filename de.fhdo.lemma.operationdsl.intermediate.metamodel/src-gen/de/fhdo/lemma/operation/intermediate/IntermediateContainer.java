/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A intermediate container is the central operation node. It enables service deployment and operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateDeploymentTechnologyReference <em>Intermediate Deployment Technology Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateEndpoint <em>Intermediate Endpoint</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateOperationModel <em>Intermediate Operation Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateContainer()
 * @model
 * @generated
 */
public interface IntermediateContainer extends IntermediateOperationNode {
	/**
	 * Returns the value of the '<em><b>Intermediate Deployment Technology Reference</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateContainer <em>Intermediate Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Deployment Technology Reference</em>' containment reference.
	 * @see #setIntermediateDeploymentTechnologyReference(IntermediateDeploymentTechnologyReference)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateContainer_IntermediateDeploymentTechnologyReference()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateContainer
	 * @model opposite="intermediateContainer" containment="true"
	 * @generated
	 */
	IntermediateDeploymentTechnologyReference getIntermediateDeploymentTechnologyReference();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateDeploymentTechnologyReference <em>Intermediate Deployment Technology Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Deployment Technology Reference</em>' containment reference.
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	void setIntermediateDeploymentTechnologyReference(IntermediateDeploymentTechnologyReference value);

	/**
	 * Returns the value of the '<em><b>Intermediate Endpoint</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Endpoint</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateContainer_IntermediateEndpoint()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateEndpoint> getIntermediateEndpoint();

	/**
	 * Returns the value of the '<em><b>Intermediate Operation Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateContainer <em>Intermediate Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Operation Model</em>' container reference.
	 * @see #setIntermediateOperationModel(IntermediateOperationModel)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateContainer_IntermediateOperationModel()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateContainer
	 * @model opposite="intermediateContainer" transient="false"
	 * @generated
	 */
	IntermediateOperationModel getIntermediateOperationModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateOperationModel <em>Intermediate Operation Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Operation Model</em>' container reference.
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	void setIntermediateOperationModel(IntermediateOperationModel value);

} // IntermediateContainer
