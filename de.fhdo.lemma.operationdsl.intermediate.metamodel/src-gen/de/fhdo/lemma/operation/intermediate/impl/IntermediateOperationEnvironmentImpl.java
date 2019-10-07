/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl#getEnvironmentName <em>Environment Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl#getIntermediateOperationtechnology <em>Intermediate Operationtechnology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateOperationEnvironmentImpl extends MinimalEObjectImpl.Container implements IntermediateOperationEnvironment {
	/**
	 * The default value of the '{@link #getEnvironmentName() <em>Environment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironmentName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENVIRONMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnvironmentName() <em>Environment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironmentName()
	 * @generated
	 * @ordered
	 */
	protected String environmentName = ENVIRONMENT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateOperationEnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnvironmentName() {
		return environmentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvironmentName(String newEnvironmentName) {
		String oldEnvironmentName = environmentName;
		environmentName = newEnvironmentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME, oldEnvironmentName, environmentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationTechnology getIntermediateOperationtechnology() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY) return null;
		return (IntermediateOperationTechnology)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationTechnology basicGetIntermediateOperationtechnology() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY) return null;
		return (IntermediateOperationTechnology)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateOperationtechnology(IntermediateOperationTechnology newIntermediateOperationtechnology, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateOperationtechnology, IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateOperationtechnology(IntermediateOperationTechnology newIntermediateOperationtechnology) {
		if (newIntermediateOperationtechnology != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY && newIntermediateOperationtechnology != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateOperationtechnology))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateOperationtechnology != null)
				msgs = ((InternalEObject)newIntermediateOperationtechnology).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT, IntermediateOperationTechnology.class, msgs);
			msgs = basicSetIntermediateOperationtechnology(newIntermediateOperationtechnology, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY, newIntermediateOperationtechnology, newIntermediateOperationtechnology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateOperationtechnology((IntermediateOperationTechnology)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY:
				return basicSetIntermediateOperationtechnology(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT, IntermediateOperationTechnology.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
				return getEnvironmentName();
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT:
				return isDefault();
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY:
				if (resolve) return getIntermediateOperationtechnology();
				return basicGetIntermediateOperationtechnology();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
				setEnvironmentName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT:
				setDefault((Boolean)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY:
				setIntermediateOperationtechnology((IntermediateOperationTechnology)newValue);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
				setEnvironmentName(ENVIRONMENT_NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY:
				setIntermediateOperationtechnology((IntermediateOperationTechnology)null);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
				return ENVIRONMENT_NAME_EDEFAULT == null ? environmentName != null : !ENVIRONMENT_NAME_EDEFAULT.equals(environmentName);
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY:
				return basicGetIntermediateOperationtechnology() != null;
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
		result.append(" (environmentName: ");
		result.append(environmentName);
		result.append(", default: ");
		result.append(default_);
		result.append(')');
		return result.toString();
	}

} //IntermediateOperationEnvironmentImpl
