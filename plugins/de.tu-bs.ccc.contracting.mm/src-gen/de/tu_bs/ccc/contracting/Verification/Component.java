/**
 */
package de.tu_bs.ccc.contracting.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Component#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Component#getBinary <em>Binary</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends de.tu_bs.ccc.contracting.Verification.Module {

	/**
	 * Returns the value of the '<em><b>Singleton</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton</em>' attribute.
	 * @see #setSingleton(boolean)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getComponent_Singleton()
	 * @model default="false"
	 * @generated
	 */
	boolean isSingleton();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Component#isSingleton <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton</em>' attribute.
	 * @see #isSingleton()
	 * @generated
	 */
	void setSingleton(boolean value);

	/**
	 * Returns the value of the '<em><b>Binary</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary</em>' attribute.
	 * @see #setBinary(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getComponent_Binary()
	 * @model default=""
	 * @generated
	 */
	String getBinary();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Component#getBinary <em>Binary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binary</em>' attribute.
	 * @see #getBinary()
	 * @generated
	 */
	void setBinary(String value);
} // Component
