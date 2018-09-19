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
	 * The feature id for the '<em><b>Getsrealized</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__GETSREALIZED = 2;

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
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.impl.InterfaceImpl
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Is Part Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__IS_PART_OF = MODULE__IS_PART_OF;

	/**
	 * The feature id for the '<em><b>Getsrealized</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__GETSREALIZED = MODULE__GETSREALIZED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DESCRIPTION = MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PORTS = MODULE__PORTS;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CONTRACT = MODULE__CONTRACT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__MODULE = MODULE__MODULE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__VERSION = MODULE__VERSION;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REALIZES = MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Getsrealized</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__GETSREALIZED = MODULE__GETSREALIZED;

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
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = MODULE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Getsrealized</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__GETSREALIZED = MODULE__GETSREALIZED;

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
	 * The feature id for the '<em><b>Consits Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__CONSITS_OF = MODULE_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Ports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTS_FEATURE_COUNT = 9;

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
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.PortType <em>Port Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.PortType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 9;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.ViewPoint <em>View Point</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.ViewPoint
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getViewPoint()
	 * @generated
	 */
	int VIEW_POINT = 10;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.PropertyType <em>Property Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.PropertyType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 11;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.ContractType <em>Contract Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.ContractType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getContractType()
	 * @generated
	 */
	int CONTRACT_TYPE = 12;

	/**
	 * The meta object id for the '{@link de.tu_bs.ccc.contracting.Verification.DirectionType <em>Direction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.ccc.contracting.Verification.DirectionType
	 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getDirectionType()
	 * @generated
	 */
	int DIRECTION_TYPE = 13;

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
	 * Returns the meta object for the reference list '{@link de.tu_bs.ccc.contracting.Verification.Module#getGetsrealized <em>Getsrealized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Getsrealized</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getGetsrealized()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Getsrealized();

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
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the reference list '{@link de.tu_bs.ccc.contracting.Verification.Interface#getRealizes <em>Realizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realizes</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Interface#getRealizes()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Realizes();

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
	 * Returns the meta object for class '{@link de.tu_bs.ccc.contracting.Verification.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Compound
	 * @generated
	 */
	EClass getCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.ccc.contracting.Verification.Compound#getConsitsOf <em>Consits Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Consits Of</em>'.
	 * @see de.tu_bs.ccc.contracting.Verification.Compound#getConsitsOf()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_ConsitsOf();

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
		 * The meta object literal for the '<em><b>Getsrealized</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__GETSREALIZED = eINSTANCE.getModule_Getsrealized();

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
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.InterfaceImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Realizes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REALIZES = eINSTANCE.getInterface_Realizes();

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
		 * The meta object literal for the '{@link de.tu_bs.ccc.contracting.Verification.impl.CompoundImpl <em>Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.ccc.contracting.Verification.impl.CompoundImpl
		 * @see de.tu_bs.ccc.contracting.Verification.impl.MmPackageImpl#getCompound()
		 * @generated
		 */
		EClass COMPOUND = eINSTANCE.getCompound();

		/**
		 * The meta object literal for the '<em><b>Consits Of</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__CONSITS_OF = eINSTANCE.getCompound_ConsitsOf();

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

	}

} //MmPackage
