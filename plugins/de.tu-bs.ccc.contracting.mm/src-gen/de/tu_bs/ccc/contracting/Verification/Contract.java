/**
 */
package de.tu_bs.ccc.contracting.Verification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Contract#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Contract#getModule <em>Module</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Contract#getViewPoint <em>View Point</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Contract#getAssumption <em>Assumption</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Contract#getGuarantee <em>Guarantee</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContract()
 * @model
 * @generated
 */
public interface Contract extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContract_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Contract#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Module</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Module#getContract <em>Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' container reference.
	 * @see #setModule(Module)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContract_Module()
	 * @see de.tu_bs.ccc.contracting.Verification.Module#getContract
	 * @model opposite="contract" required="true" transient="false"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Contract#getModule <em>Module</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' container reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

	/**
	 * Returns the value of the '<em><b>View Point</b></em>' attribute.
	 * The literals are from the enumeration {@link de.tu_bs.ccc.contracting.Verification.ViewPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Point</em>' attribute.
	 * @see de.tu_bs.ccc.contracting.Verification.ViewPoint
	 * @see #setViewPoint(ViewPoint)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContract_ViewPoint()
	 * @model
	 * @generated
	 */
	ViewPoint getViewPoint();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Contract#getViewPoint <em>View Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Point</em>' attribute.
	 * @see de.tu_bs.ccc.contracting.Verification.ViewPoint
	 * @see #getViewPoint()
	 * @generated
	 */
	void setViewPoint(ViewPoint value);

	/**
	 * Returns the value of the '<em><b>Assumption</b></em>' containment reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Assumption}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Assumption#getContract <em>Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assumption</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assumption</em>' containment reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContract_Assumption()
	 * @see de.tu_bs.ccc.contracting.Verification.Assumption#getContract
	 * @model opposite="contract" containment="true"
	 * @generated
	 */
	EList<Assumption> getAssumption();

	/**
	 * Returns the value of the '<em><b>Guarantee</b></em>' containment reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Guarantee}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Guarantee#getContract <em>Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guarantee</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guarantee</em>' containment reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getContract_Guarantee()
	 * @see de.tu_bs.ccc.contracting.Verification.Guarantee#getContract
	 * @model opposite="contract" containment="true"
	 * @generated
	 */
	EList<Guarantee> getGuarantee();

} // Contract
