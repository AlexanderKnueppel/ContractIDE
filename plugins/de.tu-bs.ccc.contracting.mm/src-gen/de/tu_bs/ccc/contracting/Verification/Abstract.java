/**
 */
package de.tu_bs.ccc.contracting.Verification;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Abstract#getRealizes <em>Realizes</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getAbstract()
 * @model
 * @generated
 */
public interface Abstract extends Module {
	/**
	 * Returns the value of the '<em><b>Realizes</b></em>' reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Module}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Module#getRealizedBy <em>Realized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realizes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realizes</em>' reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getAbstract_Realizes()
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getRealizedBy
	 * @model opposite="realizedBy"
	 * @generated
	 */
	EList<Module> getRealizes();

} // Abstract
