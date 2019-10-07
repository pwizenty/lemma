/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An intermediate infrastructure node is an operation node with supporting character, e.g., a configuration
 * provider
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getDependentOperationNodes <em>Dependent Operation Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getUsedByOperationNodes <em>Used By Operation Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateInfrastructureTechnologyReference <em>Intermediate Infrastructure Technology Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateEndpoint <em>Intermediate Endpoint</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateOperationModel <em>Intermediate Operation Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode()
 * @model
 * @generated
 */
public interface IntermediateInfrastructureNode extends IntermediateOperationNode {
	/**
	 * Returns the value of the '<em><b>Dependent Operation Nodes</b></em>' reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependent Operation Nodes</em>' reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode_DependentOperationNodes()
	 * @model
	 * @generated
	 */
	EList<IntermediateOperationNode> getDependentOperationNodes();

	/**
	 * Returns the value of the '<em><b>Used By Operation Nodes</b></em>' reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used By Operation Nodes</em>' reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode_UsedByOperationNodes()
	 * @model
	 * @generated
	 */
	EList<IntermediateOperationNode> getUsedByOperationNodes();

	/**
	 * Returns the value of the '<em><b>Intermediate Infrastructure Technology Reference</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Infrastructure Technology Reference</em>' containment reference.
	 * @see #setIntermediateInfrastructureTechnologyReference(IntermediateInfrastructureTechnologyReference)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode_IntermediateInfrastructureTechnologyReference()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureNode
	 * @model opposite="intermediateInfrastructureNode" containment="true"
	 * @generated
	 */
	IntermediateInfrastructureTechnologyReference getIntermediateInfrastructureTechnologyReference();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateInfrastructureTechnologyReference <em>Intermediate Infrastructure Technology Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Infrastructure Technology Reference</em>' containment reference.
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	void setIntermediateInfrastructureTechnologyReference(IntermediateInfrastructureTechnologyReference value);

	/**
	 * Returns the value of the '<em><b>Intermediate Endpoint</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Endpoint</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode_IntermediateEndpoint()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateEndpoint> getIntermediateEndpoint();

	/**
	 * Returns the value of the '<em><b>Intermediate Operation Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Operation Model</em>' container reference.
	 * @see #setIntermediateOperationModel(IntermediateOperationModel)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode_IntermediateOperationModel()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateInfrastructureNode
	 * @model opposite="intermediateInfrastructureNode" transient="false"
	 * @generated
	 */
	IntermediateOperationModel getIntermediateOperationModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateOperationModel <em>Intermediate Operation Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Operation Model</em>' container reference.
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	void setIntermediateOperationModel(IntermediateOperationModel value);

} // IntermediateInfrastructureNode
