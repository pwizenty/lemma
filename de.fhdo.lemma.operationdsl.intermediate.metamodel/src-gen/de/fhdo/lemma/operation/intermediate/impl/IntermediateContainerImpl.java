/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateContainer;
import de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl#getIntermediateDeploymentTechnologyReference <em>Intermediate Deployment Technology Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl#getIntermediateEndpoint <em>Intermediate Endpoint</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl#getIntermediateOperationModel <em>Intermediate Operation Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateContainerImpl extends IntermediateOperationNodeImpl implements IntermediateContainer {
	/**
	 * The cached value of the '{@link #getIntermediateDeploymentTechnologyReference() <em>Intermediate Deployment Technology Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 * @ordered
	 */
	protected IntermediateDeploymentTechnologyReference intermediateDeploymentTechnologyReference;

	/**
	 * The cached value of the '{@link #getIntermediateEndpoint() <em>Intermediate Endpoint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateEndpoint()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateEndpoint> intermediateEndpoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateDeploymentTechnologyReference getIntermediateDeploymentTechnologyReference() {
		return intermediateDeploymentTechnologyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateDeploymentTechnologyReference(IntermediateDeploymentTechnologyReference newIntermediateDeploymentTechnologyReference, NotificationChain msgs) {
		IntermediateDeploymentTechnologyReference oldIntermediateDeploymentTechnologyReference = intermediateDeploymentTechnologyReference;
		intermediateDeploymentTechnologyReference = newIntermediateDeploymentTechnologyReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE, oldIntermediateDeploymentTechnologyReference, newIntermediateDeploymentTechnologyReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateDeploymentTechnologyReference(IntermediateDeploymentTechnologyReference newIntermediateDeploymentTechnologyReference) {
		if (newIntermediateDeploymentTechnologyReference != intermediateDeploymentTechnologyReference) {
			NotificationChain msgs = null;
			if (intermediateDeploymentTechnologyReference != null)
				msgs = ((InternalEObject)intermediateDeploymentTechnologyReference).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER, IntermediateDeploymentTechnologyReference.class, msgs);
			if (newIntermediateDeploymentTechnologyReference != null)
				msgs = ((InternalEObject)newIntermediateDeploymentTechnologyReference).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER, IntermediateDeploymentTechnologyReference.class, msgs);
			msgs = basicSetIntermediateDeploymentTechnologyReference(newIntermediateDeploymentTechnologyReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE, newIntermediateDeploymentTechnologyReference, newIntermediateDeploymentTechnologyReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateEndpoint> getIntermediateEndpoint() {
		if (intermediateEndpoint == null) {
			intermediateEndpoint = new EObjectContainmentEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT);
		}
		return intermediateEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationModel getIntermediateOperationModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL) return null;
		return (IntermediateOperationModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationModel basicGetIntermediateOperationModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL) return null;
		return (IntermediateOperationModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateOperationModel(IntermediateOperationModel newIntermediateOperationModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateOperationModel, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateOperationModel(IntermediateOperationModel newIntermediateOperationModel) {
		if (newIntermediateOperationModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL && newIntermediateOperationModel != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateOperationModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateOperationModel != null)
				msgs = ((InternalEObject)newIntermediateOperationModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER, IntermediateOperationModel.class, msgs);
			msgs = basicSetIntermediateOperationModel(newIntermediateOperationModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL, newIntermediateOperationModel, newIntermediateOperationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE:
				if (intermediateDeploymentTechnologyReference != null)
					msgs = ((InternalEObject)intermediateDeploymentTechnologyReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE, null, msgs);
				return basicSetIntermediateDeploymentTechnologyReference((IntermediateDeploymentTechnologyReference)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateOperationModel((IntermediateOperationModel)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE:
				return basicSetIntermediateDeploymentTechnologyReference(null, msgs);
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT:
				return ((InternalEList<?>)getIntermediateEndpoint()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL:
				return basicSetIntermediateOperationModel(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER, IntermediateOperationModel.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE:
				return getIntermediateDeploymentTechnologyReference();
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT:
				return getIntermediateEndpoint();
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL:
				if (resolve) return getIntermediateOperationModel();
				return basicGetIntermediateOperationModel();
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
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE:
				setIntermediateDeploymentTechnologyReference((IntermediateDeploymentTechnologyReference)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT:
				getIntermediateEndpoint().clear();
				getIntermediateEndpoint().addAll((Collection<? extends IntermediateEndpoint>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL:
				setIntermediateOperationModel((IntermediateOperationModel)newValue);
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
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE:
				setIntermediateDeploymentTechnologyReference((IntermediateDeploymentTechnologyReference)null);
				return;
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT:
				getIntermediateEndpoint().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL:
				setIntermediateOperationModel((IntermediateOperationModel)null);
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
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE:
				return intermediateDeploymentTechnologyReference != null;
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT:
				return intermediateEndpoint != null && !intermediateEndpoint.isEmpty();
			case IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL:
				return basicGetIntermediateOperationModel() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateContainerImpl
