/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel of intermediate operation models.
 *  * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateContainer <em>Intermediate Container</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel()
 * @model
 * @generated
 */
public interface IntermediateOperationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Model Uri</em>' attribute.
	 * @see #setSourceModelUri(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_SourceModelUri()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceModelUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri <em>Source Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Model Uri</em>' attribute.
	 * @see #getSourceModelUri()
	 * @generated
	 */
	void setSourceModelUri(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntermediateImport> getImports();

	/**
	 * Returns the value of the '<em><b>Intermediate Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateContainer}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateOperationModel <em>Intermediate Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Container</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_IntermediateContainer()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateOperationModel
	 * @model opposite="intermediateOperationModel" containment="true"
	 * @generated
	 */
	EList<IntermediateContainer> getIntermediateContainer();

	/**
	 * Returns the value of the '<em><b>Intermediate Infrastructure Node</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateOperationModel <em>Intermediate Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Infrastructure Node</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_IntermediateInfrastructureNode()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateOperationModel
	 * @model opposite="intermediateOperationModel" containment="true"
	 * @generated
	 */
	EList<IntermediateInfrastructureNode> getIntermediateInfrastructureNode();

} // IntermediateOperationModel
