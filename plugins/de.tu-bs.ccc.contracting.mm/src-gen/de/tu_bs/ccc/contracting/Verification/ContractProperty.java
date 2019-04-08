/**
 */
package de.tu_bs.ccc.contracting.Verification;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.ContractProperty#getPropertyTipe <em>Property Tipe</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.ContractProperty#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContractProperty()
 * @model
 * @generated
 */
public interface ContractProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Property Tipe</b></em>' attribute.
	 * The default value is <code>"EQUATION"</code>.
	 * The literals are from the enumeration {@link de.tu_bs.ccc.contracting.Verification.PropertyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Tipe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Tipe</em>' attribute.
	 * @see de.tu_bs.ccc.contracting.Verification.PropertyType
	 * @see #setPropertyTipe(PropertyType)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContractProperty_PropertyTipe()
	 * @model default="EQUATION"
	 * @generated
	 */
	PropertyType getPropertyTipe();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.ContractProperty#getPropertyTipe <em>Property Tipe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Tipe</em>' attribute.
	 * @see de.tu_bs.ccc.contracting.Verification.PropertyType
	 * @see #getPropertyTipe()
	 * @generated
	 */
	void setPropertyTipe(PropertyType value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see #setProperty(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContractProperty_Property()
	 * @model default="\"\"" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getProperty();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.ContractProperty#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(String value);

} // ContractProperty
