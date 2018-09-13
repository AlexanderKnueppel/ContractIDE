/**
 */
package de.tu_bs.ccc.contracting.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Assumption#getContract <em>Contract</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getAssumption()
 * @model
 * @generated
 */
public interface Assumption extends ContractProperty {
	/**
	 * Returns the value of the '<em><b>Contract</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Contract#getAssumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contract</em>' container reference.
	 * @see #setContract(Contract)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getAssumption_Contract()
	 * @see de.tu_bs.ccc.contracting.Verification.Contract#getAssumption
	 * @model opposite="assumption" required="true" transient="false"
	 * @generated
	 */
	Contract getContract();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Assumption#getContract <em>Contract</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract</em>' container reference.
	 * @see #getContract()
	 * @generated
	 */
	void setContract(Contract value);

} // Assumption
