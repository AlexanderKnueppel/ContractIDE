/**
 */
package de.tu_bs.ccc.contracting.Verification.impl;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import de.tu_bs.ccc.contracting.Verification.Module;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.CompoundImpl#getConsitsOf <em>Consits Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompoundImpl extends ModuleImpl implements Compound {
	/**
	 * The cached value of the '{@link #getConsitsOf() <em>Consits Of</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsitsOf()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> consitsOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MmPackage.Literals.COMPOUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getConsitsOf() {
		if (consitsOf == null) {
			consitsOf = new EObjectContainmentWithInverseEList<Module>(Module.class, this,
					MmPackage.COMPOUND__CONSITS_OF, MmPackage.MODULE__IS_PART_OF);
		}
		return consitsOf;
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
		case MmPackage.COMPOUND__CONSITS_OF:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConsitsOf()).basicAdd(otherEnd, msgs);
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
		case MmPackage.COMPOUND__CONSITS_OF:
			return ((InternalEList<?>) getConsitsOf()).basicRemove(otherEnd, msgs);
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
		case MmPackage.COMPOUND__CONSITS_OF:
			return getConsitsOf();
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
		case MmPackage.COMPOUND__CONSITS_OF:
			getConsitsOf().clear();
			getConsitsOf().addAll((Collection<? extends Module>) newValue);
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
		case MmPackage.COMPOUND__CONSITS_OF:
			getConsitsOf().clear();
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
		case MmPackage.COMPOUND__CONSITS_OF:
			return consitsOf != null && !consitsOf.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompoundImpl
