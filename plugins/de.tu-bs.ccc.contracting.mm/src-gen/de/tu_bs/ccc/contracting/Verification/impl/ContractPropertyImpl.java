/**
 */
package de.tu_bs.ccc.contracting.Verification.impl;

import de.tu_bs.ccc.contracting.Verification.ContractProperty;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import de.tu_bs.ccc.contracting.Verification.PropertyType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ContractPropertyImpl#getPropertyTipe <em>Property Tipe</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.ContractPropertyImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractPropertyImpl extends MinimalEObjectImpl.Container implements ContractProperty {
	/**
	 * The default value of the '{@link #getPropertyTipe() <em>Property Tipe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTipe()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyType PROPERTY_TIPE_EDEFAULT = PropertyType.EQUATION;

	/**
	 * The cached value of the '{@link #getPropertyTipe() <em>Property Tipe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTipe()
	 * @generated
	 * @ordered
	 */
	protected PropertyType propertyTipe = PROPERTY_TIPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected String property = PROPERTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContractPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MmPackage.Literals.CONTRACT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyType getPropertyTipe() {
		return propertyTipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPropertyTipe(PropertyType newPropertyTipe) {
		PropertyType oldPropertyTipe = propertyTipe;
		propertyTipe = newPropertyTipe == null ? PROPERTY_TIPE_EDEFAULT : newPropertyTipe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.CONTRACT_PROPERTY__PROPERTY_TIPE,
					oldPropertyTipe, propertyTipe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(String newProperty) {
		String oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.CONTRACT_PROPERTY__PROPERTY, oldProperty,
					property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MmPackage.CONTRACT_PROPERTY__PROPERTY_TIPE:
			return getPropertyTipe();
		case MmPackage.CONTRACT_PROPERTY__PROPERTY:
			return getProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MmPackage.CONTRACT_PROPERTY__PROPERTY_TIPE:
			setPropertyTipe((PropertyType) newValue);
			return;
		case MmPackage.CONTRACT_PROPERTY__PROPERTY:
			setProperty((String) newValue);
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
		case MmPackage.CONTRACT_PROPERTY__PROPERTY_TIPE:
			setPropertyTipe(PROPERTY_TIPE_EDEFAULT);
			return;
		case MmPackage.CONTRACT_PROPERTY__PROPERTY:
			setProperty(PROPERTY_EDEFAULT);
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
		case MmPackage.CONTRACT_PROPERTY__PROPERTY_TIPE:
			return propertyTipe != PROPERTY_TIPE_EDEFAULT;
		case MmPackage.CONTRACT_PROPERTY__PROPERTY:
			return PROPERTY_EDEFAULT == null ? property != null : !PROPERTY_EDEFAULT.equals(property);
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
		result.append(" (propertyTipe: ");
		result.append(propertyTipe);
		result.append(", property: ");
		result.append(property);
		result.append(')');
		return result.toString();
	}

} //ContractPropertyImpl
