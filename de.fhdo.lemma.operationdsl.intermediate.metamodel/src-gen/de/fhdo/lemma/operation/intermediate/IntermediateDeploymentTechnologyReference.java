/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a reference to a intermediate technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateDeploymentTechnology <em>Intermediate Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateContainer <em>Intermediate Container</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference()
 * @model
 * @generated
 */
public interface IntermediateDeploymentTechnologyReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Intermediate Deployment Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Deployment Technology</em>' reference.
	 * @see #setIntermediateDeploymentTechnology(IntermediateDeploymentTechnology)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference_IntermediateDeploymentTechnology()
	 * @model
	 * @generated
	 */
	IntermediateDeploymentTechnology getIntermediateDeploymentTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateDeploymentTechnology <em>Intermediate Deployment Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Deployment Technology</em>' reference.
	 * @see #getIntermediateDeploymentTechnology()
	 * @generated
	 */
	void setIntermediateDeploymentTechnology(IntermediateDeploymentTechnology value);

	/**
	 * Returns the value of the '<em><b>Intermediate Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Import</em>' reference.
	 * @see #setIntermediateImport(IntermediateImport)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference_IntermediateImport()
	 * @model
	 * @generated
	 */
	IntermediateImport getIntermediateImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateImport <em>Intermediate Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Import</em>' reference.
	 * @see #getIntermediateImport()
	 * @generated
	 */
	void setIntermediateImport(IntermediateImport value);

	/**
	 * Returns the value of the '<em><b>Intermediate Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateDeploymentTechnologyReference <em>Intermediate Deployment Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Container</em>' container reference.
	 * @see #setIntermediateContainer(IntermediateContainer)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference_IntermediateContainer()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateDeploymentTechnologyReference
	 * @model opposite="intermediateDeploymentTechnologyReference" transient="false"
	 * @generated
	 */
	IntermediateContainer getIntermediateContainer();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateContainer <em>Intermediate Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Container</em>' container reference.
	 * @see #getIntermediateContainer()
	 * @generated
	 */
	void setIntermediateContainer(IntermediateContainer value);

} // IntermediateDeploymentTechnologyReference
