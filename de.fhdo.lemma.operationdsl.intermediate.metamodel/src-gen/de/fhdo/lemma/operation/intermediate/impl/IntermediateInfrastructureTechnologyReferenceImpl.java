/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference;
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
 * An implementation of the model object '<em><b>Infrastructure Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl#getInfrastructureTechnology <em>Infrastructure Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl#getInfrastructureNode <em>Infrastructure Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateInfrastructureTechnologyReferenceImpl extends MinimalEObjectImpl.Container implements IntermediateInfrastructureTechnologyReference {
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
	 * The cached value of the '{@link #getInfrastructureTechnology() <em>Infrastructure Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructureTechnology()
	 * @generated
	 * @ordered
	 */
	protected IntermediateInfrastructureTechnology infrastructureTechnology;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateInfrastructureTechnologyReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureTechnology getInfrastructureTechnology() {
		if (infrastructureTechnology != null && infrastructureTechnology.eIsProxy()) {
			InternalEObject oldInfrastructureTechnology = (InternalEObject)infrastructureTechnology;
			infrastructureTechnology = (IntermediateInfrastructureTechnology)eResolveProxy(oldInfrastructureTechnology);
			if (infrastructureTechnology != oldInfrastructureTechnology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY, oldInfrastructureTechnology, infrastructureTechnology));
			}
		}
		return infrastructureTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureTechnology basicGetInfrastructureTechnology() {
		return infrastructureTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfrastructureTechnology(IntermediateInfrastructureTechnology newInfrastructureTechnology) {
		IntermediateInfrastructureTechnology oldInfrastructureTechnology = infrastructureTechnology;
		infrastructureTechnology = newInfrastructureTechnology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY, oldInfrastructureTechnology, infrastructureTechnology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureNode getInfrastructureNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE) return null;
		return (IntermediateInfrastructureNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureNode basicGetInfrastructureNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE) return null;
		return (IntermediateInfrastructureNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfrastructureNode(IntermediateInfrastructureNode newInfrastructureNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInfrastructureNode, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfrastructureNode(IntermediateInfrastructureNode newInfrastructureNode) {
		if (newInfrastructureNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE && newInfrastructureNode != null)) {
			if (EcoreUtil.isAncestor(this, newInfrastructureNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInfrastructureNode != null)
				msgs = ((InternalEObject)newInfrastructureNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE, IntermediateInfrastructureNode.class, msgs);
			msgs = basicSetInfrastructureNode(newInfrastructureNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE, newInfrastructureNode, newInfrastructureNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInfrastructureNode((IntermediateInfrastructureNode)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
				return basicSetInfrastructureNode(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE, IntermediateInfrastructureNode.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
				if (resolve) return getInfrastructureTechnology();
				return basicGetInfrastructureTechnology();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
				if (resolve) return getInfrastructureNode();
				return basicGetInfrastructureNode();
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
				setImport((IntermediateImport)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
				setInfrastructureTechnology((IntermediateInfrastructureTechnology)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
				setInfrastructureNode((IntermediateInfrastructureNode)newValue);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
				setImport((IntermediateImport)null);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
				setInfrastructureTechnology((IntermediateInfrastructureTechnology)null);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
				setInfrastructureNode((IntermediateInfrastructureNode)null);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
				return import_ != null;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
				return infrastructureTechnology != null;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
				return basicGetInfrastructureNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateInfrastructureTechnologyReferenceImpl
