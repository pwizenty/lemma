/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getDependentOperationNodes <em>Dependent Operation Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getUsedByOperationNodes <em>Used By Operation Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getIntermediateInfrastructureTechnologyReference <em>Intermediate Infrastructure Technology Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getIntermediateEndpoint <em>Intermediate Endpoint</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl#getIntermediateOperationModel <em>Intermediate Operation Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateInfrastructureNodeImpl extends IntermediateOperationNodeImpl implements IntermediateInfrastructureNode {
	/**
	 * The cached value of the '{@link #getDependentOperationNodes() <em>Dependent Operation Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependentOperationNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateOperationNode> dependentOperationNodes;

	/**
	 * The cached value of the '{@link #getUsedByOperationNodes() <em>Used By Operation Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedByOperationNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateOperationNode> usedByOperationNodes;

	/**
	 * The cached value of the '{@link #getIntermediateInfrastructureTechnologyReference() <em>Intermediate Infrastructure Technology Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 * @ordered
	 */
	protected IntermediateInfrastructureTechnologyReference intermediateInfrastructureTechnologyReference;

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
	protected IntermediateInfrastructureNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_INFRASTRUCTURE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateOperationNode> getDependentOperationNodes() {
		if (dependentOperationNodes == null) {
			dependentOperationNodes = new EObjectResolvingEList<IntermediateOperationNode>(IntermediateOperationNode.class, this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDENT_OPERATION_NODES);
		}
		return dependentOperationNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateOperationNode> getUsedByOperationNodes() {
		if (usedByOperationNodes == null) {
			usedByOperationNodes = new EObjectResolvingEList<IntermediateOperationNode>(IntermediateOperationNode.class, this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_OPERATION_NODES);
		}
		return usedByOperationNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInfrastructureTechnologyReference getIntermediateInfrastructureTechnologyReference() {
		return intermediateInfrastructureTechnologyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateInfrastructureTechnologyReference(IntermediateInfrastructureTechnologyReference newIntermediateInfrastructureTechnologyReference, NotificationChain msgs) {
		IntermediateInfrastructureTechnologyReference oldIntermediateInfrastructureTechnologyReference = intermediateInfrastructureTechnologyReference;
		intermediateInfrastructureTechnologyReference = newIntermediateInfrastructureTechnologyReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE, oldIntermediateInfrastructureTechnologyReference, newIntermediateInfrastructureTechnologyReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateInfrastructureTechnologyReference(IntermediateInfrastructureTechnologyReference newIntermediateInfrastructureTechnologyReference) {
		if (newIntermediateInfrastructureTechnologyReference != intermediateInfrastructureTechnologyReference) {
			NotificationChain msgs = null;
			if (intermediateInfrastructureTechnologyReference != null)
				msgs = ((InternalEObject)intermediateInfrastructureTechnologyReference).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE, IntermediateInfrastructureTechnologyReference.class, msgs);
			if (newIntermediateInfrastructureTechnologyReference != null)
				msgs = ((InternalEObject)newIntermediateInfrastructureTechnologyReference).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE, IntermediateInfrastructureTechnologyReference.class, msgs);
			msgs = basicSetIntermediateInfrastructureTechnologyReference(newIntermediateInfrastructureTechnologyReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE, newIntermediateInfrastructureTechnologyReference, newIntermediateInfrastructureTechnologyReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateEndpoint> getIntermediateEndpoint() {
		if (intermediateEndpoint == null) {
			intermediateEndpoint = new EObjectContainmentEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT);
		}
		return intermediateEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationModel getIntermediateOperationModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL) return null;
		return (IntermediateOperationModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationModel basicGetIntermediateOperationModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL) return null;
		return (IntermediateOperationModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateOperationModel(IntermediateOperationModel newIntermediateOperationModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateOperationModel, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateOperationModel(IntermediateOperationModel newIntermediateOperationModel) {
		if (newIntermediateOperationModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL && newIntermediateOperationModel != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateOperationModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateOperationModel != null)
				msgs = ((InternalEObject)newIntermediateOperationModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE, IntermediateOperationModel.class, msgs);
			msgs = basicSetIntermediateOperationModel(newIntermediateOperationModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL, newIntermediateOperationModel, newIntermediateOperationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE:
				if (intermediateInfrastructureTechnologyReference != null)
					msgs = ((InternalEObject)intermediateInfrastructureTechnologyReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE, null, msgs);
				return basicSetIntermediateInfrastructureTechnologyReference((IntermediateInfrastructureTechnologyReference)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL:
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE:
				return basicSetIntermediateInfrastructureTechnologyReference(null, msgs);
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT:
				return ((InternalEList<?>)getIntermediateEndpoint()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL:
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE, IntermediateOperationModel.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDENT_OPERATION_NODES:
				return getDependentOperationNodes();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_OPERATION_NODES:
				return getUsedByOperationNodes();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE:
				return getIntermediateInfrastructureTechnologyReference();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT:
				return getIntermediateEndpoint();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL:
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDENT_OPERATION_NODES:
				getDependentOperationNodes().clear();
				getDependentOperationNodes().addAll((Collection<? extends IntermediateOperationNode>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_OPERATION_NODES:
				getUsedByOperationNodes().clear();
				getUsedByOperationNodes().addAll((Collection<? extends IntermediateOperationNode>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE:
				setIntermediateInfrastructureTechnologyReference((IntermediateInfrastructureTechnologyReference)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT:
				getIntermediateEndpoint().clear();
				getIntermediateEndpoint().addAll((Collection<? extends IntermediateEndpoint>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL:
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDENT_OPERATION_NODES:
				getDependentOperationNodes().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_OPERATION_NODES:
				getUsedByOperationNodes().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE:
				setIntermediateInfrastructureTechnologyReference((IntermediateInfrastructureTechnologyReference)null);
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT:
				getIntermediateEndpoint().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL:
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
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDENT_OPERATION_NODES:
				return dependentOperationNodes != null && !dependentOperationNodes.isEmpty();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_OPERATION_NODES:
				return usedByOperationNodes != null && !usedByOperationNodes.isEmpty();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE:
				return intermediateInfrastructureTechnologyReference != null;
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT:
				return intermediateEndpoint != null && !intermediateEndpoint.isEmpty();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL:
				return basicGetIntermediateOperationModel() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateInfrastructureNodeImpl
