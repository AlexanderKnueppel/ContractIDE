/**
 */
package de.tu_bs.ccc.contracting.Verification.impl;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import de.tu_bs.ccc.contracting.Verification.ModuleType;
import de.tu_bs.ccc.contracting.Verification.Ports;

import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getIsPartOf <em>Is Part Of</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getRealizedBy <em>Realized By</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getContract <em>Contract</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getModule <em>Module</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getRte <em>Rte</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getSpec <em>Spec</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getRam <em>Ram</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getCaps <em>Caps</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getModuleType <em>Module Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleImpl extends MinimalEObjectImpl.Container implements de.tu_bs.ccc.contracting.Verification.Module {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRealizedBy() <em>Realized By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Abstract> realizedBy;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Ports> ports;

	/**
	 * The cached value of the '{@link #getContract() <em>Contract</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContract()
	 * @generated
	 * @ordered
	 */
	protected EList<Contract> contract;

	/**
	 * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModule()
	 * @generated
	 * @ordered
	 */
	protected de.tu_bs.ccc.contracting.Verification.Module module;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1.0";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRte() <em>Rte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRte()
	 * @generated
	 * @ordered
	 */
	protected static final String RTE_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getRte() <em>Rte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRte()
	 * @generated
	 * @ordered
	 */
	protected String rte = RTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpec() <em>Spec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpec()
	 * @generated
	 * @ordered
	 */
	protected static final String SPEC_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getSpec() <em>Spec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpec()
	 * @generated
	 * @ordered
	 */
	protected String spec = SPEC_EDEFAULT;

	/**
	 * The default value of the '{@link #getRam() <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRam()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger RAM_EDEFAULT = new BigInteger("-1");

	/**
	 * The cached value of the '{@link #getRam() <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRam()
	 * @generated
	 * @ordered
	 */
	protected BigInteger ram = RAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getCaps() <em>Caps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaps()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger CAPS_EDEFAULT = new BigInteger("-1");

	/**
	 * The cached value of the '{@link #getCaps() <em>Caps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaps()
	 * @generated
	 * @ordered
	 */
	protected BigInteger caps = CAPS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModuleType() <em>Module Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleType()
	 * @generated
	 * @ordered
	 */
	protected ModuleType moduleType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MmPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Compound getIsPartOf() {
		if (eContainerFeatureID() != MmPackage.MODULE__IS_PART_OF)
			return null;
		return (Compound) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsPartOf(Compound newIsPartOf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newIsPartOf, MmPackage.MODULE__IS_PART_OF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPartOf(Compound newIsPartOf) {
		if (newIsPartOf != eInternalContainer()
				|| (eContainerFeatureID() != MmPackage.MODULE__IS_PART_OF && newIsPartOf != null)) {
			if (EcoreUtil.isAncestor(this, newIsPartOf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIsPartOf != null)
				msgs = ((InternalEObject) newIsPartOf).eInverseAdd(this, MmPackage.COMPOUND__CONSISTS_OF,
						Compound.class, msgs);
			msgs = basicSetIsPartOf(newIsPartOf, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__IS_PART_OF, newIsPartOf,
					newIsPartOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Abstract> getRealizedBy() {
		if (realizedBy == null) {
			realizedBy = new EObjectWithInverseResolvingEList.ManyInverse<Abstract>(Abstract.class, this,
					MmPackage.MODULE__REALIZED_BY, MmPackage.ABSTRACT__REALIZES);
		}
		return realizedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__DESCRIPTION, oldDescription,
					description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Ports> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<Ports>(Ports.class, this, MmPackage.MODULE__PORTS,
					MmPackage.PORTS__MODULE);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Contract> getContract() {
		if (contract == null) {
			contract = new EObjectContainmentWithInverseEList<Contract>(Contract.class, this,
					MmPackage.MODULE__CONTRACT, MmPackage.CONTRACT__MODULE);
		}
		return contract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public de.tu_bs.ccc.contracting.Verification.Module getModule() {
		if (module != null && module.eIsProxy()) {
			InternalEObject oldModule = (InternalEObject) module;
			module = (de.tu_bs.ccc.contracting.Verification.Module) eResolveProxy(oldModule);
			if (module != oldModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MmPackage.MODULE__MODULE, oldModule,
							module));
			}
		}
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.tu_bs.ccc.contracting.Verification.Module basicGetModule() {
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModule(de.tu_bs.ccc.contracting.Verification.Module newModule) {
		de.tu_bs.ccc.contracting.Verification.Module oldModule = module;
		module = newModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__MODULE, oldModule, module));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRte() {
		return rte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRte(String newRte) {
		String oldRte = rte;
		rte = newRte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__RTE, oldRte, rte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpec() {
		return spec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpec(String newSpec) {
		String oldSpec = spec;
		spec = newSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__SPEC, oldSpec, spec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigInteger getRam() {
		return ram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRam(BigInteger newRam) {
		BigInteger oldRam = ram;
		ram = newRam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__RAM, oldRam, ram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigInteger getCaps() {
		return caps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCaps(BigInteger newCaps) {
		BigInteger oldCaps = caps;
		caps = newCaps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__CAPS, oldCaps, caps));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModuleType getModuleType() {
		return moduleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModuleType(ModuleType newModuleType, NotificationChain msgs) {
		ModuleType oldModuleType = moduleType;
		moduleType = newModuleType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MmPackage.MODULE__MODULE_TYPE, oldModuleType, newModuleType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModuleType(ModuleType newModuleType) {
		if (newModuleType != moduleType) {
			NotificationChain msgs = null;
			if (moduleType != null)
				msgs = ((InternalEObject) moduleType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MmPackage.MODULE__MODULE_TYPE, null, msgs);
			if (newModuleType != null)
				msgs = ((InternalEObject) newModuleType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MmPackage.MODULE__MODULE_TYPE, null, msgs);
			msgs = basicSetModuleType(newModuleType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__MODULE_TYPE, newModuleType,
					newModuleType));
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
		case MmPackage.MODULE__IS_PART_OF:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetIsPartOf((Compound) otherEnd, msgs);
		case MmPackage.MODULE__REALIZED_BY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRealizedBy()).basicAdd(otherEnd, msgs);
		case MmPackage.MODULE__PORTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPorts()).basicAdd(otherEnd, msgs);
		case MmPackage.MODULE__CONTRACT:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContract()).basicAdd(otherEnd, msgs);
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
		case MmPackage.MODULE__IS_PART_OF:
			return basicSetIsPartOf(null, msgs);
		case MmPackage.MODULE__REALIZED_BY:
			return ((InternalEList<?>) getRealizedBy()).basicRemove(otherEnd, msgs);
		case MmPackage.MODULE__PORTS:
			return ((InternalEList<?>) getPorts()).basicRemove(otherEnd, msgs);
		case MmPackage.MODULE__CONTRACT:
			return ((InternalEList<?>) getContract()).basicRemove(otherEnd, msgs);
		case MmPackage.MODULE__MODULE_TYPE:
			return basicSetModuleType(null, msgs);
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
		case MmPackage.MODULE__IS_PART_OF:
			return eInternalContainer().eInverseRemove(this, MmPackage.COMPOUND__CONSISTS_OF, Compound.class, msgs);
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
		case MmPackage.MODULE__NAME:
			return getName();
		case MmPackage.MODULE__IS_PART_OF:
			return getIsPartOf();
		case MmPackage.MODULE__REALIZED_BY:
			return getRealizedBy();
		case MmPackage.MODULE__DESCRIPTION:
			return getDescription();
		case MmPackage.MODULE__PORTS:
			return getPorts();
		case MmPackage.MODULE__CONTRACT:
			return getContract();
		case MmPackage.MODULE__MODULE:
			if (resolve)
				return getModule();
			return basicGetModule();
		case MmPackage.MODULE__VERSION:
			return getVersion();
		case MmPackage.MODULE__RTE:
			return getRte();
		case MmPackage.MODULE__SPEC:
			return getSpec();
		case MmPackage.MODULE__RAM:
			return getRam();
		case MmPackage.MODULE__CAPS:
			return getCaps();
		case MmPackage.MODULE__MODULE_TYPE:
			return getModuleType();
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
		case MmPackage.MODULE__NAME:
			setName((String) newValue);
			return;
		case MmPackage.MODULE__IS_PART_OF:
			setIsPartOf((Compound) newValue);
			return;
		case MmPackage.MODULE__REALIZED_BY:
			getRealizedBy().clear();
			getRealizedBy().addAll((Collection<? extends Abstract>) newValue);
			return;
		case MmPackage.MODULE__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case MmPackage.MODULE__PORTS:
			getPorts().clear();
			getPorts().addAll((Collection<? extends Ports>) newValue);
			return;
		case MmPackage.MODULE__CONTRACT:
			getContract().clear();
			getContract().addAll((Collection<? extends Contract>) newValue);
			return;
		case MmPackage.MODULE__MODULE:
			setModule((de.tu_bs.ccc.contracting.Verification.Module) newValue);
			return;
		case MmPackage.MODULE__VERSION:
			setVersion((String) newValue);
			return;
		case MmPackage.MODULE__RTE:
			setRte((String) newValue);
			return;
		case MmPackage.MODULE__SPEC:
			setSpec((String) newValue);
			return;
		case MmPackage.MODULE__RAM:
			setRam((BigInteger) newValue);
			return;
		case MmPackage.MODULE__CAPS:
			setCaps((BigInteger) newValue);
			return;
		case MmPackage.MODULE__MODULE_TYPE:
			setModuleType((ModuleType) newValue);
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
		case MmPackage.MODULE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case MmPackage.MODULE__IS_PART_OF:
			setIsPartOf((Compound) null);
			return;
		case MmPackage.MODULE__REALIZED_BY:
			getRealizedBy().clear();
			return;
		case MmPackage.MODULE__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case MmPackage.MODULE__PORTS:
			getPorts().clear();
			return;
		case MmPackage.MODULE__CONTRACT:
			getContract().clear();
			return;
		case MmPackage.MODULE__MODULE:
			setModule((de.tu_bs.ccc.contracting.Verification.Module) null);
			return;
		case MmPackage.MODULE__VERSION:
			setVersion(VERSION_EDEFAULT);
			return;
		case MmPackage.MODULE__RTE:
			setRte(RTE_EDEFAULT);
			return;
		case MmPackage.MODULE__SPEC:
			setSpec(SPEC_EDEFAULT);
			return;
		case MmPackage.MODULE__RAM:
			setRam(RAM_EDEFAULT);
			return;
		case MmPackage.MODULE__CAPS:
			setCaps(CAPS_EDEFAULT);
			return;
		case MmPackage.MODULE__MODULE_TYPE:
			setModuleType((ModuleType) null);
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
		case MmPackage.MODULE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case MmPackage.MODULE__IS_PART_OF:
			return getIsPartOf() != null;
		case MmPackage.MODULE__REALIZED_BY:
			return realizedBy != null && !realizedBy.isEmpty();
		case MmPackage.MODULE__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case MmPackage.MODULE__PORTS:
			return ports != null && !ports.isEmpty();
		case MmPackage.MODULE__CONTRACT:
			return contract != null && !contract.isEmpty();
		case MmPackage.MODULE__MODULE:
			return module != null;
		case MmPackage.MODULE__VERSION:
			return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
		case MmPackage.MODULE__RTE:
			return RTE_EDEFAULT == null ? rte != null : !RTE_EDEFAULT.equals(rte);
		case MmPackage.MODULE__SPEC:
			return SPEC_EDEFAULT == null ? spec != null : !SPEC_EDEFAULT.equals(spec);
		case MmPackage.MODULE__RAM:
			return RAM_EDEFAULT == null ? ram != null : !RAM_EDEFAULT.equals(ram);
		case MmPackage.MODULE__CAPS:
			return CAPS_EDEFAULT == null ? caps != null : !CAPS_EDEFAULT.equals(caps);
		case MmPackage.MODULE__MODULE_TYPE:
			return moduleType != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", version: ");
		result.append(version);
		result.append(", rte: ");
		result.append(rte);
		result.append(", spec: ");
		result.append(spec);
		result.append(", ram: ");
		result.append(ram);
		result.append(", caps: ");
		result.append(caps);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
