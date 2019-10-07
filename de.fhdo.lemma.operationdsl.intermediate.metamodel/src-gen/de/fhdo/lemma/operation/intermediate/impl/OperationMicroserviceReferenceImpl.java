/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.Visibility;

import de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
