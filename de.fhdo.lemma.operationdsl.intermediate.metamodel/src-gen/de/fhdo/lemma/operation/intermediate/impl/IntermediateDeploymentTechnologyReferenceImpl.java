/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateContainer;
import de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference;
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
 * An implementation of the model object '<em><b>Deployment Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl#getIntermediateDeploymentTechnology <em>Intermediate Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl#getIntermediateContainer <em>Intermediate Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateDeploymentTechnologyReferenceImpl extends MinimalEObjectImpl.Container implements IntermediateDeploymentTechnologyReference {
	/**
	 * The cached value of the '{@link #getIntermediateDeploymentTechnology() <em>Intermediate Deployment Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateDeploymentTechnology()
	 * @generated
	 * @ordered
	 */
	protected IntermediateDeploymentTechnology intermediateDeploymentTechnology;

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
	protected IntermediateDeploymentTechnologyReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateDeploymentTechnology getIntermediateDeploymentTechnology() {
		if (intermediateDeploymentTechnology != null && intermediateDeploymentTechnology.eIsProxy()) {
			InternalEObject oldIntermediateDeploymentTechnology = (InternalEObject)intermediateDeploymentTechnology;
			intermediateDeploymentTechnology = (IntermediateDeploymentTechnology)eResolveProxy(oldIntermediateDeploymentTechnology);
			if (intermediateDeploymentTechnology != oldIntermediateDeploymentTechnology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY, oldIntermediateDeploymentTechnology, intermediateDeploymentTechnology));
			}
		}
		return intermediateDeploymentTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateDeploymentTechnology basicGetIntermediateDeploymentTechnology() {
		return intermediateDeploymentTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateDeploymentTechnology(IntermediateDeploymentTechnology newIntermediateDeploymentTechnology) {
		IntermediateDeploymentTechnology oldIntermediateDeploymentTechnology = intermediateDeploymentTechnology;
		intermediateDeploymentTechnology = newIntermediateDeploymentTechnology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY, oldIntermediateDeploymentTechnology, intermediateDeploymentTechnology));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT, oldIntermediateImport, intermediateImport));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT, oldIntermediateImport, intermediateImport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateContainer getIntermediateContainer() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER) return null;
		return (IntermediateContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateContainer basicGetIntermediateContainer() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER) return null;
		return (IntermediateContainer)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateContainer(IntermediateContainer newIntermediateContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateContainer, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateContainer(IntermediateContainer newIntermediateContainer) {
		if (newIntermediateContainer != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER && newIntermediateContainer != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateContainer != null)
				msgs = ((InternalEObject)newIntermediateContainer).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE, IntermediateContainer.class, msgs);
			msgs = basicSetIntermediateContainer(newIntermediateContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER, newIntermediateContainer, newIntermediateContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateContainer((IntermediateContainer)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER:
				return basicSetIntermediateContainer(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE, IntermediateContainer.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY:
				if (resolve) return getIntermediateDeploymentTechnology();
				return basicGetIntermediateDeploymentTechnology();
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				if (resolve) return getIntermediateImport();
				return basicGetIntermediateImport();
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER:
				if (resolve) return getIntermediateContainer();
				return basicGetIntermediateContainer();
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY:
				setIntermediateDeploymentTechnology((IntermediateDeploymentTechnology)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				setIntermediateImport((IntermediateImport)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER:
				setIntermediateContainer((IntermediateContainer)newValue);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY:
				setIntermediateDeploymentTechnology((IntermediateDeploymentTechnology)null);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				setIntermediateImport((IntermediateImport)null);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER:
				setIntermediateContainer((IntermediateContainer)null);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY:
				return intermediateDeploymentTechnology != null;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				return intermediateImport != null;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER:
				return basicGetIntermediateContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateDeploymentTechnologyReferenceImpl
