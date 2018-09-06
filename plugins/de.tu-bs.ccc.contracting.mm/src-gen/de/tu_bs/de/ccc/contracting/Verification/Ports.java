/**
 */
package de.tu_bs.de.ccc.contracting.Verification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ports</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getType <em>Type</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getPorts <em>Ports</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getPortseOpposite <em>Portse Opposite</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getModule <em>Module</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getInsidePorts <em>Inside Ports</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getInsidePortseOpposite <em>Inside Portse Opposite</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getService <em>Service</em>}</li>
 *   <li>{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getOuterDirection <em>Outer Direction</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts()
 * @model
 * @generated
 */
public interface Ports extends EObject {
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
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.tu_bs.de.ccc.contracting.Verification.PortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.tu_bs.de.ccc.contracting.Verification.PortType
	 * @see #setType(PortType)
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_Type()
	 * @model
	 * @generated
	 */
	PortType getType();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.tu_bs.de.ccc.contracting.Verification.PortType
	 * @see #getType()
	 * @generated
	 */
	void setType(PortType value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' reference list.
	 * The list contents are of type {@link de.tu_bs.de.ccc.contracting.Verification.Ports}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getPortseOpposite <em>Portse Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' reference list.
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_Ports()
	 * @see de.tu_bs.de.ccc.contracting.Verification.Ports#getPortseOpposite
	 * @model opposite="portseOpposite"
	 * @generated
	 */
	EList<Ports> getPorts();

	/**
	 * Returns the value of the '<em><b>Portse Opposite</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Portse Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Portse Opposite</em>' reference.
	 * @see #setPortseOpposite(Ports)
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_PortseOpposite()
	 * @see de.tu_bs.de.ccc.contracting.Verification.Ports#getPorts
	 * @model opposite="ports"
	 * @generated
	 */
	Ports getPortseOpposite();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getPortseOpposite <em>Portse Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Portse Opposite</em>' reference.
	 * @see #getPortseOpposite()
	 * @generated
	 */
	void setPortseOpposite(Ports value);

	/**
	 * Returns the value of the '<em><b>Module</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.de.ccc.contracting.Verification.Module#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' container reference.
	 * @see #setModule(Module)
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_Module()
	 * @see de.tu_bs.de.ccc.contracting.Verification.Module#getPorts
	 * @model opposite="ports" required="true" transient="false"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getModule <em>Module</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' container reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

	/**
	 * Returns the value of the '<em><b>Inside Ports</b></em>' reference list.
	 * The list contents are of type {@link de.tu_bs.de.ccc.contracting.Verification.Ports}.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getInsidePortseOpposite <em>Inside Portse Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Ports</em>' reference list.
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_InsidePorts()
	 * @see de.tu_bs.de.ccc.contracting.Verification.Ports#getInsidePortseOpposite
	 * @model opposite="insidePortseOpposite"
	 * @generated
	 */
	EList<Ports> getInsidePorts();

	/**
	 * Returns the value of the '<em><b>Inside Portse Opposite</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getInsidePorts <em>Inside Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Portse Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Portse Opposite</em>' reference.
	 * @see #setInsidePortseOpposite(Ports)
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_InsidePortseOpposite()
	 * @see de.tu_bs.de.ccc.contracting.Verification.Ports#getInsidePorts
	 * @model opposite="insidePorts"
	 * @generated
	 */
	Ports getInsidePortseOpposite();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getInsidePortseOpposite <em>Inside Portse Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inside Portse Opposite</em>' reference.
	 * @see #getInsidePortseOpposite()
	 * @generated
	 */
	void setInsidePortseOpposite(Ports value);

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
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_Service()
	 * @model default="" dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getService();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getService <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' attribute.
	 * @see #getService()
	 * @generated
	 */
	void setService(String value);

	/**
	 * Returns the value of the '<em><b>Outer Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link de.tu_bs.de.ccc.contracting.Verification.DirectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Direction</em>' attribute.
	 * @see de.tu_bs.de.ccc.contracting.Verification.DirectionType
	 * @see #setOuterDirection(DirectionType)
	 * @see de.tu_bs.de.ccc.contracting.Verification.MmPackage#getPorts_OuterDirection()
	 * @model
	 * @generated
	 */
	DirectionType getOuterDirection();

	/**
	 * Sets the value of the '{@link de.tu_bs.de.ccc.contracting.Verification.Ports#getOuterDirection <em>Outer Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Direction</em>' attribute.
	 * @see de.tu_bs.de.ccc.contracting.Verification.DirectionType
	 * @see #getOuterDirection()
	 * @generated
	 */
	void setOuterDirection(DirectionType value);

} // Ports
