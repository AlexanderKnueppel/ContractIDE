/**
 */
package de.tu_bs.ccc.contracting.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Proxy#getCarrier <em>Carrier</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getProxy()
 * @model
 * @generated
 */
public interface Proxy extends ModuleType {
	/**
	 * Returns the value of the '<em><b>Carrier</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Carrier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Carrier</em>' attribute.
	 * @see #setCarrier(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getProxy_Carrier()
	 * @model default=""
	 * @generated
	 */
	String getCarrier();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Proxy#getCarrier <em>Carrier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Carrier</em>' attribute.
	 * @see #getCarrier()
	 * @generated
	 */
	void setCarrier(String value);

} // Proxy
