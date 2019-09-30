/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Deployment Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getOperationMicroserviceReference <em>Operation Microservice Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getIntermediateTechnologySpecificPropertyValue <em>Intermediate Technology Specific Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getIntermediateEndpoints <em>Intermediate Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getIntermediateOperationNode <em>Intermediate Operation Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateServiceDeploymentSpecificationImpl extends MinimalEObjectImpl.Container implements IntermediateServiceDeploymentSpecification {
	/**
	 * The cached value of the '{@link #getOperationMicroserviceReference() <em>Operation Microservice Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 * @ordered
	 */
	protected OperationMicroserviceReference operationMicroserviceReference;

	/**
	 * The cached value of the '{@link #getIntermediateTechnologySpecificPropertyValue() <em>Intermediate Technology Specific Property Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateTechnologySpecificPropertyValue> intermediateTechnologySpecificPropertyValue;

	/**
	 * The cached value of the '{@link #getIntermediateEndpoints() <em>Intermediate Endpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateEndpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateEndpoint> intermediateEndpoints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateServiceDeploymentSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationMicroserviceReference getOperationMicroserviceReference() {
		if (operationMicroserviceReference != null && operationMicroserviceReference.eIsProxy()) {
			InternalEObject oldOperationMicroserviceReference = (InternalEObject)operationMicroserviceReference;
			operationMicroserviceReference = (OperationMicroserviceReference)eResolveProxy(oldOperationMicroserviceReference);
			if (operationMicroserviceReference != oldOperationMicroserviceReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE, oldOperationMicroserviceReference, operationMicroserviceReference));
			}
		}
		return operationMicroserviceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationMicroserviceReference basicGetOperationMicroserviceReference() {
		return operationMicroserviceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationMicroserviceReference(OperationMicroserviceReference newOperationMicroserviceReference) {
		OperationMicroserviceReference oldOperationMicroserviceReference = operationMicroserviceReference;
		operationMicroserviceReference = newOperationMicroserviceReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE, oldOperationMicroserviceReference, operationMicroserviceReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateTechnologySpecificPropertyValue> getIntermediateTechnologySpecificPropertyValue() {
		if (intermediateTechnologySpecificPropertyValue == null) {
			intermediateTechnologySpecificPropertyValue = new EObjectContainmentWithInverseEList<IntermediateTechnologySpecificPropertyValue>(IntermediateTechnologySpecificPropertyValue.class, this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION);
		}
		return intermediateTechnologySpecificPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateEndpoint> getIntermediateEndpoints() {
		if (intermediateEndpoints == null) {
			intermediateEndpoints = new EObjectContainmentEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS);
		}
		return intermediateEndpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationNode getIntermediateOperationNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE) return null;
		return (IntermediateOperationNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationNode basicGetIntermediateOperationNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE) return null;
		return (IntermediateOperationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateOperationNode(IntermediateOperationNode newIntermediateOperationNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateOperationNode, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateOperationNode(IntermediateOperationNode newIntermediateOperationNode) {
		if (newIntermediateOperationNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE && newIntermediateOperationNode != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateOperationNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateOperationNode != null)
				msgs = ((InternalEObject)newIntermediateOperationNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION, IntermediateOperationNode.class, msgs);
			msgs = basicSetIntermediateOperationNode(newIntermediateOperationNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE, newIntermediateOperationNode, newIntermediateOperationNode));
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntermediateTechnologySpecificPropertyValue()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateOperationNode((IntermediateOperationNode)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				return ((InternalEList<?>)getIntermediateTechnologySpecificPropertyValue()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS:
				return ((InternalEList<?>)getIntermediateEndpoints()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE:
				return basicSetIntermediateOperationNode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION, IntermediateOperationNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				if (resolve) return getOperationMicroserviceReference();
				return basicGetOperationMicroserviceReference();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				return getIntermediateTechnologySpecificPropertyValue();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS:
				return getIntermediateEndpoints();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE:
				if (resolve) return getIntermediateOperationNode();
				return basicGetIntermediateOperationNode();
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				setOperationMicroserviceReference((OperationMicroserviceReference)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				getIntermediateTechnologySpecificPropertyValue().clear();
				getIntermediateTechnologySpecificPropertyValue().addAll((Collection<? extends IntermediateTechnologySpecificPropertyValue>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS:
				getIntermediateEndpoints().clear();
				getIntermediateEndpoints().addAll((Collection<? extends IntermediateEndpoint>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE:
				setIntermediateOperationNode((IntermediateOperationNode)newValue);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				setOperationMicroserviceReference((OperationMicroserviceReference)null);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				getIntermediateTechnologySpecificPropertyValue().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS:
				getIntermediateEndpoints().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE:
				setIntermediateOperationNode((IntermediateOperationNode)null);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				return operationMicroserviceReference != null;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				return intermediateTechnologySpecificPropertyValue != null && !intermediateTechnologySpecificPropertyValue.isEmpty();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS:
				return intermediateEndpoints != null && !intermediateEndpoints.isEmpty();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE:
				return basicGetIntermediateOperationNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateServiceDeploymentSpecificationImpl
