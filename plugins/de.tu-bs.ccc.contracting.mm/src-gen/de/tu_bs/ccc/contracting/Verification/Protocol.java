/**
 */
package de.tu_bs.ccc.contracting.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Protocol#getFrom <em>From</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Protocol#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getProtocol()
 * @model
 * @generated
 */
public interface Protocol extends ModuleType {
	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getProtocol_From()
	 * @model default="\"\""
	 * @generated
	 */
	String getFrom();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Protocol#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(String value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' attribute.
	 * @see #setTo(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getProtocol_To()
	 * @model default="\"\""
	 * @generated
	 */
	String getTo();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Protocol#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(String value);

} // Protocol
