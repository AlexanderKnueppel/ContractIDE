/**
 */
package de.tu_bs.ccc.contracting.Verification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getIsPartOf <em>Is Part Of</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getRealizedBy <em>Realized By</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getDescription <em>Description</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getPorts <em>Ports</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getContract <em>Contract</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getModule <em>Module</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.Module#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject {
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
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Module#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Part Of</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Compound#getConsistsOf <em>Consists Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Part Of</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Part Of</em>' container reference.
	 * @see #setIsPartOf(Compound)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_IsPartOf()
	 * @see de.tu_bs.ccc.contracting.Verification.Compound#getConsistsOf
	 * @model opposite="consistsOf" transient="false"
	 * @generated
	 */
	Compound getIsPartOf();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Module#getIsPartOf <em>Is Part Of</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Part Of</em>' container reference.
	 * @see #getIsPartOf()
	 * @generated
	 */
	void setIsPartOf(Compound value);

	/**
	 * Returns the value of the '<em><b>Realized By</b></em>' reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Abstract}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Abstract#getRealizes <em>Realizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized By</em>' reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_RealizedBy()
	 * @see de.tu_bs.ccc.contracting.Verification.Abstract#getRealizes
	 * @model opposite="realizes"
	 * @generated
	 */
	EList<Abstract> getRealizedBy();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Module#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Ports}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Ports#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_Ports()
	 * @see de.tu_bs.ccc.contracting.Verification.Ports#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<Ports> getPorts();

	/**
	 * Returns the value of the '<em><b>Contract</b></em>' containment reference list.
	 * The list contents are of type {@link de.tu_bs.ccc.contracting.Verification.Contract}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.ccc.contracting.Verification.Contract#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contract</em>' containment reference list.
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_Contract()
	 * @see de.tu_bs.ccc.contracting.Verification.Contract#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<Contract> getContract();

	/**
	 * Returns the value of the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' reference.
	 * @see #setModule(Module)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_Module()
	 * @model
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Module#getModule <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getModule_Version()
	 * @model default="1.0"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link de.tu_bs.ccc.contracting.Verification.Module#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // Module
