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
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl#getDeploymentTechnology <em>Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateDeploymentTechnologyReferenceImpl extends MinimalEObjectImpl.Container implements IntermediateDeploymentTechnologyReference {
	/**
	 * The cached value of the '{@link #getDeploymentTechnology() <em>Deployment Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeploymentTechnology()
	 * @generated
	 * @ordered
	 */
	protected IntermediateDeploymentTechnology deploymentTechnology;

	/**
	 * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImport()
	 * @generated
	 * @ordered
	 */
	protected IntermediateImport import_;

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
	public IntermediateDeploymentTechnology getDeploymentTechnology() {
		if (deploymentTechnology != null && deploymentTechnology.eIsProxy()) {
			InternalEObject oldDeploymentTechnology = (InternalEObject)deploymentTechnology;
			deploymentTechnology = (IntermediateDeploymentTechnology)eResolveProxy(oldDeploymentTechnology);
			if (deploymentTechnology != oldDeploymentTechnology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY, oldDeploymentTechnology, deploymentTechnology));
			}
		}
		return deploymentTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateDeploymentTechnology basicGetDeploymentTechnology() {
		return deploymentTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeploymentTechnology(IntermediateDeploymentTechnology newDeploymentTechnology) {
		IntermediateDeploymentTechnology oldDeploymentTechnology = deploymentTechnology;
		deploymentTechnology = newDeploymentTechnology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY, oldDeploymentTechnology, deploymentTechnology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateImport getImport() {
		if (import_ != null && import_.eIsProxy()) {
			InternalEObject oldImport = (InternalEObject)import_;
			import_ = (IntermediateImport)eResolveProxy(oldImport);
			if (import_ != oldImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
			}
		}
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateImport basicGetImport() {
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImport(IntermediateImport newImport) {
		IntermediateImport oldImport = import_;
		import_ = newImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateContainer getContainer() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER) return null;
		return (IntermediateContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateContainer basicGetContainer() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER) return null;
		return (IntermediateContainer)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(IntermediateContainer newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(IntermediateContainer newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE, IntermediateContainer.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((IntermediateContainer)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
				return basicSetContainer(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE, IntermediateContainer.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
				if (resolve) return getDeploymentTechnology();
				return basicGetDeploymentTechnology();
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
				setDeploymentTechnology((IntermediateDeploymentTechnology)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
				setImport((IntermediateImport)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
				setContainer((IntermediateContainer)newValue);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
				setDeploymentTechnology((IntermediateDeploymentTechnology)null);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
				setImport((IntermediateImport)null);
				return;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
				setContainer((IntermediateContainer)null);
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
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
				return deploymentTechnology != null;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
				return import_ != null;
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
				return basicGetContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateDeploymentTechnologyReferenceImpl
