/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
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
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getOperationEnvironment <em>Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getDeployedServices <em>Deployed Services</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getSpecifications <em>Specifications</em>}</li>
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
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateImport> imports;

	/**
	 * The cached value of the '{@link #getOperationEnvironment() <em>Operation Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationEnvironment()
	 * @generated
	 * @ordered
	 */
	protected IntermediateOperationEnvironment operationEnvironment;

	/**
	 * The cached value of the '{@link #getDeployedServices() <em>Deployed Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeployedServices()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationMicroserviceReference> deployedServices;

	/**
	 * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateEndpoint> endpoints;

	/**
	 * The cached value of the '{@link #getSpecifications() <em>Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateServiceDeploymentSpecification> specifications;

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
	public EList<IntermediateImport> getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList<IntermediateImport>(IntermediateImport.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationEnvironment getOperationEnvironment() {
		if (operationEnvironment != null && operationEnvironment.eIsProxy()) {
			InternalEObject oldOperationEnvironment = (InternalEObject)operationEnvironment;
			operationEnvironment = (IntermediateOperationEnvironment)eResolveProxy(oldOperationEnvironment);
			if (operationEnvironment != oldOperationEnvironment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT, oldOperationEnvironment, operationEnvironment));
			}
		}
		return operationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationEnvironment basicGetOperationEnvironment() {
		return operationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationEnvironment(IntermediateOperationEnvironment newOperationEnvironment) {
		IntermediateOperationEnvironment oldOperationEnvironment = operationEnvironment;
		operationEnvironment = newOperationEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT, oldOperationEnvironment, operationEnvironment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationMicroserviceReference> getDeployedServices() {
		if (deployedServices == null) {
			deployedServices = new EObjectContainmentWithInverseEList<OperationMicroserviceReference>(OperationMicroserviceReference.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE);
		}
		return deployedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateEndpoint> getEndpoints() {
		if (endpoints == null) {
			endpoints = new EObjectContainmentEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS);
		}
		return endpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateServiceDeploymentSpecification> getSpecifications() {
		if (specifications == null) {
			specifications = new EObjectContainmentWithInverseEList<IntermediateServiceDeploymentSpecification>(IntermediateServiceDeploymentSpecification.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE);
		}
		return specifications;
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeployedServices()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecifications()).basicAdd(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
				return ((InternalEList<?>)getDeployedServices()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
				return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
				return ((InternalEList<?>)getSpecifications()).basicRemove(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
				return getImports();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
				if (resolve) return getOperationEnvironment();
				return basicGetOperationEnvironment();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
				return getDeployedServices();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
				return getEndpoints();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
				return getSpecifications();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends IntermediateImport>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
				setOperationEnvironment((IntermediateOperationEnvironment)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
				getDeployedServices().clear();
				getDeployedServices().addAll((Collection<? extends OperationMicroserviceReference>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
				getEndpoints().clear();
				getEndpoints().addAll((Collection<? extends IntermediateEndpoint>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
				getSpecifications().clear();
				getSpecifications().addAll((Collection<? extends IntermediateServiceDeploymentSpecification>)newValue);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
				getImports().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
				setOperationEnvironment((IntermediateOperationEnvironment)null);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
				getDeployedServices().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
				getEndpoints().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
				getSpecifications().clear();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
				return imports != null && !imports.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
				return operationEnvironment != null;
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
				return deployedServices != null && !deployedServices.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
				return endpoints != null && !endpoints.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
				return specifications != null && !specifications.isEmpty();
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
