/**
 */
package de.tu_bs.ccc.contracting.Verification;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Compound#getConsistsOf <em>Consists Of</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getCompound()
 * @model
 * @generated
 */
public interface Compound extends Module {
	/**
	 * Returns the value of the '<em><b>Consists Of</b></em>' containment reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Module}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Module#getIsPartOf <em>Is Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consists Of</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consists Of</em>' containment reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getCompound_ConsistsOf()
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getIsPartOf
	 * @model opposite="isPartOf" containment="true"
	 * @generated
	 */
	EList<Module> getConsistsOf();

} // Compound
