/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A property, e.g., of an intermediate operation technology that may be set per associated
 * service or an aspect
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getFeatureames <em>Featureames</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getOperationTechnology <em>Operation Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificProperty()
 * @model
 * @generated
 */
public interface IntermediateTechnologySpecificProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificProperty_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificProperty_Type()
	 * @model unique="false"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificProperty_DefaultValue()
	 * @model unique="false"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Featureames</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featureames</em>' attribute list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificProperty_Featureames()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getFeatureames();

	/**
	 * Returns the value of the '<em><b>Property Value</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value</em>' containment reference.
	 * @see #setPropertyValue(IntermediateTechnologySpecificPropertyValue)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificProperty_PropertyValue()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getProperty
	 * @model opposite="property" containment="true"
	 * @generated
	 */
	IntermediateTechnologySpecificPropertyValue getPropertyValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getPropertyValue <em>Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Value</em>' containment reference.
	 * @see #getPropertyValue()
	 * @generated
	 */
	void setPropertyValue(IntermediateTechnologySpecificPropertyValue value);

	/**
	 * Returns the value of the '<em><b>Operation Technology</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getPropertys <em>Propertys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Technology</em>' container reference.
	 * @see #setOperationTechnology(IntermediateOperationTechnology)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificProperty_OperationTechnology()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getPropertys
	 * @model opposite="propertys" transient="false"
	 * @generated
	 */
	IntermediateOperationTechnology getOperationTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getOperationTechnology <em>Operation Technology</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Technology</em>' container reference.
	 * @see #getOperationTechnology()
	 * @generated
	 */
	void setOperationTechnology(IntermediateOperationTechnology value);

} // IntermediateTechnologySpecificProperty
