/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.DataPackage;

import de.fhdo.lemma.operation.intermediate.IntermediateContainer;
import de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference;
import de.fhdo.lemma.operation.intermediate.IntermediateFactory;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

import de.fhdo.lemma.service.ServicePackage;

import de.fhdo.lemma.technology.TechnologyPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntermediatePackageImpl extends EPackageImpl implements IntermediatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateOperationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateOperationNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateInfrastructureNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateServiceDeploymentSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateOperationEnvironmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateOperationTechnologyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateDeploymentTechnologyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateInfrastructureTechnologyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateInfrastructureTechnologyReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateDeploymentTechnologyReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateTechnologySpecificPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateTechnologySpecificPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationMicroserviceReferenceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IntermediatePackageImpl() {
		super(eNS_URI, IntermediateFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link IntermediatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IntermediatePackage init() {
		if (isInited) return (IntermediatePackage)EPackage.Registry.INSTANCE.getEPackage(IntermediatePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredIntermediatePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		IntermediatePackageImpl theIntermediatePackage = registeredIntermediatePackage instanceof IntermediatePackageImpl ? (IntermediatePackageImpl)registeredIntermediatePackage : new IntermediatePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		de.fhdo.lemma.data.intermediate.IntermediatePackage.eINSTANCE.eClass();
		de.fhdo.lemma.service.intermediate.IntermediatePackage.eINSTANCE.eClass();
		ServicePackage.eINSTANCE.eClass();
		TechnologyPackage.eINSTANCE.eClass();
		DataPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theIntermediatePackage.createPackageContents();

		// Initialize created meta-data
		theIntermediatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIntermediatePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IntermediatePackage.eNS_URI, theIntermediatePackage);
		return theIntermediatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateOperationModel() {
		return intermediateOperationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateOperationModel_SourceModelUri() {
		return (EAttribute)intermediateOperationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationModel_Imports() {
		return (EReference)intermediateOperationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationModel_Containers() {
		return (EReference)intermediateOperationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationModel_InfrastructureNodes() {
		return (EReference)intermediateOperationModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateOperationNode() {
		return intermediateOperationNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateOperationNode_Name() {
		return (EAttribute)intermediateOperationNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationNode_Imports() {
		return (EReference)intermediateOperationNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationNode_OperationEnvironment() {
		return (EReference)intermediateOperationNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationNode_DeployedServices() {
		return (EReference)intermediateOperationNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationNode_Endpoints() {
		return (EReference)intermediateOperationNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationNode_Specifications() {
		return (EReference)intermediateOperationNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateContainer() {
		return intermediateContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateContainer_TechnologyReference() {
		return (EReference)intermediateContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateContainer_OperationModel() {
		return (EReference)intermediateContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateInfrastructureNode() {
		return intermediateInfrastructureNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateInfrastructureNode_DependsOnNodes() {
		return (EReference)intermediateInfrastructureNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateInfrastructureNode_UsedByNodes() {
		return (EReference)intermediateInfrastructureNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateInfrastructureNode_Reference() {
		return (EReference)intermediateInfrastructureNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateInfrastructureNode_OperationModel() {
		return (EReference)intermediateInfrastructureNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateServiceDeploymentSpecification() {
		return intermediateServiceDeploymentSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateServiceDeploymentSpecification_Service() {
		return (EReference)intermediateServiceDeploymentSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateServiceDeploymentSpecification_PropertyValues() {
		return (EReference)intermediateServiceDeploymentSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateServiceDeploymentSpecification_Endpoints() {
		return (EReference)intermediateServiceDeploymentSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateServiceDeploymentSpecification_OperationNode() {
		return (EReference)intermediateServiceDeploymentSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateOperationEnvironment() {
		return intermediateOperationEnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateOperationEnvironment_EnvironmentName() {
		return (EAttribute)intermediateOperationEnvironmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateOperationEnvironment_Default() {
		return (EAttribute)intermediateOperationEnvironmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationEnvironment_OperationTechnology() {
		return (EReference)intermediateOperationEnvironmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateOperationTechnology() {
		return intermediateOperationTechnologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateOperationTechnology_Name() {
		return (EAttribute)intermediateOperationTechnologyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationTechnology_Environments() {
		return (EReference)intermediateOperationTechnologyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateOperationTechnology_Propertys() {
		return (EReference)intermediateOperationTechnologyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateDeploymentTechnology() {
		return intermediateDeploymentTechnologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateInfrastructureTechnology() {
		return intermediateInfrastructureTechnologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateInfrastructureTechnologyReference() {
		return intermediateInfrastructureTechnologyReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateInfrastructureTechnologyReference_Import() {
		return (EReference)intermediateInfrastructureTechnologyReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateInfrastructureTechnologyReference_InfrastructureTechnology() {
		return (EReference)intermediateInfrastructureTechnologyReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateInfrastructureTechnologyReference_InfrastructureNode() {
		return (EReference)intermediateInfrastructureTechnologyReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateDeploymentTechnologyReference() {
		return intermediateDeploymentTechnologyReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateDeploymentTechnologyReference_DeploymentTechnology() {
		return (EReference)intermediateDeploymentTechnologyReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateDeploymentTechnologyReference_Import() {
		return (EReference)intermediateDeploymentTechnologyReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateDeploymentTechnologyReference_Container() {
		return (EReference)intermediateDeploymentTechnologyReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateTechnologySpecificProperty() {
		return intermediateTechnologySpecificPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateTechnologySpecificProperty_Name() {
		return (EAttribute)intermediateTechnologySpecificPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateTechnologySpecificProperty_Type() {
		return (EAttribute)intermediateTechnologySpecificPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateTechnologySpecificProperty_DefaultValue() {
		return (EAttribute)intermediateTechnologySpecificPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateTechnologySpecificProperty_Featureames() {
		return (EAttribute)intermediateTechnologySpecificPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateTechnologySpecificProperty_PropertyValue() {
		return (EReference)intermediateTechnologySpecificPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateTechnologySpecificProperty_OperationTechnology() {
		return (EReference)intermediateTechnologySpecificPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateTechnologySpecificPropertyValue() {
		return intermediateTechnologySpecificPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermediateTechnologySpecificPropertyValue_Value() {
		return (EAttribute)intermediateTechnologySpecificPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateTechnologySpecificPropertyValue_Specification() {
		return (EReference)intermediateTechnologySpecificPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediateTechnologySpecificPropertyValue_Property() {
		return (EReference)intermediateTechnologySpecificPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationMicroserviceReference() {
		return operationMicroserviceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationMicroserviceReference_EffectivelyImplemented() {
		return (EAttribute)operationMicroserviceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationMicroserviceReference_MicroserviceType() {
		return (EAttribute)operationMicroserviceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationMicroserviceReference_Visibility() {
		return (EAttribute)operationMicroserviceReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationMicroserviceReference_IntermediateImport() {
		return (EReference)operationMicroserviceReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationMicroserviceReference_Service() {
		return (EReference)operationMicroserviceReferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationMicroserviceReference_Specification() {
		return (EReference)operationMicroserviceReferenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateFactory getIntermediateFactory() {
		return (IntermediateFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		intermediateOperationModelEClass = createEClass(INTERMEDIATE_OPERATION_MODEL);
		createEAttribute(intermediateOperationModelEClass, INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI);
		createEReference(intermediateOperationModelEClass, INTERMEDIATE_OPERATION_MODEL__IMPORTS);
		createEReference(intermediateOperationModelEClass, INTERMEDIATE_OPERATION_MODEL__CONTAINERS);
		createEReference(intermediateOperationModelEClass, INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES);

		intermediateOperationNodeEClass = createEClass(INTERMEDIATE_OPERATION_NODE);
		createEAttribute(intermediateOperationNodeEClass, INTERMEDIATE_OPERATION_NODE__NAME);
		createEReference(intermediateOperationNodeEClass, INTERMEDIATE_OPERATION_NODE__IMPORTS);
		createEReference(intermediateOperationNodeEClass, INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT);
		createEReference(intermediateOperationNodeEClass, INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES);
		createEReference(intermediateOperationNodeEClass, INTERMEDIATE_OPERATION_NODE__ENDPOINTS);
		createEReference(intermediateOperationNodeEClass, INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS);

		intermediateContainerEClass = createEClass(INTERMEDIATE_CONTAINER);
		createEReference(intermediateContainerEClass, INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE);
		createEReference(intermediateContainerEClass, INTERMEDIATE_CONTAINER__OPERATION_MODEL);

		intermediateInfrastructureNodeEClass = createEClass(INTERMEDIATE_INFRASTRUCTURE_NODE);
		createEReference(intermediateInfrastructureNodeEClass, INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDS_ON_NODES);
		createEReference(intermediateInfrastructureNodeEClass, INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_NODES);
		createEReference(intermediateInfrastructureNodeEClass, INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE);
		createEReference(intermediateInfrastructureNodeEClass, INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL);

		intermediateServiceDeploymentSpecificationEClass = createEClass(INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION);
		createEReference(intermediateServiceDeploymentSpecificationEClass, INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE);
		createEReference(intermediateServiceDeploymentSpecificationEClass, INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES);
		createEReference(intermediateServiceDeploymentSpecificationEClass, INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS);
		createEReference(intermediateServiceDeploymentSpecificationEClass, INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE);

		intermediateOperationEnvironmentEClass = createEClass(INTERMEDIATE_OPERATION_ENVIRONMENT);
		createEAttribute(intermediateOperationEnvironmentEClass, INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME);
		createEAttribute(intermediateOperationEnvironmentEClass, INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT);
		createEReference(intermediateOperationEnvironmentEClass, INTERMEDIATE_OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY);

		intermediateOperationTechnologyEClass = createEClass(INTERMEDIATE_OPERATION_TECHNOLOGY);
		createEAttribute(intermediateOperationTechnologyEClass, INTERMEDIATE_OPERATION_TECHNOLOGY__NAME);
		createEReference(intermediateOperationTechnologyEClass, INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENTS);
		createEReference(intermediateOperationTechnologyEClass, INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTYS);

		intermediateDeploymentTechnologyEClass = createEClass(INTERMEDIATE_DEPLOYMENT_TECHNOLOGY);

		intermediateInfrastructureTechnologyEClass = createEClass(INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY);

		intermediateInfrastructureTechnologyReferenceEClass = createEClass(INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE);
		createEReference(intermediateInfrastructureTechnologyReferenceEClass, INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT);
		createEReference(intermediateInfrastructureTechnologyReferenceEClass, INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY);
		createEReference(intermediateInfrastructureTechnologyReferenceEClass, INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE);

		intermediateDeploymentTechnologyReferenceEClass = createEClass(INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE);
		createEReference(intermediateDeploymentTechnologyReferenceEClass, INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY);
		createEReference(intermediateDeploymentTechnologyReferenceEClass, INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT);
		createEReference(intermediateDeploymentTechnologyReferenceEClass, INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER);

		intermediateTechnologySpecificPropertyEClass = createEClass(INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY);
		createEAttribute(intermediateTechnologySpecificPropertyEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME);
		createEAttribute(intermediateTechnologySpecificPropertyEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE);
		createEAttribute(intermediateTechnologySpecificPropertyEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE);
		createEAttribute(intermediateTechnologySpecificPropertyEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES);
		createEReference(intermediateTechnologySpecificPropertyEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__PROPERTY_VALUE);
		createEReference(intermediateTechnologySpecificPropertyEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY);

		intermediateTechnologySpecificPropertyValueEClass = createEClass(INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE);
		createEAttribute(intermediateTechnologySpecificPropertyValueEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE);
		createEReference(intermediateTechnologySpecificPropertyValueEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__SPECIFICATION);
		createEReference(intermediateTechnologySpecificPropertyValueEClass, INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__PROPERTY);

		operationMicroserviceReferenceEClass = createEClass(OPERATION_MICROSERVICE_REFERENCE);
		createEAttribute(operationMicroserviceReferenceEClass, OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED);
		createEAttribute(operationMicroserviceReferenceEClass, OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE);
		createEAttribute(operationMicroserviceReferenceEClass, OPERATION_MICROSERVICE_REFERENCE__VISIBILITY);
		createEReference(operationMicroserviceReferenceEClass, OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT);
		createEReference(operationMicroserviceReferenceEClass, OPERATION_MICROSERVICE_REFERENCE__SERVICE);
		createEReference(operationMicroserviceReferenceEClass, OPERATION_MICROSERVICE_REFERENCE__SPECIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		de.fhdo.lemma.data.intermediate.IntermediatePackage theIntermediatePackage_1 = (de.fhdo.lemma.data.intermediate.IntermediatePackage)EPackage.Registry.INSTANCE.getEPackage(de.fhdo.lemma.data.intermediate.IntermediatePackage.eNS_URI);
		de.fhdo.lemma.service.intermediate.IntermediatePackage theIntermediatePackage_2 = (de.fhdo.lemma.service.intermediate.IntermediatePackage)EPackage.Registry.INSTANCE.getEPackage(de.fhdo.lemma.service.intermediate.IntermediatePackage.eNS_URI);
		ServicePackage theServicePackage = (ServicePackage)EPackage.Registry.INSTANCE.getEPackage(ServicePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		intermediateContainerEClass.getESuperTypes().add(this.getIntermediateOperationNode());
		intermediateInfrastructureNodeEClass.getESuperTypes().add(this.getIntermediateOperationNode());
		intermediateDeploymentTechnologyEClass.getESuperTypes().add(this.getIntermediateOperationTechnology());
		intermediateInfrastructureTechnologyEClass.getESuperTypes().add(this.getIntermediateOperationTechnology());
		operationMicroserviceReferenceEClass.getESuperTypes().add(theIntermediatePackage_2.getMicroserviceReference());

		// Initialize classes, features, and operations; add parameters
		initEClass(intermediateOperationModelEClass, IntermediateOperationModel.class, "IntermediateOperationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateOperationModel_SourceModelUri(), theEcorePackage.getEString(), "sourceModelUri", null, 0, 1, IntermediateOperationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationModel_Imports(), theIntermediatePackage_1.getIntermediateImport(), null, "imports", null, 0, -1, IntermediateOperationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationModel_Containers(), this.getIntermediateContainer(), this.getIntermediateContainer_OperationModel(), "containers", null, 0, -1, IntermediateOperationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationModel_InfrastructureNodes(), this.getIntermediateInfrastructureNode(), this.getIntermediateInfrastructureNode_OperationModel(), "infrastructureNodes", null, 0, -1, IntermediateOperationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateOperationNodeEClass, IntermediateOperationNode.class, "IntermediateOperationNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateOperationNode_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateOperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationNode_Imports(), theIntermediatePackage_1.getIntermediateImport(), null, "imports", null, 1, -1, IntermediateOperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationNode_OperationEnvironment(), this.getIntermediateOperationEnvironment(), null, "operationEnvironment", null, 0, 1, IntermediateOperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationNode_DeployedServices(), this.getOperationMicroserviceReference(), this.getOperationMicroserviceReference_Service(), "deployedServices", null, 0, -1, IntermediateOperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationNode_Endpoints(), theIntermediatePackage_2.getIntermediateEndpoint(), null, "endpoints", null, 1, -1, IntermediateOperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationNode_Specifications(), this.getIntermediateServiceDeploymentSpecification(), this.getIntermediateServiceDeploymentSpecification_OperationNode(), "specifications", null, 0, -1, IntermediateOperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateContainerEClass, IntermediateContainer.class, "IntermediateContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntermediateContainer_TechnologyReference(), this.getIntermediateDeploymentTechnologyReference(), this.getIntermediateDeploymentTechnologyReference_Container(), "technologyReference", null, 0, 1, IntermediateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateContainer_OperationModel(), this.getIntermediateOperationModel(), this.getIntermediateOperationModel_Containers(), "operationModel", null, 0, 1, IntermediateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateInfrastructureNodeEClass, IntermediateInfrastructureNode.class, "IntermediateInfrastructureNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntermediateInfrastructureNode_DependsOnNodes(), this.getIntermediateOperationNode(), null, "dependsOnNodes", null, 0, -1, IntermediateInfrastructureNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInfrastructureNode_UsedByNodes(), this.getIntermediateOperationNode(), null, "usedByNodes", null, 0, -1, IntermediateInfrastructureNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInfrastructureNode_Reference(), this.getIntermediateInfrastructureTechnologyReference(), this.getIntermediateInfrastructureTechnologyReference_InfrastructureNode(), "reference", null, 0, 1, IntermediateInfrastructureNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInfrastructureNode_OperationModel(), this.getIntermediateOperationModel(), this.getIntermediateOperationModel_InfrastructureNodes(), "operationModel", null, 0, 1, IntermediateInfrastructureNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateServiceDeploymentSpecificationEClass, IntermediateServiceDeploymentSpecification.class, "IntermediateServiceDeploymentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntermediateServiceDeploymentSpecification_Service(), this.getOperationMicroserviceReference(), this.getOperationMicroserviceReference_Specification(), "service", null, 0, 1, IntermediateServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateServiceDeploymentSpecification_PropertyValues(), this.getIntermediateTechnologySpecificPropertyValue(), this.getIntermediateTechnologySpecificPropertyValue_Specification(), "propertyValues", null, 0, -1, IntermediateServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateServiceDeploymentSpecification_Endpoints(), theIntermediatePackage_2.getIntermediateEndpoint(), null, "endpoints", null, 1, -1, IntermediateServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateServiceDeploymentSpecification_OperationNode(), this.getIntermediateOperationNode(), this.getIntermediateOperationNode_Specifications(), "operationNode", null, 0, 1, IntermediateServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateOperationEnvironmentEClass, IntermediateOperationEnvironment.class, "IntermediateOperationEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateOperationEnvironment_EnvironmentName(), theEcorePackage.getEString(), "environmentName", null, 0, 1, IntermediateOperationEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateOperationEnvironment_Default(), theEcorePackage.getEBoolean(), "default", "false", 0, 1, IntermediateOperationEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationEnvironment_OperationTechnology(), this.getIntermediateOperationTechnology(), this.getIntermediateOperationTechnology_Environments(), "operationTechnology", null, 0, 1, IntermediateOperationEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateOperationTechnologyEClass, IntermediateOperationTechnology.class, "IntermediateOperationTechnology", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateOperationTechnology_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateOperationTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationTechnology_Environments(), this.getIntermediateOperationEnvironment(), this.getIntermediateOperationEnvironment_OperationTechnology(), "environments", null, 1, -1, IntermediateOperationTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperationTechnology_Propertys(), this.getIntermediateTechnologySpecificProperty(), this.getIntermediateTechnologySpecificProperty_OperationTechnology(), "propertys", null, 0, -1, IntermediateOperationTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateDeploymentTechnologyEClass, IntermediateDeploymentTechnology.class, "IntermediateDeploymentTechnology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intermediateInfrastructureTechnologyEClass, IntermediateInfrastructureTechnology.class, "IntermediateInfrastructureTechnology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intermediateInfrastructureTechnologyReferenceEClass, IntermediateInfrastructureTechnologyReference.class, "IntermediateInfrastructureTechnologyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntermediateInfrastructureTechnologyReference_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, IntermediateInfrastructureTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInfrastructureTechnologyReference_InfrastructureTechnology(), this.getIntermediateInfrastructureTechnology(), null, "infrastructureTechnology", null, 0, 1, IntermediateInfrastructureTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInfrastructureTechnologyReference_InfrastructureNode(), this.getIntermediateInfrastructureNode(), this.getIntermediateInfrastructureNode_Reference(), "infrastructureNode", null, 0, 1, IntermediateInfrastructureTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateDeploymentTechnologyReferenceEClass, IntermediateDeploymentTechnologyReference.class, "IntermediateDeploymentTechnologyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntermediateDeploymentTechnologyReference_DeploymentTechnology(), this.getIntermediateDeploymentTechnology(), null, "deploymentTechnology", null, 0, 1, IntermediateDeploymentTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateDeploymentTechnologyReference_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, IntermediateDeploymentTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateDeploymentTechnologyReference_Container(), this.getIntermediateContainer(), this.getIntermediateContainer_TechnologyReference(), "container", null, 0, 1, IntermediateDeploymentTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateTechnologySpecificPropertyEClass, IntermediateTechnologySpecificProperty.class, "IntermediateTechnologySpecificProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateTechnologySpecificProperty_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateTechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateTechnologySpecificProperty_Type(), theEcorePackage.getEString(), "type", null, 0, 1, IntermediateTechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateTechnologySpecificProperty_DefaultValue(), theEcorePackage.getEString(), "defaultValue", null, 0, 1, IntermediateTechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateTechnologySpecificProperty_Featureames(), theEcorePackage.getEString(), "featureames", null, 0, -1, IntermediateTechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateTechnologySpecificProperty_PropertyValue(), this.getIntermediateTechnologySpecificPropertyValue(), this.getIntermediateTechnologySpecificPropertyValue_Property(), "propertyValue", null, 0, 1, IntermediateTechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateTechnologySpecificProperty_OperationTechnology(), this.getIntermediateOperationTechnology(), this.getIntermediateOperationTechnology_Propertys(), "operationTechnology", null, 0, 1, IntermediateTechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateTechnologySpecificPropertyValueEClass, IntermediateTechnologySpecificPropertyValue.class, "IntermediateTechnologySpecificPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateTechnologySpecificPropertyValue_Value(), theEcorePackage.getEString(), "value", null, 0, 1, IntermediateTechnologySpecificPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateTechnologySpecificPropertyValue_Specification(), this.getIntermediateServiceDeploymentSpecification(), this.getIntermediateServiceDeploymentSpecification_PropertyValues(), "specification", null, 0, 1, IntermediateTechnologySpecificPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateTechnologySpecificPropertyValue_Property(), this.getIntermediateTechnologySpecificProperty(), this.getIntermediateTechnologySpecificProperty_PropertyValue(), "property", null, 0, 1, IntermediateTechnologySpecificPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationMicroserviceReferenceEClass, OperationMicroserviceReference.class, "OperationMicroserviceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationMicroserviceReference_EffectivelyImplemented(), theEcorePackage.getEBoolean(), "effectivelyImplemented", null, 0, 1, OperationMicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationMicroserviceReference_MicroserviceType(), theServicePackage.getMicroserviceType(), "microserviceType", null, 0, 1, OperationMicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationMicroserviceReference_Visibility(), theServicePackage.getVisibility(), "visibility", null, 0, 1, OperationMicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationMicroserviceReference_IntermediateImport(), theIntermediatePackage_1.getIntermediateImport(), null, "intermediateImport", null, 0, 1, OperationMicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationMicroserviceReference_Service(), this.getIntermediateOperationNode(), this.getIntermediateOperationNode_DeployedServices(), "service", null, 0, 1, OperationMicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationMicroserviceReference_Specification(), this.getIntermediateServiceDeploymentSpecification(), this.getIntermediateServiceDeploymentSpecification_Service(), "specification", null, 0, 1, OperationMicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //IntermediatePackageImpl
