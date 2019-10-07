/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Abstract superclass of technologies specific to intermediate service operation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getIntermediateOperationEnvironment <em>Intermediate Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getIntermediateTechnologySpecificProperty <em>Intermediate Technology Specific Property</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology()
 * @model abstract="true"
 * @generated
 */
public interface IntermediateOperationTechnology extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Intermediate Operation Environment</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getIntermediateOperationtechnology <em>Intermediate Operationtechnology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Operation Environment</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology_IntermediateOperationEnvironment()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getIntermediateOperationtechnology
	 * @model opposite="intermediateOperationtechnology" containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateOperationEnvironment> getIntermediateOperationEnvironment();

	/**
	 * Returns the value of the '<em><b>Intermediate Technology Specific Property</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateOperationTechnology <em>Intermediate Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Technology Specific Property</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology_IntermediateTechnologySpecificProperty()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateOperationTechnology
	 * @model opposite="intermediateOperationTechnology" containment="true"
	 * @generated
	 */
	EList<IntermediateTechnologySpecificProperty> getIntermediateTechnologySpecificProperty();

} // IntermediateOperationTechnology
