/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Specific Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl#getFeatureames <em>Featureames</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl#getIntermediateTechnologySpecificPropertyValue <em>Intermediate Technology Specific Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl#getIntermediateOperationTechnology <em>Intermediate Operation Technology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateTechnologySpecificPropertyImpl extends MinimalEObjectImpl.Container implements IntermediateTechnologySpecificProperty {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureames() <em>Featureames</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> featureames;

	/**
	 * The cached value of the '{@link #getIntermediateTechnologySpecificPropertyValue() <em>Intermediate Technology Specific Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected IntermediateTechnologySpecificPropertyValue intermediateTechnologySpecificPropertyValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateTechnologySpecificPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFeatureames() {
		if (featureames == null) {
			featureames = new EDataTypeEList<String>(String.class, this, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES);
		}
		return featureames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateTechnologySpecificPropertyValue getIntermediateTechnologySpecificPropertyValue() {
		return intermediateTechnologySpecificPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateTechnologySpecificPropertyValue(IntermediateTechnologySpecificPropertyValue newIntermediateTechnologySpecificPropertyValue, NotificationChain msgs) {
		IntermediateTechnologySpecificPropertyValue oldIntermediateTechnologySpecificPropertyValue = intermediateTechnologySpecificPropertyValue;
		intermediateTechnologySpecificPropertyValue = newIntermediateTechnologySpecificPropertyValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, oldIntermediateTechnologySpecificPropertyValue, newIntermediateTechnologySpecificPropertyValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateTechnologySpecificPropertyValue(IntermediateTechnologySpecificPropertyValue newIntermediateTechnologySpecificPropertyValue) {
		if (newIntermediateTechnologySpecificPropertyValue != intermediateTechnologySpecificPropertyValue) {
			NotificationChain msgs = null;
			if (intermediateTechnologySpecificPropertyValue != null)
				msgs = ((InternalEObject)intermediateTechnologySpecificPropertyValue).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY, IntermediateTechnologySpecificPropertyValue.class, msgs);
			if (newIntermediateTechnologySpecificPropertyValue != null)
				msgs = ((InternalEObject)newIntermediateTechnologySpecificPropertyValue).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY, IntermediateTechnologySpecificPropertyValue.class, msgs);
			msgs = basicSetIntermediateTechnologySpecificPropertyValue(newIntermediateTechnologySpecificPropertyValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, newIntermediateTechnologySpecificPropertyValue, newIntermediateTechnologySpecificPropertyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationTechnology getIntermediateOperationTechnology() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY) return null;
		return (IntermediateOperationTechnology)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationTechnology basicGetIntermediateOperationTechnology() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY) return null;
		return (IntermediateOperationTechnology)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateOperationTechnology(IntermediateOperationTechnology newIntermediateOperationTechnology, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateOperationTechnology, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateOperationTechnology(IntermediateOperationTechnology newIntermediateOperationTechnology) {
		if (newIntermediateOperationTechnology != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY && newIntermediateOperationTechnology != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateOperationTechnology))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateOperationTechnology != null)
				msgs = ((InternalEObject)newIntermediateOperationTechnology).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY, IntermediateOperationTechnology.class, msgs);
			msgs = basicSetIntermediateOperationTechnology(newIntermediateOperationTechnology, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY, newIntermediateOperationTechnology, newIntermediateOperationTechnology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				if (intermediateTechnologySpecificPropertyValue != null)
					msgs = ((InternalEObject)intermediateTechnologySpecificPropertyValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE, null, msgs);
				return basicSetIntermediateTechnologySpecificPropertyValue((IntermediateTechnologySpecificPropertyValue)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateOperationTechnology((IntermediateOperationTechnology)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				return basicSetIntermediateTechnologySpecificPropertyValue(null, msgs);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY:
				return basicSetIntermediateOperationTechnology(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY, IntermediateOperationTechnology.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
				return getName();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
				return getType();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
				return getDefaultValue();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES:
				return getFeatureames();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				return getIntermediateTechnologySpecificPropertyValue();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY:
				if (resolve) return getIntermediateOperationTechnology();
				return basicGetIntermediateOperationTechnology();
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
				setName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
				setType((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES:
				getFeatureames().clear();
				getFeatureames().addAll((Collection<? extends String>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				setIntermediateTechnologySpecificPropertyValue((IntermediateTechnologySpecificPropertyValue)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY:
				setIntermediateOperationTechnology((IntermediateOperationTechnology)newValue);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES:
				getFeatureames().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				setIntermediateTechnologySpecificPropertyValue((IntermediateTechnologySpecificPropertyValue)null);
				return;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY:
				setIntermediateOperationTechnology((IntermediateOperationTechnology)null);
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
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES:
				return featureames != null && !featureames.isEmpty();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE:
				return intermediateTechnologySpecificPropertyValue != null;
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY:
				return basicGetIntermediateOperationTechnology() != null;
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
		result.append(", type: ");
		result.append(type);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", featureames: ");
		result.append(featureames);
		result.append(')');
		return result.toString();
	}

} //IntermediateTechnologySpecificPropertyImpl
