/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateContainer;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getIntermediateContainer <em>Intermediate Container</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateOperationModelImpl extends MinimalEObjectImpl.Container implements IntermediateOperationModel {
	/**
	 * The default value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModelUri()
	 * @generated
	 * @ordered
	 */
	protected String sourceModelUri = SOURCE_MODEL_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateImport> imports;

	/**
	 * The cached value of the '{@link #getIntermediateContainer() <em>Intermediate Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateContainer> intermediateContainer;

	/**
	 * The cached value of the '{@link #getIntermediateInfrastructureNode() <em>Intermediate Infrastructure Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateInfrastructureNode> intermediateInfrastructureNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateOperationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceModelUri() {
		return sourceModelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceModelUri(String newSourceModelUri) {
		String oldSourceModelUri = sourceModelUri;
		sourceModelUri = newSourceModelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI, oldSourceModelUri, sourceModelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateImport> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<IntermediateImport>(IntermediateImport.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateContainer> getIntermediateContainer() {
		if (intermediateContainer == null) {
			intermediateContainer = new EObjectContainmentWithInverseEList<IntermediateContainer>(IntermediateContainer.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER, IntermediatePackage.INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL);
		}
		return intermediateContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntermediateInfrastructureNode> getIntermediateInfrastructureNode() {
		if (intermediateInfrastructureNode == null) {
			intermediateInfrastructureNode = new EObjectContainmentWithInverseEList<IntermediateInfrastructureNode>(IntermediateInfrastructureNode.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL);
		}
		return intermediateInfrastructureNode;
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntermediateContainer()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntermediateInfrastructureNode()).basicAdd(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER:
				return ((InternalEList<?>)getIntermediateContainer()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE:
				return ((InternalEList<?>)getIntermediateInfrastructureNode()).basicRemove(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
				return getSourceModelUri();
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
				return getImports();
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER:
				return getIntermediateContainer();
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE:
				return getIntermediateInfrastructureNode();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
				setSourceModelUri((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends IntermediateImport>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER:
				getIntermediateContainer().clear();
				getIntermediateContainer().addAll((Collection<? extends IntermediateContainer>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE:
				getIntermediateInfrastructureNode().clear();
				getIntermediateInfrastructureNode().addAll((Collection<? extends IntermediateInfrastructureNode>)newValue);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
				setSourceModelUri(SOURCE_MODEL_URI_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
				getImports().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER:
				getIntermediateContainer().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE:
				getIntermediateInfrastructureNode().clear();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
				return SOURCE_MODEL_URI_EDEFAULT == null ? sourceModelUri != null : !SOURCE_MODEL_URI_EDEFAULT.equals(sourceModelUri);
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER:
				return intermediateContainer != null && !intermediateContainer.isEmpty();
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE:
				return intermediateInfrastructureNode != null && !intermediateInfrastructureNode.isEmpty();
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
		result.append(" (sourceModelUri: ");
		result.append(sourceModelUri);
		result.append(')');
		return result.toString();
	}

} //IntermediateOperationModelImpl
