/**
 */
package de.tu_bs.de.ccc.contracting.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guarantee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Guarantee#getContract <em>Contract</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getGuarantee()
 * @model
 * @generated
 */
public interface Guarantee extends ContractProperty {
	/**
	 * Returns the value of the '<em><b>Contract</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.de.ccc.contracting.Verification.Contract#getGuarantee <em>Guarantee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contract</em>' container reference.
	 * @see #setContract(Contract)
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getGuarantee_Contract()
	 * @see de.tu_bs.de.ccc.contracting.Verification.Contract#getGuarantee
	 * @model opposite="guarantee" required="true" transient="false"
	 * @generated
	 */
	Contract getContract();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Guarantee#getContract <em>Contract</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract</em>' container reference.
	 * @see #getContract()
	 * @generated
	 */
	void setContract(Contract value);

} // Guarantee
