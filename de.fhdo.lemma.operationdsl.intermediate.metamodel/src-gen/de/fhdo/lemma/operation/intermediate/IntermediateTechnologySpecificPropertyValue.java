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
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateTechnologySpecificProperty <em>Intermediate Technology Specific Property</em>}</li>
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
	 * Returns the value of the '<em><b>Intermediate Service Deployment Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateTechnologySpecificPropertyValue <em>Intermediate Technology Specific Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Service Deployment Specification</em>' container reference.
	 * @see #setIntermediateServiceDeploymentSpecification(IntermediateServiceDeploymentSpecification)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificPropertyValue_IntermediateServiceDeploymentSpecification()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateTechnologySpecificPropertyValue
	 * @model opposite="intermediateTechnologySpecificPropertyValue" transient="false"
	 * @generated
	 */
	IntermediateServiceDeploymentSpecification getIntermediateServiceDeploymentSpecification();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Service Deployment Specification</em>' container reference.
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	void setIntermediateServiceDeploymentSpecification(IntermediateServiceDeploymentSpecification value);

	/**
	 * Returns the value of the '<em><b>Intermediate Technology Specific Property</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateTechnologySpecificPropertyValue <em>Intermediate Technology Specific Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Technology Specific Property</em>' container reference.
	 * @see #setIntermediateTechnologySpecificProperty(IntermediateTechnologySpecificProperty)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateTechnologySpecificPropertyValue_IntermediateTechnologySpecificProperty()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateTechnologySpecificPropertyValue
	 * @model opposite="intermediateTechnologySpecificPropertyValue" transient="false"
	 * @generated
	 */
	IntermediateTechnologySpecificProperty getIntermediateTechnologySpecificProperty();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateTechnologySpecificProperty <em>Intermediate Technology Specific Property</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Technology Specific Property</em>' container reference.
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	void setIntermediateTechnologySpecificProperty(IntermediateTechnologySpecificProperty value);

} // IntermediateTechnologySpecificPropertyValue
