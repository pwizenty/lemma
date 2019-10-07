/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.operation.intermediate.IntermediateFactory
 * @model kind="package"
 * @generated
 */
public interface IntermediatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "intermediate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.fhdo.de/lemma/operation/intermediate";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "intermediate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IntermediatePackage eINSTANCE = de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl <em>Operation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationModel()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Source Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Intermediate Infrastructure Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE = 3;

	/**
	 * The number of structural features of the '<em>Operation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Operation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl <em>Operation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationNode()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Import</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT = 2;

	/**
	 * The feature id for the '<em><b>Operation Microservice References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES = 3;

	/**
	 * The feature id for the '<em><b>Intermediate Service Deployment Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = 4;

	/**
	 * The number of structural features of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateContainer()
	 * @generated
	 */
	int INTERMEDIATE_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__NAME = INTERMEDIATE_OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Intermediate Import</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__INTERMEDIATE_IMPORT = INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_ENVIRONMENT = INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Operation Microservice References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__OPERATION_MICROSERVICE_REFERENCES = INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Intermediate Service Deployment Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Intermediate Deployment Technology Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Intermediate Endpoint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER_FEATURE_COUNT = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER_OPERATION_COUNT = INTERMEDIATE_OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl <em>Infrastructure Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureNode()
	 * @generated
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__NAME = INTERMEDIATE_OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Intermediate Import</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_IMPORT = INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT = INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Operation Microservice References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MICROSERVICE_REFERENCES = INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Intermediate Service Deployment Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Dependent Operation Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDENT_OPERATION_NODES = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Used By Operation Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_OPERATION_NODES = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Intermediate Infrastructure Technology Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Intermediate Endpoint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Infrastructure Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE_FEATURE_COUNT = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Infrastructure Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE_OPERATION_COUNT = INTERMEDIATE_OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl <em>Service Deployment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Operation Microservice Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Technology Specific Property Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS = 2;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE = 3;

	/**
	 * The number of structural features of the '<em>Service Deployment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Service Deployment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl <em>Operation Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationEnvironment()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT = 5;

	/**
	 * The feature id for the '<em><b>Environment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Operationtechnology</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY = 2;

	/**
	 * The number of structural features of the '<em>Operation Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operation Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl <em>Operation Technology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationTechnology()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Environment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Technology Specific Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = 2;

	/**
	 * The number of structural features of the '<em>Operation Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operation Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl <em>Deployment Technology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnology()
	 * @generated
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__NAME = INTERMEDIATE_OPERATION_TECHNOLOGY__NAME;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Environment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT = INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Intermediate Technology Specific Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY;

	/**
	 * The number of structural features of the '<em>Deployment Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_FEATURE_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Deployment Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_OPERATION_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl <em>Infrastructure Technology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnology()
	 * @generated
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__NAME = INTERMEDIATE_OPERATION_TECHNOLOGY__NAME;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Environment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT = INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Intermediate Technology Specific Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY;

	/**
	 * The number of structural features of the '<em>Infrastructure Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_FEATURE_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Infrastructure Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_OPERATION_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl <em>Infrastructure Technology Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Intermediate Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Infrastructure Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Infrastructure Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE = 2;

	/**
	 * The number of structural features of the '<em>Infrastructure Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Infrastructure Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl <em>Deployment Technology Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Intermediate Deployment Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER = 2;

	/**
	 * The number of structural features of the '<em>Deployment Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Deployment Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl <em>Technology Specific Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Featureames</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES = 3;

	/**
	 * The feature id for the '<em><b>Intermediate Technology Specific Property Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Intermediate Operation Technology</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY = 5;

	/**
	 * The number of structural features of the '<em>Technology Specific Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Technology Specific Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl <em>Technology Specific Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Service Deployment Specification</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Intermediate Technology Specific Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = 2;

	/**
	 * The number of structural features of the '<em>Technology Specific Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Technology Specific Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl <em>Operation Microservice Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getOperationMicroserviceReference()
	 * @generated
	 */
	int OPERATION_MICROSERVICE_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__NAME = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__VERSION = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__VERSION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__QUALIFIED_NAME = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Imported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__IMPORTED = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__IMPORTED;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__IMPORT = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT;

	/**
	 * The feature id for the '<em><b>Local Microservice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE;

	/**
	 * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE;

	/**
	 * The feature id for the '<em><b>Effectively Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Microservice Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__VISIBILITY = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Intermediate Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operation Microservice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE_FEATURE_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Operation Microservice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE_OPERATION_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel <em>Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Model</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
	 * @generated
	 */
	EClass getIntermediateOperationModel();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri <em>Source Model Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Model Uri</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EAttribute getIntermediateOperationModel_SourceModelUri();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getImports()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EReference getIntermediateOperationModel_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateContainer <em>Intermediate Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Container</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateContainer()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EReference getIntermediateOperationModel_IntermediateContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Infrastructure Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getIntermediateInfrastructureNode()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EReference getIntermediateOperationModel_IntermediateInfrastructureNode();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
	 * @generated
	 */
	EClass getIntermediateOperationNode();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EAttribute getIntermediateOperationNode_Name();

	/**
	 * Returns the meta object for the reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateImport <em>Intermediate Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Intermediate Import</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateImport()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_IntermediateImport();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateOperationEnvironment <em>Intermediate Operation Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intermediate Operation Environment</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateOperationEnvironment()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_IntermediateOperationEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getOperationMicroserviceReferences <em>Operation Microservice References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operation Microservice References</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getOperationMicroserviceReferences()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_OperationMicroserviceReferences();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Service Deployment Specification</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getIntermediateServiceDeploymentSpecification()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_IntermediateServiceDeploymentSpecification();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer
	 * @generated
	 */
	EClass getIntermediateContainer();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateDeploymentTechnologyReference <em>Intermediate Deployment Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Intermediate Deployment Technology Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateDeploymentTechnologyReference()
	 * @see #getIntermediateContainer()
	 * @generated
	 */
	EReference getIntermediateContainer_IntermediateDeploymentTechnologyReference();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateEndpoint <em>Intermediate Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Endpoint</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateEndpoint()
	 * @see #getIntermediateContainer()
	 * @generated
	 */
	EReference getIntermediateContainer_IntermediateEndpoint();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateOperationModel <em>Intermediate Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Operation Model</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getIntermediateOperationModel()
	 * @see #getIntermediateContainer()
	 * @generated
	 */
	EReference getIntermediateContainer_IntermediateOperationModel();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode <em>Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
	 * @generated
	 */
	EClass getIntermediateInfrastructureNode();

	/**
	 * Returns the meta object for the reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getDependentOperationNodes <em>Dependent Operation Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependent Operation Nodes</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getDependentOperationNodes()
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	EReference getIntermediateInfrastructureNode_DependentOperationNodes();

	/**
	 * Returns the meta object for the reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getUsedByOperationNodes <em>Used By Operation Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used By Operation Nodes</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getUsedByOperationNodes()
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	EReference getIntermediateInfrastructureNode_UsedByOperationNodes();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateInfrastructureTechnologyReference <em>Intermediate Infrastructure Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Intermediate Infrastructure Technology Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateInfrastructureTechnologyReference()
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	EReference getIntermediateInfrastructureNode_IntermediateInfrastructureTechnologyReference();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateEndpoint <em>Intermediate Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Endpoint</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateEndpoint()
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	EReference getIntermediateInfrastructureNode_IntermediateEndpoint();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateOperationModel <em>Intermediate Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Operation Model</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getIntermediateOperationModel()
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	EReference getIntermediateInfrastructureNode_IntermediateOperationModel();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification <em>Service Deployment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Deployment Specification</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification
	 * @generated
	 */
	EClass getIntermediateServiceDeploymentSpecification();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationMicroserviceReference <em>Operation Microservice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Microservice Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationMicroserviceReference()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_OperationMicroserviceReference();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateTechnologySpecificPropertyValue <em>Intermediate Technology Specific Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Technology Specific Property Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateTechnologySpecificPropertyValue()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_IntermediateTechnologySpecificPropertyValue();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateEndpoints <em>Intermediate Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Endpoints</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateEndpoints()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_IntermediateEndpoints();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateOperationNode <em>Intermediate Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Operation Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getIntermediateOperationNode()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_IntermediateOperationNode();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment <em>Operation Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Environment</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment
	 * @generated
	 */
	EClass getIntermediateOperationEnvironment();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getEnvironmentName <em>Environment Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Environment Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getEnvironmentName()
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 */
	EAttribute getIntermediateOperationEnvironment_EnvironmentName();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#isDefault()
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 */
	EAttribute getIntermediateOperationEnvironment_Default();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getIntermediateOperationtechnology <em>Intermediate Operationtechnology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Operationtechnology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getIntermediateOperationtechnology()
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 */
	EReference getIntermediateOperationEnvironment_IntermediateOperationtechnology();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology <em>Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology
	 * @generated
	 */
	EClass getIntermediateOperationTechnology();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName()
	 * @see #getIntermediateOperationTechnology()
	 * @generated
	 */
	EAttribute getIntermediateOperationTechnology_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getIntermediateOperationEnvironment <em>Intermediate Operation Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Operation Environment</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getIntermediateOperationEnvironment()
	 * @see #getIntermediateOperationTechnology()
	 * @generated
	 */
	EReference getIntermediateOperationTechnology_IntermediateOperationEnvironment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getIntermediateTechnologySpecificProperty <em>Intermediate Technology Specific Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intermediate Technology Specific Property</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getIntermediateTechnologySpecificProperty()
	 * @see #getIntermediateOperationTechnology()
	 * @generated
	 */
	EReference getIntermediateOperationTechnology_IntermediateTechnologySpecificProperty();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology <em>Deployment Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology
	 * @generated
	 */
	EClass getIntermediateDeploymentTechnology();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology <em>Infrastructure Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology
	 * @generated
	 */
	EClass getIntermediateInfrastructureTechnology();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference <em>Infrastructure Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Technology Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference
	 * @generated
	 */
	EClass getIntermediateInfrastructureTechnologyReference();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateImport <em>Intermediate Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intermediate Import</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateImport()
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateInfrastructureTechnologyReference_IntermediateImport();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureTechnology <em>Intermediate Infrastructure Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intermediate Infrastructure Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureTechnology()
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateInfrastructureTechnologyReference_IntermediateInfrastructureTechnology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureNode <em>Intermediate Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Infrastructure Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getIntermediateInfrastructureNode()
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateInfrastructureTechnologyReference_IntermediateInfrastructureNode();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference <em>Deployment Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Technology Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference
	 * @generated
	 */
	EClass getIntermediateDeploymentTechnologyReference();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateDeploymentTechnology <em>Intermediate Deployment Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intermediate Deployment Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateDeploymentTechnology()
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateDeploymentTechnologyReference_IntermediateDeploymentTechnology();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateImport <em>Intermediate Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intermediate Import</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateImport()
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateDeploymentTechnologyReference_IntermediateImport();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateContainer <em>Intermediate Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Container</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getIntermediateContainer()
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateDeploymentTechnologyReference_IntermediateContainer();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty <em>Technology Specific Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technology Specific Property</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty
	 * @generated
	 */
	EClass getIntermediateTechnologySpecificProperty();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getName()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getType()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getDefaultValue()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_DefaultValue();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getFeatureames <em>Featureames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Featureames</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getFeatureames()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_Featureames();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateTechnologySpecificPropertyValue <em>Intermediate Technology Specific Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Intermediate Technology Specific Property Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateTechnologySpecificPropertyValue()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificProperty_IntermediateTechnologySpecificPropertyValue();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateOperationTechnology <em>Intermediate Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Operation Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getIntermediateOperationTechnology()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificProperty_IntermediateOperationTechnology();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue <em>Technology Specific Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technology Specific Property Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue
	 * @generated
	 */
	EClass getIntermediateTechnologySpecificPropertyValue();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getValue()
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificPropertyValue_Value();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateServiceDeploymentSpecification <em>Intermediate Service Deployment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Service Deployment Specification</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateServiceDeploymentSpecification()
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificPropertyValue_IntermediateServiceDeploymentSpecification();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateTechnologySpecificProperty <em>Intermediate Technology Specific Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Technology Specific Property</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getIntermediateTechnologySpecificProperty()
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificPropertyValue_IntermediateTechnologySpecificProperty();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference <em>Operation Microservice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Microservice Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
	 * @generated
	 */
	EClass getOperationMicroserviceReference();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented <em>Effectively Implemented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Implemented</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EAttribute getOperationMicroserviceReference_EffectivelyImplemented();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType <em>Microservice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Microservice Type</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EAttribute getOperationMicroserviceReference_MicroserviceType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EAttribute getOperationMicroserviceReference_Visibility();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getIntermediateImport <em>Intermediate Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intermediate Import</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getIntermediateImport()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EReference getOperationMicroserviceReference_IntermediateImport();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IntermediateFactory getIntermediateFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl <em>Operation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationModel()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_MODEL = eINSTANCE.getIntermediateOperationModel();

		/**
		 * The meta object literal for the '<em><b>Source Model Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI = eINSTANCE.getIntermediateOperationModel_SourceModelUri();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_MODEL__IMPORTS = eINSTANCE.getIntermediateOperationModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Intermediate Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_CONTAINER = eINSTANCE.getIntermediateOperationModel_IntermediateContainer();

		/**
		 * The meta object literal for the '<em><b>Intermediate Infrastructure Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_MODEL__INTERMEDIATE_INFRASTRUCTURE_NODE = eINSTANCE.getIntermediateOperationModel_IntermediateInfrastructureNode();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl <em>Operation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationNode()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_NODE = eINSTANCE.getIntermediateOperationNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_NODE__NAME = eINSTANCE.getIntermediateOperationNode_Name();

		/**
		 * The meta object literal for the '<em><b>Intermediate Import</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_IMPORT = eINSTANCE.getIntermediateOperationNode_IntermediateImport();

		/**
		 * The meta object literal for the '<em><b>Intermediate Operation Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_OPERATION_ENVIRONMENT = eINSTANCE.getIntermediateOperationNode_IntermediateOperationEnvironment();

		/**
		 * The meta object literal for the '<em><b>Operation Microservice References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__OPERATION_MICROSERVICE_REFERENCES = eINSTANCE.getIntermediateOperationNode_OperationMicroserviceReferences();

		/**
		 * The meta object literal for the '<em><b>Intermediate Service Deployment Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = eINSTANCE.getIntermediateOperationNode_IntermediateServiceDeploymentSpecification();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateContainer()
		 * @generated
		 */
		EClass INTERMEDIATE_CONTAINER = eINSTANCE.getIntermediateContainer();

		/**
		 * The meta object literal for the '<em><b>Intermediate Deployment Technology Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTAINER__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE = eINSTANCE.getIntermediateContainer_IntermediateDeploymentTechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Intermediate Endpoint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTAINER__INTERMEDIATE_ENDPOINT = eINSTANCE.getIntermediateContainer_IntermediateEndpoint();

		/**
		 * The meta object literal for the '<em><b>Intermediate Operation Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTAINER__INTERMEDIATE_OPERATION_MODEL = eINSTANCE.getIntermediateContainer_IntermediateOperationModel();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl <em>Infrastructure Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureNode()
		 * @generated
		 */
		EClass INTERMEDIATE_INFRASTRUCTURE_NODE = eINSTANCE.getIntermediateInfrastructureNode();

		/**
		 * The meta object literal for the '<em><b>Dependent Operation Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDENT_OPERATION_NODES = eINSTANCE.getIntermediateInfrastructureNode_DependentOperationNodes();

		/**
		 * The meta object literal for the '<em><b>Used By Operation Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_OPERATION_NODES = eINSTANCE.getIntermediateInfrastructureNode_UsedByOperationNodes();

		/**
		 * The meta object literal for the '<em><b>Intermediate Infrastructure Technology Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE = eINSTANCE.getIntermediateInfrastructureNode_IntermediateInfrastructureTechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Intermediate Endpoint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_ENDPOINT = eINSTANCE.getIntermediateInfrastructureNode_IntermediateEndpoint();

		/**
		 * The meta object literal for the '<em><b>Intermediate Operation Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_NODE__INTERMEDIATE_OPERATION_MODEL = eINSTANCE.getIntermediateInfrastructureNode_IntermediateOperationModel();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl <em>Service Deployment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateServiceDeploymentSpecification()
		 * @generated
		 */
		EClass INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = eINSTANCE.getIntermediateServiceDeploymentSpecification();

		/**
		 * The meta object literal for the '<em><b>Operation Microservice Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE = eINSTANCE.getIntermediateServiceDeploymentSpecification_OperationMicroserviceReference();

		/**
		 * The meta object literal for the '<em><b>Intermediate Technology Specific Property Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = eINSTANCE.getIntermediateServiceDeploymentSpecification_IntermediateTechnologySpecificPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Intermediate Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_ENDPOINTS = eINSTANCE.getIntermediateServiceDeploymentSpecification_IntermediateEndpoints();

		/**
		 * The meta object literal for the '<em><b>Intermediate Operation Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__INTERMEDIATE_OPERATION_NODE = eINSTANCE.getIntermediateServiceDeploymentSpecification_IntermediateOperationNode();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl <em>Operation Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationEnvironment()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_ENVIRONMENT = eINSTANCE.getIntermediateOperationEnvironment();

		/**
		 * The meta object literal for the '<em><b>Environment Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME = eINSTANCE.getIntermediateOperationEnvironment_EnvironmentName();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT = eINSTANCE.getIntermediateOperationEnvironment_Default();

		/**
		 * The meta object literal for the '<em><b>Intermediate Operationtechnology</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_ENVIRONMENT__INTERMEDIATE_OPERATIONTECHNOLOGY = eINSTANCE.getIntermediateOperationEnvironment_IntermediateOperationtechnology();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl <em>Operation Technology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationTechnology()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_TECHNOLOGY = eINSTANCE.getIntermediateOperationTechnology();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_TECHNOLOGY__NAME = eINSTANCE.getIntermediateOperationTechnology_Name();

		/**
		 * The meta object literal for the '<em><b>Intermediate Operation Environment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_OPERATION_ENVIRONMENT = eINSTANCE.getIntermediateOperationTechnology_IntermediateOperationEnvironment();

		/**
		 * The meta object literal for the '<em><b>Intermediate Technology Specific Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_TECHNOLOGY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = eINSTANCE.getIntermediateOperationTechnology_IntermediateTechnologySpecificProperty();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl <em>Deployment Technology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnology()
		 * @generated
		 */
		EClass INTERMEDIATE_DEPLOYMENT_TECHNOLOGY = eINSTANCE.getIntermediateDeploymentTechnology();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl <em>Infrastructure Technology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnology()
		 * @generated
		 */
		EClass INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY = eINSTANCE.getIntermediateInfrastructureTechnology();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl <em>Infrastructure Technology Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnologyReference()
		 * @generated
		 */
		EClass INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE = eINSTANCE.getIntermediateInfrastructureTechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Intermediate Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT = eINSTANCE.getIntermediateInfrastructureTechnologyReference_IntermediateImport();

		/**
		 * The meta object literal for the '<em><b>Intermediate Infrastructure Technology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY = eINSTANCE.getIntermediateInfrastructureTechnologyReference_IntermediateInfrastructureTechnology();

		/**
		 * The meta object literal for the '<em><b>Intermediate Infrastructure Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INTERMEDIATE_INFRASTRUCTURE_NODE = eINSTANCE.getIntermediateInfrastructureTechnologyReference_IntermediateInfrastructureNode();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl <em>Deployment Technology Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnologyReference()
		 * @generated
		 */
		EClass INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE = eINSTANCE.getIntermediateDeploymentTechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Intermediate Deployment Technology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_DEPLOYMENT_TECHNOLOGY = eINSTANCE.getIntermediateDeploymentTechnologyReference_IntermediateDeploymentTechnology();

		/**
		 * The meta object literal for the '<em><b>Intermediate Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_IMPORT = eINSTANCE.getIntermediateDeploymentTechnologyReference_IntermediateImport();

		/**
		 * The meta object literal for the '<em><b>Intermediate Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__INTERMEDIATE_CONTAINER = eINSTANCE.getIntermediateDeploymentTechnologyReference_IntermediateContainer();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl <em>Technology Specific Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificProperty()
		 * @generated
		 */
		EClass INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = eINSTANCE.getIntermediateTechnologySpecificProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME = eINSTANCE.getIntermediateTechnologySpecificProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE = eINSTANCE.getIntermediateTechnologySpecificProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE = eINSTANCE.getIntermediateTechnologySpecificProperty_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Featureames</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATUREAMES = eINSTANCE.getIntermediateTechnologySpecificProperty_Featureames();

		/**
		 * The meta object literal for the '<em><b>Intermediate Technology Specific Property Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = eINSTANCE.getIntermediateTechnologySpecificProperty_IntermediateTechnologySpecificPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Intermediate Operation Technology</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__INTERMEDIATE_OPERATION_TECHNOLOGY = eINSTANCE.getIntermediateTechnologySpecificProperty_IntermediateOperationTechnology();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl <em>Technology Specific Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificPropertyValue()
		 * @generated
		 */
		EClass INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = eINSTANCE.getIntermediateTechnologySpecificPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE = eINSTANCE.getIntermediateTechnologySpecificPropertyValue_Value();

		/**
		 * The meta object literal for the '<em><b>Intermediate Service Deployment Specification</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = eINSTANCE.getIntermediateTechnologySpecificPropertyValue_IntermediateServiceDeploymentSpecification();

		/**
		 * The meta object literal for the '<em><b>Intermediate Technology Specific Property</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = eINSTANCE.getIntermediateTechnologySpecificPropertyValue_IntermediateTechnologySpecificProperty();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl <em>Operation Microservice Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getOperationMicroserviceReference()
		 * @generated
		 */
		EClass OPERATION_MICROSERVICE_REFERENCE = eINSTANCE.getOperationMicroserviceReference();

		/**
		 * The meta object literal for the '<em><b>Effectively Implemented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED = eINSTANCE.getOperationMicroserviceReference_EffectivelyImplemented();

		/**
		 * The meta object literal for the '<em><b>Microservice Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE = eINSTANCE.getOperationMicroserviceReference_MicroserviceType();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_MICROSERVICE_REFERENCE__VISIBILITY = eINSTANCE.getOperationMicroserviceReference_Visibility();

		/**
		 * The meta object literal for the '<em><b>Intermediate Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_MICROSERVICE_REFERENCE__INTERMEDIATE_IMPORT = eINSTANCE.getOperationMicroserviceReference_IntermediateImport();

	}

} //IntermediatePackage
