/**
 */
package de.tu_bs.ccc.contracting.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mux</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Mux#getService <em>Service</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getMux()
 * @model
 * @generated
 */
public interface Mux extends ModuleType {
	/**
	 * Returns the value of the '<em><b>Service</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' attribute.
	 * @see #setService(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getMux_Service()
	 * @model default=""
	 * @generated
	 */
	String getService();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Mux#getService <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' attribute.
	 * @see #getService()
	 * @generated
	 */
	void setService(String value);

} // Mux
