/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Technology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl#getIntermediateOperationEnvironment <em>Intermediate Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl#getIntermediateTechnologySpecificProperty <em>Intermediate Technology Specific Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntermediateOperationTechnologyImpl extends MinimalEObjectImpl.Container implements IntermediateOperationTechnology {
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
	 * The cached value of the '{@link #getIntermediateOperationEnvironment() <em>Intermediate Operation Environment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateOperationEnvironment> intermediateOperationEnvironment;

	/**
	 * The cached value of the '{@link #getIntermediateTechnologySpecificProperty() <em>Intermediate Technology Specific Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateTechnologySpecificProperty> intermediateTechnologySpecificProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateOperationTechnologyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_TECHNOLOGY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateOperationEnvironment> getIntermediateOperationEnvironment() {
		if (intermediateOperationEnvironment == null) {
			intermediateOperationEnvironment = new EObjectContainmentWithInverseEList<IntermediateOperationEnvironment>(IntermediateOperationEnvironment.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT, IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY);
		}
		return intermediateOperationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateTechnologySpecificProperty> getIntermediateTechnologySpecificProperty() {
		if (intermediateTechnologySpecificProperty == null) {
			intermediateTechnologySpecificProperty = new EObjectContainmentWithInverseEList<IntermediateTechnologySpecificProperty>(IntermediateTechnologySpecificProperty.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY);
		}
		return intermediateTechnologySpecificProperty;
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntermediateOperationEnvironment()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntermediateTechnologySpecificProperty()).basicAdd(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT:
				return ((InternalEList<?>)getIntermediateOperationEnvironment()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				return ((InternalEList<?>)getIntermediateTechnologySpecificProperty()).basicRemove(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
				return getName();
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT:
				return getIntermediateOperationEnvironment();
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				return getIntermediateTechnologySpecificProperty();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
				setName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT:
				getIntermediateOperationEnvironment().clear();
				getIntermediateOperationEnvironment().addAll((Collection<? extends IntermediateOperationEnvironment>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				getIntermediateTechnologySpecificProperty().clear();
				getIntermediateTechnologySpecificProperty().addAll((Collection<? extends IntermediateTechnologySpecificProperty>)newValue);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT:
				getIntermediateOperationEnvironment().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				getIntermediateTechnologySpecificProperty().clear();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT:
				return intermediateOperationEnvironment != null && !intermediateOperationEnvironment.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY:
				return intermediateTechnologySpecificProperty != null && !intermediateTechnologySpecificProperty.isEmpty();
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

} //IntermediateOperationTechnologyImpl
