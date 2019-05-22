/**
 */
package de.tu_bs.ccc.contracting.Verification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enviromental Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.EnviromentalProperties#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getEnviromentalProperties()
 * @model
 * @generated
 */
public interface EnviromentalProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getEnviromentalProperties_Property()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperty();

} // EnviromentalProperties
