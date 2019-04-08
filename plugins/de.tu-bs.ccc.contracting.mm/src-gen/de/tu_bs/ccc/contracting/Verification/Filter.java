/**
 */
package de.tu_bs.ccc.contracting.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Filter#getAdd <em>Add</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Filter#getRemove <em>Remove</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Filter#getReset <em>Reset</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Filter#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getFilter()
 * @model
 * @generated
 */
public interface Filter extends ModuleType {
	/**
	 * Returns the value of the '<em><b>Add</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add</em>' attribute.
	 * @see #setAdd(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getFilter_Add()
	 * @model default="\"\""
	 * @generated
	 */
	String getAdd();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Filter#getAdd <em>Add</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add</em>' attribute.
	 * @see #getAdd()
	 * @generated
	 */
	void setAdd(String value);

	/**
	 * Returns the value of the '<em><b>Remove</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove</em>' attribute.
	 * @see #setRemove(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getFilter_Remove()
	 * @model default="\"\""
	 * @generated
	 */
	String getRemove();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Filter#getRemove <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove</em>' attribute.
	 * @see #getRemove()
	 * @generated
	 */
	void setRemove(String value);

	/**
	 * Returns the value of the '<em><b>Reset</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset</em>' attribute.
	 * @see #setReset(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getFilter_Reset()
	 * @model default="\"\""
	 * @generated
	 */
	String getReset();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Filter#getReset <em>Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset</em>' attribute.
	 * @see #getReset()
	 * @generated
	 */
	void setReset(String value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getFilter_Alias()
	 * @model default="\"\""
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Filter#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

} // Filter
