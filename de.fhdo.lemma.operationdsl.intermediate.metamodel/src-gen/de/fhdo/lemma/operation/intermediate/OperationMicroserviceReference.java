/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.Visibility;

import de.fhdo.lemma.service.intermediate.MicroserviceReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Microservice Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to a operational microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType <em>Microservice Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getService <em>Service</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getSpecification <em>Specification</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference()
 * @model
 * @generated
 */
public interface OperationMicroserviceReference extends MicroserviceReference {
	/**
	 * Returns the value of the '<em><b>Effectively Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effectively Implemented</em>' attribute.
	 * @see #setEffectivelyImplemented(boolean)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_EffectivelyImplemented()
	 * @model unique="false"
	 * @generated
	 */
	boolean isEffectivelyImplemented();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented <em>Effectively Implemented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effectively Implemented</em>' attribute.
	 * @see #isEffectivelyImplemented()
	 * @generated
	 */
	void setEffectivelyImplemented(boolean value);

	/**
	 * Returns the value of the '<em><b>Microservice Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.MicroserviceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice Type</em>' attribute.
	 * @see de.fhdo.lemma.service.MicroserviceType
	 * @see #setMicroserviceType(MicroserviceType)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_MicroserviceType()
	 * @model unique="false"
	 * @generated
	 */
	MicroserviceType getMicroserviceType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType <em>Microservice Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice Type</em>' attribute.
	 * @see de.fhdo.lemma.service.MicroserviceType
	 * @see #getMicroserviceType()
	 * @generated
	 */
	void setMicroserviceType(MicroserviceType value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.Visibility}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see #setVisibility(Visibility)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_Visibility()
	 * @model unique="false"
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);

	/**
	 * Returns the value of the '<em><b>Intermediate Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Import</em>' reference.
	 * @see #setIntermediateImport(IntermediateImport)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_IntermediateImport()
	 * @model
	 * @generated
	 */
	IntermediateImport getIntermediateImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getIntermediateImport <em>Intermediate Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Import</em>' reference.
	 * @see #getIntermediateImport()
	 * @generated
	 */
	void setIntermediateImport(IntermediateImport value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDeployedServices <em>Deployed Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' container reference.
	 * @see #setService(IntermediateOperationNode)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_Service()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDeployedServices
	 * @model opposite="deployedServices" transient="false"
	 * @generated
	 */
	IntermediateOperationNode getService();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getService <em>Service</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' container reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(IntermediateOperationNode value);

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' container reference.
	 * @see #setSpecification(IntermediateServiceDeploymentSpecification)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_Specification()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getService
	 * @model opposite="service" transient="false"
	 * @generated
	 */
	IntermediateServiceDeploymentSpecification getSpecification();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getSpecification <em>Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' container reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(IntermediateServiceDeploymentSpecification value);

} // OperationMicroserviceReference
