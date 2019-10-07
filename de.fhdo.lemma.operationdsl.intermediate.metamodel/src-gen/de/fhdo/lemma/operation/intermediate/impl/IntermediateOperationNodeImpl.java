/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getIntermediateOperationEnvironment <em>Intermediate Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getOperationMicroserviceReferences <em>Operation Microservice References</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntermediateOperationNodeImpl extends MinimalEObjectImpl.Container implements IntermediateOperationNode {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIntermediateImport() <em>Intermediate Import</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateImport()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateImport> intermediateImport;

	/**
	 * The cached value of the '{@link #getIntermediateOperationEnvironment() <em>Intermediate Operation Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 * @ordered
	 */
	protected IntermediateOperationEnvironment intermediateOperationEnvironment;

	/**
	 * The cached value of the '{@link #getOperationMicroserviceReferences() <em>Operation Microservice References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationMicroserviceReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationMicroserviceReference> operationMicroserviceReferences;

	/**
	 * The cached value of the '{@link #getIntermediateServiceDeploymentSpecification() <em>Intermediate Service Deployment Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateServiceDeploymentSpecification> intermediateServiceDeploymentSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateOperationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateImport> getIntermediateImport() {
		if (intermediateImport == null) {
			intermediateImport = new EObjectResolvingEList<IntermediateImport>(IntermediateImport.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT);
		}
		return intermediateImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationEnvironment getIntermediateOperationEnvironment() {
		if (intermediateOperationEnvironment != null && intermediateOperationEnvironment.eIsProxy()) {
			InternalEObject oldIntermediateOperationEnvironment = (InternalEObject)intermediateOperationEnvironment;
			intermediateOperationEnvironment = (IntermediateOperationEnvironment)eResolveProxy(oldIntermediateOperationEnvironment);
			if (intermediateOperationEnvironment != oldIntermediateOperationEnvironment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT, oldIntermediateOperationEnvironment, intermediateOperationEnvironment));
			}
		}
		return intermediateOperationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationEnvironment basicGetIntermediateOperationEnvironment() {
		return intermediateOperationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateOperationEnvironment(IntermediateOperationEnvironment newIntermediateOperationEnvironment) {
		IntermediateOperationEnvironment oldIntermediateOperationEnvironment = intermediateOperationEnvironment;
		intermediateOperationEnvironment = newIntermediateOperationEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT, oldIntermediateOperationEnvironment, intermediateOperationEnvironment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationMicroserviceReference> getOperationMicroserviceReferences() {
		if (operationMicroserviceReferences == null) {
			operationMicroserviceReferences = new EObjectResolvingEList<OperationMicroserviceReference>(OperationMicroserviceReference.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES);
		}
		return operationMicroserviceReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateServiceDeploymentSpecification> getIntermediateServiceDeploymentSpecification() {
		if (intermediateServiceDeploymentSpecification == null) {
			intermediateServiceDeploymentSpecification = new EObjectContainmentWithInverseEList<IntermediateServiceDeploymentSpecification>(IntermediateServiceDeploymentSpecification.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE);
		}
		return intermediateServiceDeploymentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntermediateServiceDeploymentSpecification()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				return ((InternalEList<?>)getIntermediateServiceDeploymentSpecification()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
				return getName();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT:
				return getIntermediateImport();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT:
				if (resolve) return getIntermediateOperationEnvironment();
				return basicGetIntermediateOperationEnvironment();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES:
				return getOperationMicroserviceReferences();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				return getIntermediateServiceDeploymentSpecification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
				setName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT:
				getIntermediateImport().clear();
				getIntermediateImport().addAll((Collection<? extends IntermediateImport>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT:
				setIntermediateOperationEnvironment((IntermediateOperationEnvironment)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES:
				getOperationMicroserviceReferences().clear();
				getOperationMicroserviceReferences().addAll((Collection<? extends OperationMicroserviceReference>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				getIntermediateServiceDeploymentSpecification().clear();
				getIntermediateServiceDeploymentSpecification().addAll((Collection<? extends IntermediateServiceDeploymentSpecification>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT:
				getIntermediateImport().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT:
				setIntermediateOperationEnvironment((IntermediateOperationEnvironment)null);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES:
				getOperationMicroserviceReferences().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				getIntermediateServiceDeploymentSpecification().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT:
				return intermediateImport != null && !intermediateImport.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT:
				return intermediateOperationEnvironment != null;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES:
				return operationMicroserviceReferences != null && !operationMicroserviceReferences.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				return intermediateServiceDeploymentSpecification != null && !intermediateServiceDeploymentSpecification.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //IntermediateOperationNodeImpl
