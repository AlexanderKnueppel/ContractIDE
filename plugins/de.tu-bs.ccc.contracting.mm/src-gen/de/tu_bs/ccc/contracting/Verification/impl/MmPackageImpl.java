/**
 */
package de.tu_bs.ccc.contracting.Verification.impl;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.ContractProperty;
import de.tu_bs.ccc.contracting.Verification.ContractType;
import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Filter;
import de.tu_bs.ccc.contracting.Verification.Function;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import de.tu_bs.ccc.contracting.Verification.ModuleType;
import de.tu_bs.ccc.contracting.Verification.Mux;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.PropertyType;
import de.tu_bs.ccc.contracting.Verification.Protocol;
import de.tu_bs.ccc.contracting.Verification.ProviderType;
import de.tu_bs.ccc.contracting.Verification.Proxy;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MmPackageImpl extends EPackageImpl implements MmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guaranteeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass muxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protocolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum viewPointEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contractTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum providerTypeEEnum = null;

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
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MmPackageImpl() {
		super(eNS_URI, MmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MmPackage init() {
		if (isInited)
			return (MmPackage) EPackage.Registry.INSTANCE.getEPackage(MmPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMmPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MmPackageImpl theMmPackage = registeredMmPackage instanceof MmPackageImpl ? (MmPackageImpl) registeredMmPackage
				: new MmPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMmPackage.createPackageContents();

		// Initialize created meta-data
		theMmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMmPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MmPackage.eNS_URI, theMmPackage);
		return theMmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModule_Name() {
		return (EAttribute) moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_IsPartOf() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_RealizedBy() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModule_Description() {
		return (EAttribute) moduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_Ports() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_Contract() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_Module() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModule_Version() {
		return (EAttribute) moduleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModule_Rte() {
		return (EAttribute) moduleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModule_Spec() {
		return (EAttribute) moduleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModule_Ram() {
		return (EAttribute) moduleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModule_Caps() {
		return (EAttribute) moduleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_ModuleType() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstract() {
		return abstractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstract_Realizes() {
		return (EReference) abstractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComponent_Singleton() {
		return (EAttribute) componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComponent_Binary() {
		return (EAttribute) componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompound() {
		return compoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompound_ConsistsOf() {
		return (EReference) compoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContract() {
		return contractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContract_Name() {
		return (EAttribute) contractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContract_Module() {
		return (EReference) contractEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContract_ViewPoint() {
		return (EAttribute) contractEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContract_Assumption() {
		return (EReference) contractEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContract_Guarantee() {
		return (EReference) contractEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPorts() {
		return portsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_Name() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_Type() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPorts_Ports() {
		return (EReference) portsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPorts_PortseOpposite() {
		return (EReference) portsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPorts_Module() {
		return (EReference) portsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPorts_InsidePorts() {
		return (EReference) portsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPorts_InsidePortseOpposite() {
		return (EReference) portsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_Service() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_OuterDirection() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_MaxClients() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_Filter() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_Label() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_Function() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPorts_ProviderType() {
		return (EAttribute) portsEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContractProperty() {
		return contractPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContractProperty_PropertyTipe() {
		return (EAttribute) contractPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContractProperty_Property() {
		return (EAttribute) contractPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGuarantee() {
		return guaranteeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGuarantee_Contract() {
		return (EReference) guaranteeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssumption() {
		return assumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssumption_Contract() {
		return (EReference) assumptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSystem_Name() {
		return (EAttribute) systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSystem_ConsistsOf() {
		return (EReference) systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModuleType() {
		return moduleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProxy() {
		return proxyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProxy_Carrier() {
		return (EAttribute) proxyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFilter() {
		return filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFilter_Add() {
		return (EAttribute) filterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFilter_Remove() {
		return (EAttribute) filterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFilter_Reset() {
		return (EAttribute) filterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFilter_Alias() {
		return (EAttribute) filterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMux() {
		return muxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMux_Service() {
		return (EAttribute) muxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProtocol() {
		return protocolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProtocol_From() {
		return (EAttribute) protocolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProtocol_To() {
		return (EAttribute) protocolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunction_Function() {
		return (EAttribute) functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPortType() {
		return portTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getViewPoint() {
		return viewPointEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPropertyType() {
		return propertyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getContractType() {
		return contractTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDirectionType() {
		return directionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getProviderType() {
		return providerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MmFactory getMmFactory() {
		return (MmFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		moduleEClass = createEClass(MODULE);
		createEAttribute(moduleEClass, MODULE__NAME);
		createEReference(moduleEClass, MODULE__IS_PART_OF);
		createEReference(moduleEClass, MODULE__REALIZED_BY);
		createEAttribute(moduleEClass, MODULE__DESCRIPTION);
		createEReference(moduleEClass, MODULE__PORTS);
		createEReference(moduleEClass, MODULE__CONTRACT);
		createEReference(moduleEClass, MODULE__MODULE);
		createEAttribute(moduleEClass, MODULE__VERSION);
		createEAttribute(moduleEClass, MODULE__RTE);
		createEAttribute(moduleEClass, MODULE__SPEC);
		createEAttribute(moduleEClass, MODULE__RAM);
		createEAttribute(moduleEClass, MODULE__CAPS);
		createEReference(moduleEClass, MODULE__MODULE_TYPE);

		abstractEClass = createEClass(ABSTRACT);
		createEReference(abstractEClass, ABSTRACT__REALIZES);

		componentEClass = createEClass(COMPONENT);
		createEAttribute(componentEClass, COMPONENT__SINGLETON);
		createEAttribute(componentEClass, COMPONENT__BINARY);

		compoundEClass = createEClass(COMPOUND);
		createEReference(compoundEClass, COMPOUND__CONSISTS_OF);

		contractEClass = createEClass(CONTRACT);
		createEAttribute(contractEClass, CONTRACT__NAME);
		createEReference(contractEClass, CONTRACT__MODULE);
		createEAttribute(contractEClass, CONTRACT__VIEW_POINT);
		createEReference(contractEClass, CONTRACT__ASSUMPTION);
		createEReference(contractEClass, CONTRACT__GUARANTEE);

		portsEClass = createEClass(PORTS);
		createEAttribute(portsEClass, PORTS__NAME);
		createEAttribute(portsEClass, PORTS__TYPE);
		createEReference(portsEClass, PORTS__PORTS);
		createEReference(portsEClass, PORTS__PORTSE_OPPOSITE);
		createEReference(portsEClass, PORTS__MODULE);
		createEReference(portsEClass, PORTS__INSIDE_PORTS);
		createEReference(portsEClass, PORTS__INSIDE_PORTSE_OPPOSITE);
		createEAttribute(portsEClass, PORTS__SERVICE);
		createEAttribute(portsEClass, PORTS__OUTER_DIRECTION);
		createEAttribute(portsEClass, PORTS__MAX_CLIENTS);
		createEAttribute(portsEClass, PORTS__FILTER);
		createEAttribute(portsEClass, PORTS__LABEL);
		createEAttribute(portsEClass, PORTS__FUNCTION);
		createEAttribute(portsEClass, PORTS__PROVIDER_TYPE);

		contractPropertyEClass = createEClass(CONTRACT_PROPERTY);
		createEAttribute(contractPropertyEClass, CONTRACT_PROPERTY__PROPERTY_TIPE);
		createEAttribute(contractPropertyEClass, CONTRACT_PROPERTY__PROPERTY);

		guaranteeEClass = createEClass(GUARANTEE);
		createEReference(guaranteeEClass, GUARANTEE__CONTRACT);

		assumptionEClass = createEClass(ASSUMPTION);
		createEReference(assumptionEClass, ASSUMPTION__CONTRACT);

		systemEClass = createEClass(SYSTEM);
		createEAttribute(systemEClass, SYSTEM__NAME);
		createEReference(systemEClass, SYSTEM__CONSISTS_OF);

		moduleTypeEClass = createEClass(MODULE_TYPE);

		proxyEClass = createEClass(PROXY);
		createEAttribute(proxyEClass, PROXY__CARRIER);

		filterEClass = createEClass(FILTER);
		createEAttribute(filterEClass, FILTER__ADD);
		createEAttribute(filterEClass, FILTER__REMOVE);
		createEAttribute(filterEClass, FILTER__RESET);
		createEAttribute(filterEClass, FILTER__ALIAS);

		muxEClass = createEClass(MUX);
		createEAttribute(muxEClass, MUX__SERVICE);

		protocolEClass = createEClass(PROTOCOL);
		createEAttribute(protocolEClass, PROTOCOL__FROM);
		createEAttribute(protocolEClass, PROTOCOL__TO);

		functionEClass = createEClass(FUNCTION);
		createEAttribute(functionEClass, FUNCTION__FUNCTION);

		// Create enums
		portTypeEEnum = createEEnum(PORT_TYPE);
		viewPointEEnum = createEEnum(VIEW_POINT);
		propertyTypeEEnum = createEEnum(PROPERTY_TYPE);
		contractTypeEEnum = createEEnum(CONTRACT_TYPE);
		directionTypeEEnum = createEEnum(DIRECTION_TYPE);
		providerTypeEEnum = createEEnum(PROVIDER_TYPE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractEClass.getESuperTypes().add(this.getModule());
		componentEClass.getESuperTypes().add(this.getModule());
		compoundEClass.getESuperTypes().add(this.getModule());
		guaranteeEClass.getESuperTypes().add(this.getContractProperty());
		assumptionEClass.getESuperTypes().add(this.getContractProperty());
		proxyEClass.getESuperTypes().add(this.getModuleType());
		filterEClass.getESuperTypes().add(this.getModuleType());
		muxEClass.getESuperTypes().add(this.getModuleType());
		protocolEClass.getESuperTypes().add(this.getModuleType());
		functionEClass.getESuperTypes().add(this.getModuleType());

		// Initialize classes, features, and operations; add parameters
		initEClass(moduleEClass, de.tu_bs.ccc.contracting.Verification.Module.class, "Module", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", "\"\"", 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_IsPartOf(), this.getCompound(), this.getCompound_ConsistsOf(), "isPartOf", null, 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_RealizedBy(), this.getAbstract(), this.getAbstract_Realizes(), "realizedBy", null, 0,
				-1, de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Description(), ecorePackage.getEString(), "description", "\"\"", 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Ports(), this.getPorts(), this.getPorts_Module(), "ports", null, 0, -1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Contract(), this.getContract(), this.getContract_Module(), "contract", null, 0, -1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Module(), this.getModule(), null, "module", null, 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Version(), ecorePackage.getEString(), "version", "1.0", 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Rte(), ecorePackage.getEString(), "rte", "\"\"", 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Spec(), ecorePackage.getEString(), "spec", "\"\"", 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Ram(), ecorePackage.getEBigInteger(), "ram", "-1", 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Caps(), ecorePackage.getEBigInteger(), "caps", "-1", 0, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_ModuleType(), this.getModuleType(), null, "moduleType", null, 1, 1,
				de.tu_bs.ccc.contracting.Verification.Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractEClass, Abstract.class, "Abstract", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstract_Realizes(), this.getModule(), this.getModule_RealizedBy(), "realizes", null, 0, -1,
				Abstract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponent_Singleton(), ecorePackage.getEBoolean(), "singleton", "false", 0, 1,
				Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Binary(), ecorePackage.getEString(), "binary", "\"\"", 0, 1, Component.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundEClass, Compound.class, "Compound", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompound_ConsistsOf(), this.getModule(), this.getModule_IsPartOf(), "consistsOf", null, 0, -1,
				Compound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contractEClass, Contract.class, "Contract", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContract_Name(), ecorePackage.getEString(), "name", "\"\"", 0, 1, Contract.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContract_Module(), this.getModule(), this.getModule_Contract(), "module", null, 1, 1,
				Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContract_ViewPoint(), this.getViewPoint(), "ViewPoint", "FUNCTIONAL", 0, 1, Contract.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContract_Assumption(), this.getAssumption(), this.getAssumption_Contract(), "assumption",
				null, 0, -1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContract_Guarantee(), this.getGuarantee(), this.getGuarantee_Contract(), "guarantee", null, 0,
				-1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portsEClass, Ports.class, "Ports", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPorts_Name(), theXMLTypePackage.getString(), "name", "\"\"", 0, 1, Ports.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPorts_Type(), this.getPortType(), "type", "INT", 0, 1, Ports.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPorts_Ports(), this.getPorts(), this.getPorts_PortseOpposite(), "ports", null, 0, -1,
				Ports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPorts_PortseOpposite(), this.getPorts(), this.getPorts_Ports(), "portseOpposite", null, 0, 1,
				Ports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPorts_Module(), this.getModule(), this.getModule_Ports(), "module", null, 1, 1, Ports.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPorts_InsidePorts(), this.getPorts(), this.getPorts_InsidePortseOpposite(), "insidePorts",
				null, 0, -1, Ports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPorts_InsidePortseOpposite(), this.getPorts(), this.getPorts_InsidePorts(),
				"insidePortseOpposite", null, 0, 1, Ports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPorts_Service(), theXMLTypePackage.getString(), "service", "\"\"", 0, 1, Ports.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPorts_OuterDirection(), this.getDirectionType(), "OuterDirection", "INTERNAL", 0, 1,
				Ports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getPorts_MaxClients(), ecorePackage.getEInt(), "maxClients", "-1", 0, 1, Ports.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPorts_Filter(), ecorePackage.getEString(), "filter", "\"\"", 0, 1, Ports.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPorts_Label(), ecorePackage.getEString(), "label", "\"\"", 0, 1, Ports.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPorts_Function(), ecorePackage.getEString(), "function", "\"\"", 0, 1, Ports.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPorts_ProviderType(), this.getProviderType(), "providerType", "NATIVE", 0, 1, Ports.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contractPropertyEClass, ContractProperty.class, "ContractProperty", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContractProperty_PropertyTipe(), this.getPropertyType(), "propertyTipe", "EQUATION", 0, 1,
				ContractProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getContractProperty_Property(), theXMLTypePackage.getString(), "property", "\"\"", 1, 1,
				ContractProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(guaranteeEClass, Guarantee.class, "Guarantee", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuarantee_Contract(), this.getContract(), this.getContract_Guarantee(), "contract", null, 1,
				1, Guarantee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assumptionEClass, Assumption.class, "Assumption", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssumption_Contract(), this.getContract(), this.getContract_Assumption(), "contract", null, 1,
				1, Assumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemEClass, de.tu_bs.ccc.contracting.Verification.System.class, "System", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystem_Name(), ecorePackage.getEString(), "name", "\"\"", 0, 1,
				de.tu_bs.ccc.contracting.Verification.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_ConsistsOf(), this.getModule(), null, "consistsOf", null, 0, -1,
				de.tu_bs.ccc.contracting.Verification.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleTypeEClass, ModuleType.class, "ModuleType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyEClass, Proxy.class, "Proxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProxy_Carrier(), ecorePackage.getEString(), "carrier", "\"\"", 0, 1, Proxy.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterEClass, Filter.class, "Filter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilter_Add(), ecorePackage.getEString(), "add", "\"\"", 0, 1, Filter.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilter_Remove(), ecorePackage.getEString(), "remove", "\"\"", 0, 1, Filter.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilter_Reset(), ecorePackage.getEString(), "reset", "\"\"", 0, 1, Filter.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilter_Alias(), ecorePackage.getEString(), "alias", "\"\"", 0, 1, Filter.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(muxEClass, Mux.class, "Mux", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMux_Service(), ecorePackage.getEString(), "service", "\"\"", 0, 1, Mux.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protocolEClass, Protocol.class, "Protocol", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProtocol_From(), ecorePackage.getEString(), "from", "\"\"", 0, 1, Protocol.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtocol_To(), ecorePackage.getEString(), "to", "\"\"", 0, 1, Protocol.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunction_Function(), ecorePackage.getEString(), "function", "\"\"", 0, 1, Function.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(portTypeEEnum, PortType.class, "PortType");
		addEEnumLiteral(portTypeEEnum, PortType.INT);
		addEEnumLiteral(portTypeEEnum, PortType.STRING);
		addEEnumLiteral(portTypeEEnum, PortType.BOOLEAN);
		addEEnumLiteral(portTypeEEnum, PortType.REAL);
		addEEnumLiteral(portTypeEEnum, PortType.SERVICE);

		initEEnum(viewPointEEnum, ViewPoint.class, "ViewPoint");
		addEEnumLiteral(viewPointEEnum, ViewPoint.FUNCTIONAL);
		addEEnumLiteral(viewPointEEnum, ViewPoint.TIMING);
		addEEnumLiteral(viewPointEEnum, ViewPoint.MEMORY);

		initEEnum(propertyTypeEEnum, PropertyType.class, "PropertyType");
		addEEnumLiteral(propertyTypeEEnum, PropertyType.EQUATION);
		addEEnumLiteral(propertyTypeEEnum, PropertyType.MINDELAY);
		addEEnumLiteral(propertyTypeEEnum, PropertyType.MAXDELAY);
		addEEnumLiteral(propertyTypeEEnum, PropertyType.FREQUENCY);
		addEEnumLiteral(propertyTypeEEnum, PropertyType.JITTER);
		addEEnumLiteral(propertyTypeEEnum, PropertyType.MINDURATION);
		addEEnumLiteral(propertyTypeEEnum, PropertyType.MAXDURATION);
		addEEnumLiteral(propertyTypeEEnum, PropertyType.MEMORY);

		initEEnum(contractTypeEEnum, ContractType.class, "ContractType");
		addEEnumLiteral(contractTypeEEnum, ContractType.ASSUMPTION);
		addEEnumLiteral(contractTypeEEnum, ContractType.GUARANTEE);

		initEEnum(directionTypeEEnum, DirectionType.class, "DirectionType");
		addEEnumLiteral(directionTypeEEnum, DirectionType.INTERNAL);
		addEEnumLiteral(directionTypeEEnum, DirectionType.EXTERNAL);

		initEEnum(providerTypeEEnum, ProviderType.class, "ProviderType");
		addEEnumLiteral(providerTypeEEnum, ProviderType.NATIVE);
		addEEnumLiteral(providerTypeEEnum, ProviderType.LEGACY);
		addEEnumLiteral(providerTypeEEnum, ProviderType.NETWORK);

		// Create resource
		createResource(eNS_URI);
	}

} //MmPackageImpl
