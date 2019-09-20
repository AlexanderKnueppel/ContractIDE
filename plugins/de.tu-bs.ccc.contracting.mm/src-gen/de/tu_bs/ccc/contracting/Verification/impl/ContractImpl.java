/**
 */
package de.tu_bs.ccc.contracting.Verification.impl;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ContractImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ContractImpl#getModule <em>Module</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ContractImpl#getViewPoint <em>View Point</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ContractImpl#getAssumption <em>Assumption</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ContractImpl#getGuarantee <em>Guarantee</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractImpl extends MinimalEObjectImpl.Container implements Contract {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

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
	 * The default value of the '{@link #getViewPoint() <em>View Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPoint()
	 * @generated
	 * @ordered
	 */
	protected static final ViewPoint VIEW_POINT_EDEFAULT = ViewPoint.FUNCTIONAL;

	/**
	 * The cached value of the '{@link #getViewPoint() <em>View Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPoint()
	 * @generated
	 * @ordered
	 */
	protected ViewPoint viewPoint = VIEW_POINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssumption() <em>Assumption</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssumption()
	 * @generated
	 * @ordered
	 */
	protected EList<Assumption> assumption;

	/**
	 * The cached value of the '{@link #getGuarantee() <em>Guarantee</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuarantee()
	 * @generated
	 * @ordered
	 */
	protected EList<Guarantee> guarantee;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MmPackage.Literals.CONTRACT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.CONTRACT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public de.tu_bs.ccc.contracting.Verification.Module getModule() {
		if (eContainerFeatureID() != MmPackage.CONTRACT__MODULE)
			return null;
		return (de.tu_bs.ccc.contracting.Verification.Module) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModule(de.tu_bs.ccc.contracting.Verification.Module newModule,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newModule, MmPackage.CONTRACT__MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModule(de.tu_bs.ccc.contracting.Verification.Module newModule) {
		if (newModule != eInternalContainer()
				|| (eContainerFeatureID() != MmPackage.CONTRACT__MODULE && newModule != null)) {
			if (EcoreUtil.isAncestor(this, newModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModule != null)
				msgs = ((InternalEObject) newModule).eInverseAdd(this, MmPackage.MODULE__CONTRACT,
						de.tu_bs.ccc.contracting.Verification.Module.class, msgs);
			msgs = basicSetModule(newModule, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.CONTRACT__MODULE, newModule, newModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ViewPoint getViewPoint() {
		return viewPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setViewPoint(ViewPoint newViewPoint) {
		ViewPoint oldViewPoint = viewPoint;
		viewPoint = newViewPoint == null ? VIEW_POINT_EDEFAULT : newViewPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.CONTRACT__VIEW_POINT, oldViewPoint,
					viewPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Assumption> getAssumption() {
		if (assumption == null) {
			assumption = new EObjectContainmentWithInverseEList<Assumption>(Assumption.class, this,
					MmPackage.CONTRACT__ASSUMPTION, MmPackage.ASSUMPTION__CONTRACT);
		}
		return assumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Guarantee> getGuarantee() {
		if (guarantee == null) {
			guarantee = new EObjectContainmentWithInverseEList<Guarantee>(Guarantee.class, this,
					MmPackage.CONTRACT__GUARANTEE, MmPackage.GUARANTEE__CONTRACT);
		}
		return guarantee;
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
		case MmPackage.CONTRACT__MODULE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetModule((de.tu_bs.ccc.contracting.Verification.Module) otherEnd, msgs);
		case MmPackage.CONTRACT__ASSUMPTION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAssumption()).basicAdd(otherEnd, msgs);
		case MmPackage.CONTRACT__GUARANTEE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getGuarantee()).basicAdd(otherEnd, msgs);
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
		case MmPackage.CONTRACT__MODULE:
			return basicSetModule(null, msgs);
		case MmPackage.CONTRACT__ASSUMPTION:
			return ((InternalEList<?>) getAssumption()).basicRemove(otherEnd, msgs);
		case MmPackage.CONTRACT__GUARANTEE:
			return ((InternalEList<?>) getGuarantee()).basicRemove(otherEnd, msgs);
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
		case MmPackage.CONTRACT__MODULE:
			return eInternalContainer().eInverseRemove(this, MmPackage.MODULE__CONTRACT,
					de.tu_bs.ccc.contracting.Verification.Module.class, msgs);
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
		case MmPackage.CONTRACT__NAME:
			return getName();
		case MmPackage.CONTRACT__MODULE:
			return getModule();
		case MmPackage.CONTRACT__VIEW_POINT:
			return getViewPoint();
		case MmPackage.CONTRACT__ASSUMPTION:
			return getAssumption();
		case MmPackage.CONTRACT__GUARANTEE:
			return getGuarantee();
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
		case MmPackage.CONTRACT__NAME:
			setName((String) newValue);
			return;
		case MmPackage.CONTRACT__MODULE:
			setModule((de.tu_bs.ccc.contracting.Verification.Module) newValue);
			return;
		case MmPackage.CONTRACT__VIEW_POINT:
			setViewPoint((ViewPoint) newValue);
			return;
		case MmPackage.CONTRACT__ASSUMPTION:
			getAssumption().clear();
			getAssumption().addAll((Collection<? extends Assumption>) newValue);
			return;
		case MmPackage.CONTRACT__GUARANTEE:
			getGuarantee().clear();
			getGuarantee().addAll((Collection<? extends Guarantee>) newValue);
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
		case MmPackage.CONTRACT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case MmPackage.CONTRACT__MODULE:
			setModule((de.tu_bs.ccc.contracting.Verification.Module) null);
			return;
		case MmPackage.CONTRACT__VIEW_POINT:
			setViewPoint(VIEW_POINT_EDEFAULT);
			return;
		case MmPackage.CONTRACT__ASSUMPTION:
			getAssumption().clear();
			return;
		case MmPackage.CONTRACT__GUARANTEE:
			getGuarantee().clear();
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
		case MmPackage.CONTRACT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case MmPackage.CONTRACT__MODULE:
			return getModule() != null;
		case MmPackage.CONTRACT__VIEW_POINT:
			return viewPoint != VIEW_POINT_EDEFAULT;
		case MmPackage.CONTRACT__ASSUMPTION:
			return assumption != null && !assumption.isEmpty();
		case MmPackage.CONTRACT__GUARANTEE:
			return guarantee != null && !guarantee.isEmpty();
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
		result.append(", ViewPoint: ");
		result.append(viewPoint);
		result.append(')');
		return result.toString();
	}

} //ContractImpl
