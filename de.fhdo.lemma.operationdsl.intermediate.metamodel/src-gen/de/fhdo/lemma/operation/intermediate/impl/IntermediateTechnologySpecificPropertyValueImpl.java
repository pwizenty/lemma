/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Specific Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl#getIntermediateTechnologySpecificProperty <em>Intermediate Technology Specific Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateTechnologySpecificPropertyValueImpl extends MinimalEObjectImpl.Container implements IntermediateTechnologySpecificPropertyValue {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateTechnologySpecificPropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateServiceDeploymentSpecification getIntermediateServiceDeploymentSpecification() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION) return null;
		return (IntermediateServiceDeploymentSpecification)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateServiceDeploymentSpecification basicGetIntermediateServiceDeploymentSpecification() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION) return null;
		return (IntermediateServiceDeploymentSpecification)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateServiceDeploymentSpecification(IntermediateServiceDeploymentSpecification newIntermediateServiceDeploymentSpecification, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateServiceDeploymentSpecification, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateServiceDeploymentSpecification(IntermediateServiceDeploymentSpecification newIntermediateServiceDeploymentSpecification) {
		if (newIntermediateServiceDeploymentSpecification != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION && newIntermediateServiceDeploymentSpecification != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateServiceDeploymentSpecification))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateServiceDeploymentSpecification != null)
				msgs = ((InternalEObject)newIntermediateServiceDeploymentSpecification).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, IntermediateServiceDeploymentSpecification.class, msgs);
			msgs = basicSetIntermediateServiceDeploymentSpecification(newIntermediateServiceDeploymentSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION, newIntermediateServiceDeploymentSpecification, newIntermediateServiceDeploymentSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateTechnologySpecificProperty getIntermediateTechnologySpecificProperty() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY) return null;
		return (IntermediateTechnologySpecificProperty)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateTechnologySpecificProperty basicGetIntermediateTechnologySpecificProperty() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY) return null;
		return (IntermediateTechnologySpecificProperty)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateTechnologySpecificProperty(IntermediateTechnologySpecificProperty newIntermediateTechnologySpecificProperty, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateTechnologySpecificProperty, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateTechnologySpecificProperty(IntermediateTechnologySpecificProperty newIntermediateTechnologySpecificProperty) {
		if (newIntermediateTechnologySpecificProperty != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY && newIntermediateTechnologySpecificProperty != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateTechnologySpecificProperty))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateTechnologySpecificProperty != null)
				msgs = ((InternalEObject)newIntermediateTechnologySpecificProperty).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, IntermediateTechnologySpecificProperty.class, msgs);
			msgs = basicSetIntermediateTechnologySpecificProperty(newIntermediateTechnologySpecificProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY, newIntermediateTechnologySpecificProperty, newIntermediateTechnologySpecificProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateServiceDeploymentSpecification((IntermediateServiceDeploymentSpecification)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateTechnologySpecificProperty((IntermediateTechnologySpecificProperty)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				return basicSetIntermediateServiceDeploymentSpecification(null, msgs);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				return basicSetIntermediateTechnologySpecificProperty(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, IntermediateServiceDeploymentSpecification.class, msgs);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, IntermediateTechnologySpecificProperty.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE:
				return getValue();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				if (resolve) return getIntermediateServiceDeploymentSpecification();
				return basicGetIntermediateServiceDeploymentSpecification();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				if (resolve) return getIntermediateTechnologySpecificProperty();
				return basicGetIntermediateTechnologySpecificProperty();
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE:
				setValue((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				setIntermediateServiceDeploymentSpecification((IntermediateServiceDeploymentSpecification)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				setIntermediateTechnologySpecificProperty((IntermediateTechnologySpecificProperty)newValue);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				setIntermediateServiceDeploymentSpecification((IntermediateServiceDeploymentSpecification)null);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				setIntermediateTechnologySpecificProperty((IntermediateTechnologySpecificProperty)null);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION:
				return basicGetIntermediateServiceDeploymentSpecification() != null;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				return basicGetIntermediateTechnologySpecificProperty() != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //IntermediateTechnologySpecificPropertyValueImpl
