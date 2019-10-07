/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Value assignment to a intermediate technology specific property
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getValue <em>Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificPropertyValue()
 * @model
 * @generated
 */
public interface IntermediateTechnologySpecificPropertyValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificPropertyValue_Value()
	 * @model unique="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getPropertyValues <em>Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' container reference.
	 * @see #setSpecification(IntermediateServiceDeploymentSpecification)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificPropertyValue_Specification()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getPropertyValues
	 * @model opposite="propertyValues" transient="false"
	 * @generated
	 */
	IntermediateServiceDeploymentSpecification getSpecification();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getSpecification <em>Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' container reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(IntermediateServiceDeploymentSpecification value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getPropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' container reference.
	 * @see #setProperty(IntermediateTechnologySpecificProperty)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificPropertyValue_Property()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getPropertyValue
	 * @model opposite="propertyValue" transient="false"
	 * @generated
	 */
	IntermediateTechnologySpecificProperty getProperty();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getProperty <em>Property</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' container reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(IntermediateTechnologySpecificProperty value);

} // IntermediateTechnologySpecificPropertyValue
