/**
 */
package de.tu_bs.ccc.contracting.Verification.impl;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Interface;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;

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
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getGetsrealized <em>Getsrealized</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getContract <em>Contract</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ModuleImpl#getModule <em>Module</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleImpl extends MinimalEObjectImpl.Container implements Module {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getGetsrealized() <em>Getsrealized</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetsrealized()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> getsrealized;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

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
	protected Module module;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public void setIsPartOf(Compound newIsPartOf) {
		if (newIsPartOf != eInternalContainer()
				|| (eContainerFeatureID() != MmPackage.MODULE__IS_PART_OF && newIsPartOf != null)) {
			if (EcoreUtil.isAncestor(this, newIsPartOf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIsPartOf != null)
				msgs = ((InternalEObject) newIsPartOf).eInverseAdd(this, MmPackage.COMPOUND__CONSITS_OF, Compound.class,
						msgs);
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
	public EList<Interface> getGetsrealized() {
		if (getsrealized == null) {
			getsrealized = new EObjectWithInverseResolvingEList.ManyInverse<Interface>(Interface.class, this,
					MmPackage.MODULE__GETSREALIZED, MmPackage.INTERFACE__REALIZES);
		}
		return getsrealized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public Module getModule() {
		if (module != null && module.eIsProxy()) {
			InternalEObject oldModule = (InternalEObject) module;
			module = (Module) eResolveProxy(oldModule);
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
	public Module basicGetModule() {
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(Module newModule) {
		Module oldModule = module;
		module = newModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.MODULE__MODULE, oldModule, module));
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
		case MmPackage.MODULE__GETSREALIZED:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getGetsrealized()).basicAdd(otherEnd, msgs);
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
		case MmPackage.MODULE__GETSREALIZED:
			return ((InternalEList<?>) getGetsrealized()).basicRemove(otherEnd, msgs);
		case MmPackage.MODULE__PORTS:
			return ((InternalEList<?>) getPorts()).basicRemove(otherEnd, msgs);
		case MmPackage.MODULE__CONTRACT:
			return ((InternalEList<?>) getContract()).basicRemove(otherEnd, msgs);
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
			return eInternalContainer().eInverseRemove(this, MmPackage.COMPOUND__CONSITS_OF, Compound.class, msgs);
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
		case MmPackage.MODULE__GETSREALIZED:
			return getGetsrealized();
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
		case MmPackage.MODULE__GETSREALIZED:
			getGetsrealized().clear();
			getGetsrealized().addAll((Collection<? extends Interface>) newValue);
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
			setModule((Module) newValue);
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
		case MmPackage.MODULE__GETSREALIZED:
			getGetsrealized().clear();
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
			setModule((Module) null);
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
		case MmPackage.MODULE__GETSREALIZED:
			return getsrealized != null && !getsrealized.isEmpty();
		case MmPackage.MODULE__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case MmPackage.MODULE__PORTS:
			return ports != null && !ports.isEmpty();
		case MmPackage.MODULE__CONTRACT:
			return contract != null && !contract.isEmpty();
		case MmPackage.MODULE__MODULE:
			return module != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
