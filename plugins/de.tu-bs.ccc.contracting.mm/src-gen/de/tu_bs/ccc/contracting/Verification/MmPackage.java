/**
 */
package de.tu_bs.ccc.contracting.Verification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.tu_bs.ccc.contracting.Verification.MmFactory
 * @model kind="package"
 * @generated
 */
public interface MmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Verification";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/contractVerificationMM";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Verification";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MmPackage eINSTANCE = de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Is Part Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__IS_PART_OF = 1;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__REALIZED_BY = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__PORTS = 4;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CONTRACT = 5;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE = 6;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__VERSION = 7;

	/**
	 * The feature id for the '<em><b>Rte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__RTE = 8;

	/**
	 * The feature id for the '<em><b>Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__SPEC = 9;

	/**
	 * The feature id for the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__RAM = 10;

	/**
	 * The feature id for the '<em><b>Caps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CAPS = 11;

	/**
	 * The feature id for the '<em><b>Module Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Enviromental Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ENVIROMENTAL_PROPERTIES = 13;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.AbstractImpl <em>Abstract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.AbstractImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getAbstract()
	 * @generated
	 */
	int ABSTRACT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__NAME = MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Is Part Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__IS_PART_OF = MODULE__IS_PART_OF;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__REALIZED_BY = MODULE__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__DESCRIPTION = MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__PORTS = MODULE__PORTS;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__CONTRACT = MODULE__CONTRACT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__MODULE = MODULE__MODULE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__VERSION = MODULE__VERSION;

	/**
	 * The feature id for the '<em><b>Rte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__RTE = MODULE__RTE;

	/**
	 * The feature id for the '<em><b>Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__SPEC = MODULE__SPEC;

	/**
	 * The feature id for the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__RAM = MODULE__RAM;

	/**
	 * The feature id for the '<em><b>Caps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__CAPS = MODULE__CAPS;

	/**
	 * The feature id for the '<em><b>Module Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__MODULE_TYPE = MODULE__MODULE_TYPE;

	/**
	 * The feature id for the '<em><b>Enviromental Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__ENVIROMENTAL_PROPERTIES = MODULE__ENVIROMENTAL_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__REALIZES = MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.ComponentImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Is Part Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__IS_PART_OF = MODULE__IS_PART_OF;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REALIZED_BY = MODULE__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DESCRIPTION = MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PORTS = MODULE__PORTS;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CONTRACT = MODULE__CONTRACT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__MODULE = MODULE__MODULE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__VERSION = MODULE__VERSION;

	/**
	 * The feature id for the '<em><b>Rte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__RTE = MODULE__RTE;

	/**
	 * The feature id for the '<em><b>Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SPEC = MODULE__SPEC;

	/**
	 * The feature id for the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__RAM = MODULE__RAM;

	/**
	 * The feature id for the '<em><b>Caps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CAPS = MODULE__CAPS;

	/**
	 * The feature id for the '<em><b>Module Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__MODULE_TYPE = MODULE__MODULE_TYPE;

	/**
	 * The feature id for the '<em><b>Enviromental Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ENVIROMENTAL_PROPERTIES = MODULE__ENVIROMENTAL_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SINGLETON = MODULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__BINARY = MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = MODULE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.CompoundImpl <em>Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.CompoundImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getCompound()
	 * @generated
	 */
	int COMPOUND = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__NAME = MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Is Part Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__IS_PART_OF = MODULE__IS_PART_OF;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__REALIZED_BY = MODULE__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__DESCRIPTION = MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__PORTS = MODULE__PORTS;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__CONTRACT = MODULE__CONTRACT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__MODULE = MODULE__MODULE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__VERSION = MODULE__VERSION;

	/**
	 * The feature id for the '<em><b>Rte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__RTE = MODULE__RTE;

	/**
	 * The feature id for the '<em><b>Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__SPEC = MODULE__SPEC;

	/**
	 * The feature id for the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__RAM = MODULE__RAM;

	/**
	 * The feature id for the '<em><b>Caps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__CAPS = MODULE__CAPS;

	/**
	 * The feature id for the '<em><b>Module Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__MODULE_TYPE = MODULE__MODULE_TYPE;

	/**
	 * The feature id for the '<em><b>Enviromental Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__ENVIROMENTAL_PROPERTIES = MODULE__ENVIROMENTAL_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Consists Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__CONSISTS_OF = MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ContractImpl <em>Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.ContractImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getContract()
	 * @generated
	 */
	int CONTRACT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT__MODULE = 1;

	/**
	 * The feature id for the '<em><b>View Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT__VIEW_POINT = 2;

	/**
	 * The feature id for the '<em><b>Assumption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT__ASSUMPTION = 3;

	/**
	 * The feature id for the '<em><b>Guarantee</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT__GUARANTEE = 4;

	/**
	 * The number of structural features of the '<em>Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl <em>Ports</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.PortsImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPorts()
	 * @generated
	 */
	int PORTS = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__PORTS = 2;

	/**
	 * The feature id for the '<em><b>Portse Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__PORTSE_OPPOSITE = 3;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__MODULE = 4;

	/**
	 * The feature id for the '<em><b>Inside Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__INSIDE_PORTS = 5;

	/**
	 * The feature id for the '<em><b>Inside Portse Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__INSIDE_PORTSE_OPPOSITE = 6;

	/**
	 * The feature id for the '<em><b>Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__SERVICE = 7;

	/**
	 * The feature id for the '<em><b>Outer Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__OUTER_DIRECTION = 8;

	/**
	 * The feature id for the '<em><b>Max Clients</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__MAX_CLIENTS = 9;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__FILTER = 10;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__LABEL = 11;

	/**
	 * The feature id for the '<em><b>Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__FUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Provider Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__PROVIDER_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS__IS_DERIVED = 14;

	/**
	 * The number of structural features of the '<em>Ports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Ports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ContractPropertyImpl <em>Contract Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.ContractPropertyImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getContractProperty()
	 * @generated
	 */
	int CONTRACT_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Property Tipe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY__PROPERTY_TIPE = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY__PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Contract Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Contract Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.GuaranteeImpl <em>Guarantee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.GuaranteeImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getGuarantee()
	 * @generated
	 */
	int GUARANTEE = 7;

	/**
	 * The feature id for the '<em><b>Property Tipe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARANTEE__PROPERTY_TIPE = CONTRACT_PROPERTY__PROPERTY_TIPE;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARANTEE__PROPERTY = CONTRACT_PROPERTY__PROPERTY;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARANTEE__CONTRACT = CONTRACT_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guarantee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARANTEE_FEATURE_COUNT = CONTRACT_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Guarantee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARANTEE_OPERATION_COUNT = CONTRACT_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.AssumptionImpl <em>Assumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.AssumptionImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getAssumption()
	 * @generated
	 */
	int ASSUMPTION = 8;

	/**
	 * The feature id for the '<em><b>Property Tipe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__PROPERTY_TIPE = CONTRACT_PROPERTY__PROPERTY_TIPE;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__PROPERTY = CONTRACT_PROPERTY__PROPERTY;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__CONTRACT = CONTRACT_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION_FEATURE_COUNT = CONTRACT_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION_OPERATION_COUNT = CONTRACT_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.SystemImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Consists Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONSISTS_OF = 1;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleTypeImpl <em>Module Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.ModuleTypeImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getModuleType()
	 * @generated
	 */
	int MODULE_TYPE = 10;

	/**
	 * The number of structural features of the '<em>Module Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Module Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ProxyImpl <em>Proxy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.ProxyImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProxy()
	 * @generated
	 */
	int PROXY = 11;

	/**
	 * The feature id for the '<em><b>Carrier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROXY__CARRIER = MODULE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Proxy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROXY_FEATURE_COUNT = MODULE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Proxy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROXY_OPERATION_COUNT = MODULE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.FilterImpl <em>Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.FilterImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getFilter()
	 * @generated
	 */
	int FILTER = 12;

	/**
	 * The feature id for the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__ADD = MODULE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__REMOVE = MODULE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__RESET = MODULE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__ALIAS = MODULE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FEATURE_COUNT = MODULE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_OPERATION_COUNT = MODULE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.MuxImpl <em>Mux</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MuxImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getMux()
	 * @generated
	 */
	int MUX = 13;

	/**
	 * The feature id for the '<em><b>Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUX__SERVICE = MODULE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mux</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUX_FEATURE_COUNT = MODULE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mux</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUX_OPERATION_COUNT = MODULE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ProtocolImpl <em>Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.ProtocolImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProtocol()
	 * @generated
	 */
	int PROTOCOL = 14;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__FROM = MODULE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__TO = MODULE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_FEATURE_COUNT = MODULE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_OPERATION_COUNT = MODULE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.FunctionImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 15;

	/**
	 * The feature id for the '<em><b>Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION = MODULE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = MODULE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = MODULE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.PropertyImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.PortType <em>Port Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.PortType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 17;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.ViewPoint <em>View Point</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.ViewPoint
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getViewPoint()
	 * @generated
	 */
	int VIEW_POINT = 18;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.PropertyType <em>Property Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.PropertyType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 19;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.ContractType <em>Contract Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.ContractType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getContractType()
	 * @generated
	 */
	int CONTRACT_TYPE = 20;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.DirectionType <em>Direction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.DirectionType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getDirectionType()
	 * @generated
	 */
	int DIRECTION_TYPE = 21;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.ProviderType <em>Provider Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.ProviderType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProviderType()
	 * @generated
	 */
	int PROVIDER_TYPE = 22;

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Module#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getName()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Name();

	/**
	 * Returns the meta object for the container reference '{@link de.tu_bs.ccc.contracting.Verification.Module#getIsPartOf <em>Is Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Is Part Of</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getIsPartOf()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_IsPartOf();

	/**
	 * Returns the meta object for the reference list '{@link de.tu_bs.ccc.contracting.Verification.Module#getRealizedBy <em>Realized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized By</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getRealizedBy()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_RealizedBy();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Module#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getDescription()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.Module#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getPorts()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Ports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.Module#getContract <em>Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contract</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getContract()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Contract();

	/**
	 * Returns the meta object for the reference '{@link de.tu_bs.ccc.contracting.Verification.Module#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Module</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getModule()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Module();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Module#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getVersion()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Version();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Module#getRte <em>Rte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rte</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getRte()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Rte();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Module#getSpec <em>Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spec</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getSpec()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Spec();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Module#getRam <em>Ram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ram</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getRam()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Ram();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Module#getCaps <em>Caps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caps</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getCaps()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Caps();

	/**
	 * Returns the meta object for the containment reference '{@link de.tu_bs.ccc.contracting.Verification.Module#getModuleType <em>Module Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getModuleType()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModuleType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.Module#getEnviromentalProperties <em>Enviromental Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enviromental Properties</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getEnviromentalProperties()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_EnviromentalProperties();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Abstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Abstract
	 * @generated
	 */
	EClass getAbstract();

	/**
	 * Returns the meta object for the reference list '{@link de.tu_bs.ccc.contracting.Verification.Abstract#getRealizes <em>Realizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realizes</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Abstract#getRealizes()
	 * @see #getAbstract()
	 * @generated
	 */
	EReference getAbstract_Realizes();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Component#isSingleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singleton</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Component#isSingleton()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Singleton();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Component#getBinary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binary</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Component#getBinary()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Binary();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Compound
	 * @generated
	 */
	EClass getCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.Compound#getConsistsOf <em>Consists Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Consists Of</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Compound#getConsistsOf()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_ConsistsOf();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Contract <em>Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contract</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Contract
	 * @generated
	 */
	EClass getContract();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Contract#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Contract#getName()
	 * @see #getContract()
	 * @generated
	 */
	EAttribute getContract_Name();

	/**
	 * Returns the meta object for the container reference '{@link de.tu_bs.ccc.contracting.Verification.Contract#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Module</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Contract#getModule()
	 * @see #getContract()
	 * @generated
	 */
	EReference getContract_Module();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Contract#getViewPoint <em>View Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Point</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Contract#getViewPoint()
	 * @see #getContract()
	 * @generated
	 */
	EAttribute getContract_ViewPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.Contract#getAssumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assumption</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Contract#getAssumption()
	 * @see #getContract()
	 * @generated
	 */
	EReference getContract_Assumption();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.Contract#getGuarantee <em>Guarantee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Guarantee</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Contract#getGuarantee()
	 * @see #getContract()
	 * @generated
	 */
	EReference getContract_Guarantee();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Ports <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ports</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports
	 * @generated
	 */
	EClass getPorts();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getName()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getType()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_Type();

	/**
	 * Returns the meta object for the reference list '{@link de.tu_bs.ccc.contracting.Verification.Ports#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ports</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getPorts()
	 * @see #getPorts()
	 * @generated
	 */
	EReference getPorts_Ports();

	/**
	 * Returns the meta object for the reference '{@link de.tu_bs.ccc.contracting.Verification.Ports#getPortseOpposite <em>Portse Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Portse Opposite</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getPortseOpposite()
	 * @see #getPorts()
	 * @generated
	 */
	EReference getPorts_PortseOpposite();

	/**
	 * Returns the meta object for the container reference '{@link de.tu_bs.ccc.contracting.Verification.Ports#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Module</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getModule()
	 * @see #getPorts()
	 * @generated
	 */
	EReference getPorts_Module();

	/**
	 * Returns the meta object for the reference list '{@link de.tu_bs.ccc.contracting.Verification.Ports#getInsidePorts <em>Inside Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inside Ports</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getInsidePorts()
	 * @see #getPorts()
	 * @generated
	 */
	EReference getPorts_InsidePorts();

	/**
	 * Returns the meta object for the reference '{@link de.tu_bs.ccc.contracting.Verification.Ports#getInsidePortseOpposite <em>Inside Portse Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Portse Opposite</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getInsidePortseOpposite()
	 * @see #getPorts()
	 * @generated
	 */
	EReference getPorts_InsidePortseOpposite();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getService()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_Service();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getOuterDirection <em>Outer Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outer Direction</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getOuterDirection()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_OuterDirection();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getMaxClients <em>Max Clients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Clients</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getMaxClients()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_MaxClients();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getFilter()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_Filter();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getLabel()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_Label();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getFunction()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_Function();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#getProviderType <em>Provider Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getProviderType()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_ProviderType();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Ports#isIsDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#isIsDerived()
	 * @see #getPorts()
	 * @generated
	 */
	EAttribute getPorts_IsDerived();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.ContractProperty <em>Contract Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contract Property</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.ContractProperty
	 * @generated
	 */
	EClass getContractProperty();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.ContractProperty#getPropertyTipe <em>Property Tipe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Tipe</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.ContractProperty#getPropertyTipe()
	 * @see #getContractProperty()
	 * @generated
	 */
	EAttribute getContractProperty_PropertyTipe();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.ContractProperty#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.ContractProperty#getProperty()
	 * @see #getContractProperty()
	 * @generated
	 */
	EAttribute getContractProperty_Property();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Guarantee <em>Guarantee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guarantee</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Guarantee
	 * @generated
	 */
	EClass getGuarantee();

	/**
	 * Returns the meta object for the container reference '{@link de.tu_bs.ccc.contracting.Verification.Guarantee#getContract <em>Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Contract</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Guarantee#getContract()
	 * @see #getGuarantee()
	 * @generated
	 */
	EReference getGuarantee_Contract();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assumption</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Assumption
	 * @generated
	 */
	EClass getAssumption();

	/**
	 * Returns the meta object for the container reference '{@link de.tu_bs.ccc.contracting.Verification.Assumption#getContract <em>Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Contract</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Assumption#getContract()
	 * @see #getAssumption()
	 * @generated
	 */
	EReference getAssumption_Contract();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.System#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.System#getName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.System#getConsistsOf <em>Consists Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Consists Of</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.System#getConsistsOf()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_ConsistsOf();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.ModuleType <em>Module Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.ModuleType
	 * @generated
	 */
	EClass getModuleType();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Proxy <em>Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proxy</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Proxy
	 * @generated
	 */
	EClass getProxy();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Proxy#getCarrier <em>Carrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Carrier</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Proxy#getCarrier()
	 * @see #getProxy()
	 * @generated
	 */
	EAttribute getProxy_Carrier();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Filter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Filter
	 * @generated
	 */
	EClass getFilter();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Filter#getAdd <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Filter#getAdd()
	 * @see #getFilter()
	 * @generated
	 */
	EAttribute getFilter_Add();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Filter#getRemove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Filter#getRemove()
	 * @see #getFilter()
	 * @generated
	 */
	EAttribute getFilter_Remove();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Filter#getReset <em>Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Filter#getReset()
	 * @see #getFilter()
	 * @generated
	 */
	EAttribute getFilter_Reset();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Filter#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Filter#getAlias()
	 * @see #getFilter()
	 * @generated
	 */
	EAttribute getFilter_Alias();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Mux <em>Mux</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mux</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Mux
	 * @generated
	 */
	EClass getMux();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Mux#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Mux#getService()
	 * @see #getMux()
	 * @generated
	 */
	EAttribute getMux_Service();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Protocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Protocol
	 * @generated
	 */
	EClass getProtocol();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Protocol#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Protocol#getFrom()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_From();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Protocol#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Protocol#getTo()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_To();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Function#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Function#getFunction()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Function();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.ccc.contracting.Verification.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Type();

	/**
	 * Returns the meta object for enum '{@link de.tu_bs.ccc.contracting.Verification.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.PortType
	 * @generated
	 */
	EEnum getPortType();

	/**
	 * Returns the meta object for enum '{@link de.tu_bs.ccc.contracting.Verification.ViewPoint <em>View Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>View Point</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.ViewPoint
	 * @generated
	 */
	EEnum getViewPoint();

	/**
	 * Returns the meta object for enum '{@link de.tu_bs.ccc.contracting.Verification.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.PropertyType
	 * @generated
	 */
	EEnum getPropertyType();

	/**
	 * Returns the meta object for enum '{@link de.tu_bs.ccc.contracting.Verification.ContractType <em>Contract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Contract Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.ContractType
	 * @generated
	 */
	EEnum getContractType();

	/**
	 * Returns the meta object for enum '{@link de.tu_bs.ccc.contracting.Verification.DirectionType <em>Direction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.DirectionType
	 * @generated
	 */
	EEnum getDirectionType();

	/**
	 * Returns the meta object for enum '{@link de.tu_bs.ccc.contracting.Verification.ProviderType <em>Provider Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Provider Type</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.ProviderType
	 * @generated
	 */
	EEnum getProviderType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MmFactory getMmFactory();

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
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

		/**
		 * The meta object literal for the '<em><b>Is Part Of</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__IS_PART_OF = eINSTANCE.getModule_IsPartOf();

		/**
		 * The meta object literal for the '<em><b>Realized By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__REALIZED_BY = eINSTANCE.getModule_RealizedBy();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__DESCRIPTION = eINSTANCE.getModule_Description();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__PORTS = eINSTANCE.getModule_Ports();

		/**
		 * The meta object literal for the '<em><b>Contract</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__CONTRACT = eINSTANCE.getModule_Contract();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE = eINSTANCE.getModule_Module();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__VERSION = eINSTANCE.getModule_Version();

		/**
		 * The meta object literal for the '<em><b>Rte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__RTE = eINSTANCE.getModule_Rte();

		/**
		 * The meta object literal for the '<em><b>Spec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__SPEC = eINSTANCE.getModule_Spec();

		/**
		 * The meta object literal for the '<em><b>Ram</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__RAM = eINSTANCE.getModule_Ram();

		/**
		 * The meta object literal for the '<em><b>Caps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__CAPS = eINSTANCE.getModule_Caps();

		/**
		 * The meta object literal for the '<em><b>Module Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE_TYPE = eINSTANCE.getModule_ModuleType();

		/**
		 * The meta object literal for the '<em><b>Enviromental Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__ENVIROMENTAL_PROPERTIES = eINSTANCE.getModule_EnviromentalProperties();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.AbstractImpl <em>Abstract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.AbstractImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getAbstract()
		 * @generated
		 */
		EClass ABSTRACT = eINSTANCE.getAbstract();

		/**
		 * The meta object literal for the '<em><b>Realizes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT__REALIZES = eINSTANCE.getAbstract_Realizes();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.ComponentImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__SINGLETON = eINSTANCE.getComponent_Singleton();

		/**
		 * The meta object literal for the '<em><b>Binary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__BINARY = eINSTANCE.getComponent_Binary();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.CompoundImpl <em>Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.CompoundImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getCompound()
		 * @generated
		 */
		EClass COMPOUND = eINSTANCE.getCompound();

		/**
		 * The meta object literal for the '<em><b>Consists Of</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__CONSISTS_OF = eINSTANCE.getCompound_ConsistsOf();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ContractImpl <em>Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.ContractImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getContract()
		 * @generated
		 */
		EClass CONTRACT = eINSTANCE.getContract();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT__NAME = eINSTANCE.getContract_Name();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT__MODULE = eINSTANCE.getContract_Module();

		/**
		 * The meta object literal for the '<em><b>View Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT__VIEW_POINT = eINSTANCE.getContract_ViewPoint();

		/**
		 * The meta object literal for the '<em><b>Assumption</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT__ASSUMPTION = eINSTANCE.getContract_Assumption();

		/**
		 * The meta object literal for the '<em><b>Guarantee</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT__GUARANTEE = eINSTANCE.getContract_Guarantee();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl <em>Ports</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.PortsImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPorts()
		 * @generated
		 */
		EClass PORTS = eINSTANCE.getPorts();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__NAME = eINSTANCE.getPorts_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__TYPE = eINSTANCE.getPorts_Type();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORTS__PORTS = eINSTANCE.getPorts_Ports();

		/**
		 * The meta object literal for the '<em><b>Portse Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORTS__PORTSE_OPPOSITE = eINSTANCE.getPorts_PortseOpposite();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORTS__MODULE = eINSTANCE.getPorts_Module();

		/**
		 * The meta object literal for the '<em><b>Inside Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORTS__INSIDE_PORTS = eINSTANCE.getPorts_InsidePorts();

		/**
		 * The meta object literal for the '<em><b>Inside Portse Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORTS__INSIDE_PORTSE_OPPOSITE = eINSTANCE.getPorts_InsidePortseOpposite();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__SERVICE = eINSTANCE.getPorts_Service();

		/**
		 * The meta object literal for the '<em><b>Outer Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__OUTER_DIRECTION = eINSTANCE.getPorts_OuterDirection();

		/**
		 * The meta object literal for the '<em><b>Max Clients</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__MAX_CLIENTS = eINSTANCE.getPorts_MaxClients();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__FILTER = eINSTANCE.getPorts_Filter();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__LABEL = eINSTANCE.getPorts_Label();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__FUNCTION = eINSTANCE.getPorts_Function();

		/**
		 * The meta object literal for the '<em><b>Provider Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__PROVIDER_TYPE = eINSTANCE.getPorts_ProviderType();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTS__IS_DERIVED = eINSTANCE.getPorts_IsDerived();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ContractPropertyImpl <em>Contract Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.ContractPropertyImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getContractProperty()
		 * @generated
		 */
		EClass CONTRACT_PROPERTY = eINSTANCE.getContractProperty();

		/**
		 * The meta object literal for the '<em><b>Property Tipe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT_PROPERTY__PROPERTY_TIPE = eINSTANCE.getContractProperty_PropertyTipe();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT_PROPERTY__PROPERTY = eINSTANCE.getContractProperty_Property();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.GuaranteeImpl <em>Guarantee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.GuaranteeImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getGuarantee()
		 * @generated
		 */
		EClass GUARANTEE = eINSTANCE.getGuarantee();

		/**
		 * The meta object literal for the '<em><b>Contract</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARANTEE__CONTRACT = eINSTANCE.getGuarantee_Contract();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.AssumptionImpl <em>Assumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.AssumptionImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getAssumption()
		 * @generated
		 */
		EClass ASSUMPTION = eINSTANCE.getAssumption();

		/**
		 * The meta object literal for the '<em><b>Contract</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSUMPTION__CONTRACT = eINSTANCE.getAssumption_Contract();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.SystemImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__NAME = eINSTANCE.getSystem_Name();

		/**
		 * The meta object literal for the '<em><b>Consists Of</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__CONSISTS_OF = eINSTANCE.getSystem_ConsistsOf();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleTypeImpl <em>Module Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.ModuleTypeImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getModuleType()
		 * @generated
		 */
		EClass MODULE_TYPE = eINSTANCE.getModuleType();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ProxyImpl <em>Proxy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.ProxyImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProxy()
		 * @generated
		 */
		EClass PROXY = eINSTANCE.getProxy();

		/**
		 * The meta object literal for the '<em><b>Carrier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROXY__CARRIER = eINSTANCE.getProxy_Carrier();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.FilterImpl <em>Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.FilterImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getFilter()
		 * @generated
		 */
		EClass FILTER = eINSTANCE.getFilter();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER__ADD = eINSTANCE.getFilter_Add();

		/**
		 * The meta object literal for the '<em><b>Remove</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER__REMOVE = eINSTANCE.getFilter_Remove();

		/**
		 * The meta object literal for the '<em><b>Reset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER__RESET = eINSTANCE.getFilter_Reset();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER__ALIAS = eINSTANCE.getFilter_Alias();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.MuxImpl <em>Mux</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MuxImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getMux()
		 * @generated
		 */
		EClass MUX = eINSTANCE.getMux();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUX__SERVICE = eINSTANCE.getMux_Service();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.ProtocolImpl <em>Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.ProtocolImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProtocol()
		 * @generated
		 */
		EClass PROTOCOL = eINSTANCE.getProtocol();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__FROM = eINSTANCE.getProtocol_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__TO = eINSTANCE.getProtocol_To();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.FunctionImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__FUNCTION = eINSTANCE.getFunction_Function();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.PropertyImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.PortType <em>Port Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.PortType
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPortType()
		 * @generated
		 */
		EEnum PORT_TYPE = eINSTANCE.getPortType();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.ViewPoint <em>View Point</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.ViewPoint
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getViewPoint()
		 * @generated
		 */
		EEnum VIEW_POINT = eINSTANCE.getViewPoint();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.PropertyType <em>Property Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.PropertyType
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPropertyType()
		 * @generated
		 */
		EEnum PROPERTY_TYPE = eINSTANCE.getPropertyType();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.ContractType <em>Contract Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.ContractType
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getContractType()
		 * @generated
		 */
		EEnum CONTRACT_TYPE = eINSTANCE.getContractType();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.DirectionType <em>Direction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.DirectionType
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getDirectionType()
		 * @generated
		 */
		EEnum DIRECTION_TYPE = eINSTANCE.getDirectionType();

		/**
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.ProviderType <em>Provider Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.ProviderType
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getProviderType()
		 * @generated
		 */
		EEnum PROVIDER_TYPE = eINSTANCE.getProviderType();

	}

} //MmPackage
