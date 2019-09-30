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
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl#getIntermediateImport <em>Intermediate Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl#getIntermediateInfrastructureTechnology <em>Intermediate Infrastructure Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateInfrastructureTechnologyReferenceImpl extends MinimalEObjectImpl.Container implements IntermediateInfrastructureTechnologyReference {
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
	 * The cached value of the '{@link #getIntermediateInfrastructureTechnology() <em>Intermediate Infrastructure Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateInfrastructureTechnology()
	 * @generated
	 * @ordered
	 */
	protected IntermediateInfrastructureTechnology intermediateInfrastructureTechnology;

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
	public IntermediateImport getIntermediateImport() {
		if (intermediateImport != null && intermediateImport.eIsProxy()) {
			InternalEObject oldIntermediateImport = (InternalEObject)intermediateImport;
			intermediateImport = (IntermediateImport)eResolveProxy(oldIntermediateImport);
			if (intermediateImport != oldIntermediateImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT, oldIntermediateImport, intermediateImport));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT, oldIntermediateImport, intermediateImport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureTechnology getIntermediateInfrastructureTechnology() {
		if (intermediateInfrastructureTechnology != null && intermediateInfrastructureTechnology.eIsProxy()) {
			InternalEObject oldIntermediateInfrastructureTechnology = (InternalEObject)intermediateInfrastructureTechnology;
			intermediateInfrastructureTechnology = (IntermediateInfrastructureTechnology)eResolveProxy(oldIntermediateInfrastructureTechnology);
			if (intermediateInfrastructureTechnology != oldIntermediateInfrastructureTechnology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY, oldIntermediateInfrastructureTechnology, intermediateInfrastructureTechnology));
			}
		}
		return intermediateInfrastructureTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureTechnology basicGetIntermediateInfrastructureTechnology() {
		return intermediateInfrastructureTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateInfrastructureTechnology(IntermediateInfrastructureTechnology newIntermediateInfrastructureTechnology) {
		IntermediateInfrastructureTechnology oldIntermediateInfrastructureTechnology = intermediateInfrastructureTechnology;
		intermediateInfrastructureTechnology = newIntermediateInfrastructureTechnology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY, oldIntermediateInfrastructureTechnology, intermediateInfrastructureTechnology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureNode getIntermediateInfrastructureNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE) return null;
		return (IntermediateInfrastructureNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureNode basicGetIntermediateInfrastructureNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE) return null;
		return (IntermediateInfrastructureNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateInfrastructureNode(IntermediateInfrastructureNode newIntermediateInfrastructureNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateInfrastructureNode, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateInfrastructureNode(IntermediateInfrastructureNode newIntermediateInfrastructureNode) {
		if (newIntermediateInfrastructureNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE && newIntermediateInfrastructureNode != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateInfrastructureNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateInfrastructureNode != null)
				msgs = ((InternalEObject)newIntermediateInfrastructureNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE, IntermediateInfrastructureNode.class, msgs);
			msgs = basicSetIntermediateInfrastructureNode(newIntermediateInfrastructureNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE, newIntermediateInfrastructureNode, newIntermediateInfrastructureNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateInfrastructureNode((IntermediateInfrastructureNode)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE:
				return basicSetIntermediateInfrastructureNode(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE, IntermediateInfrastructureNode.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				if (resolve) return getIntermediateImport();
				return basicGetIntermediateImport();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY:
				if (resolve) return getIntermediateInfrastructureTechnology();
				return basicGetIntermediateInfrastructureTechnology();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE:
				if (resolve) return getIntermediateInfrastructureNode();
				return basicGetIntermediateInfrastructureNode();
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				setIntermediateImport((IntermediateImport)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY:
				setIntermediateInfrastructureTechnology((IntermediateInfrastructureTechnology)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE:
				setIntermediateInfrastructureNode((IntermediateInfrastructureNode)newValue);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				setIntermediateImport((IntermediateImport)null);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY:
				setIntermediateInfrastructureTechnology((IntermediateInfrastructureTechnology)null);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE:
				setIntermediateInfrastructureNode((IntermediateInfrastructureNode)null);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT:
				return intermediateImport != null;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY:
				return intermediateInfrastructureTechnology != null;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE:
				return basicGetIntermediateInfrastructureNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateInfrastructureTechnologyReferenceImpl
