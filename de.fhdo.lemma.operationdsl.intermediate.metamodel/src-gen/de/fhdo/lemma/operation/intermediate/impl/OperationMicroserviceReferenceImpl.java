/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.Visibility;

import de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Microservice Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getMicroserviceType <em>Microservice Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getService <em>Service</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationMicroserviceReferenceImpl extends MicroserviceReferenceImpl implements OperationMicroserviceReference {
	/**
	 * The default value of the '{@link #isEffectivelyImplemented() <em>Effectively Implemented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEffectivelyImplemented()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EFFECTIVELY_IMPLEMENTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEffectivelyImplemented() <em>Effectively Implemented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEffectivelyImplemented()
	 * @generated
	 * @ordered
	 */
	protected boolean effectivelyImplemented = EFFECTIVELY_IMPLEMENTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getMicroserviceType() <em>Microservice Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMicroserviceType()
	 * @generated
	 * @ordered
	 */
	protected static final MicroserviceType MICROSERVICE_TYPE_EDEFAULT = MicroserviceType.FUNCTIONAL;

	/**
	 * The cached value of the '{@link #getMicroserviceType() <em>Microservice Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMicroserviceType()
	 * @generated
	 * @ordered
	 */
	protected MicroserviceType microserviceType = MICROSERVICE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.NONE;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIntermediateImport() <em>Intermediate Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateImport()
	 * @generated
	 * @ordered
	 */
	protected IntermediateImport intermediateImport;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationMicroserviceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.OPERATION_MICROSERVICE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEffectivelyImplemented() {
		return effectivelyImplemented;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEffectivelyImplemented(boolean newEffectivelyImplemented) {
		boolean oldEffectivelyImplemented = effectivelyImplemented;
		effectivelyImplemented = newEffectivelyImplemented;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED, oldEffectivelyImplemented, effectivelyImplemented));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MicroserviceType getMicroserviceType() {
		return microserviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMicroserviceType(MicroserviceType newMicroserviceType) {
		MicroserviceType oldMicroserviceType = microserviceType;
		microserviceType = newMicroserviceType == null ? MICROSERVICE_TYPE_EDEFAULT : newMicroserviceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE, oldMicroserviceType, microserviceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateImport getIntermediateImport() {
		if (intermediateImport != null && intermediateImport.eIsProxy()) {
			InternalEObject oldIntermediateImport = (InternalEObject)intermediateImport;
			intermediateImport = (IntermediateImport)eResolveProxy(oldIntermediateImport);
			if (intermediateImport != oldIntermediateImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT, oldIntermediateImport, intermediateImport));
			}
		}
		return intermediateImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateImport basicGetIntermediateImport() {
		return intermediateImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateImport(IntermediateImport newIntermediateImport) {
		IntermediateImport oldIntermediateImport = intermediateImport;
		intermediateImport = newIntermediateImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT, oldIntermediateImport, intermediateImport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationNode getService() {
		if (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE) return null;
		return (IntermediateOperationNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationNode basicGetService() {
		if (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE) return null;
		return (IntermediateOperationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(IntermediateOperationNode newService, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newService, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(IntermediateOperationNode newService) {
		if (newService != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE && newService != null)) {
			if (EcoreUtil.isAncestor(this, newService))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newService != null)
				msgs = ((InternalEObject)newService).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES, IntermediateOperationNode.class, msgs);
			msgs = basicSetService(newService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE, newService, newService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateServiceDeploymentSpecification getSpecification() {
		if (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION) return null;
		return (IntermediateServiceDeploymentSpecification)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateServiceDeploymentSpecification basicGetSpecification() {
		if (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION) return null;
		return (IntermediateServiceDeploymentSpecification)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(IntermediateServiceDeploymentSpecification newSpecification, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecification, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(IntermediateServiceDeploymentSpecification newSpecification) {
		if (newSpecification != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION && newSpecification != null)) {
			if (EcoreUtil.isAncestor(this, newSpecification))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE, IntermediateServiceDeploymentSpecification.class, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetService((IntermediateOperationNode)otherEnd, msgs);
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecification((IntermediateServiceDeploymentSpecification)otherEnd, msgs);
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE:
				return basicSetService(null, msgs);
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION:
				return basicSetSpecification(null, msgs);
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES, IntermediateOperationNode.class, msgs);
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE, IntermediateServiceDeploymentSpecification.class, msgs);
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				return isEffectivelyImplemented();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				return getMicroserviceType();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				return getVisibility();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT:
				if (resolve) return getIntermediateImport();
				return basicGetIntermediateImport();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE:
				if (resolve) return getService();
				return basicGetService();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION:
				if (resolve) return getSpecification();
				return basicGetSpecification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				setEffectivelyImplemented((Boolean)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				setMicroserviceType((MicroserviceType)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT:
				setIntermediateImport((IntermediateImport)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE:
				setService((IntermediateOperationNode)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION:
				setSpecification((IntermediateServiceDeploymentSpecification)newValue);
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				setEffectivelyImplemented(EFFECTIVELY_IMPLEMENTED_EDEFAULT);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				setMicroserviceType(MICROSERVICE_TYPE_EDEFAULT);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT:
				setIntermediateImport((IntermediateImport)null);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE:
				setService((IntermediateOperationNode)null);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION:
				setSpecification((IntermediateServiceDeploymentSpecification)null);
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				return effectivelyImplemented != EFFECTIVELY_IMPLEMENTED_EDEFAULT;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				return microserviceType != MICROSERVICE_TYPE_EDEFAULT;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT:
				return intermediateImport != null;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SERVICE:
				return basicGetService() != null;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION:
				return basicGetSpecification() != null;
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
		result.append(" (effectivelyImplemented: ");
		result.append(effectivelyImplemented);
		result.append(", microserviceType: ");
		result.append(microserviceType);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //OperationMicroserviceReferenceImpl
