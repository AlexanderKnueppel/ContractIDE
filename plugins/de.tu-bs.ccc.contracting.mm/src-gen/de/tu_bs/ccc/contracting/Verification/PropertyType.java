/**
 */
package de.tu_bs.ccc.contracting.Verification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Property Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getPropertyType()
 * @model
 * @generated
 */
public enum PropertyType implements Enumerator {
	/**
	 * The '<em><b>EQUATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUATION_VALUE
	 * @generated
	 * @ordered
	 */
	EQUATION(0, "EQUATION", "EQUATION"),

	/**
	 * The '<em><b>MINDELAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINDELAY_VALUE
	 * @generated
	 * @ordered
	 */
	MINDELAY(1, "MINDELAY", "MINDELAY"),

	/**
	 * The '<em><b>MAXDELAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAXDELAY_VALUE
	 * @generated
	 * @ordered
	 */
	MAXDELAY(2, "MAXDELAY", "MAXDELAY"),

	/**
	 * The '<em><b>FREQUENCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREQUENCY_VALUE
	 * @generated
	 * @ordered
	 */
	FREQUENCY(3, "FREQUENCY", "FREQUENCY"),

	/**
	 * The '<em><b>JITTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JITTER_VALUE
	 * @generated
	 * @ordered
	 */
	JITTER(4, "JITTER", "JITTER"),

	/**
	 * The '<em><b>MINDURATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINDURATION_VALUE
	 * @generated
	 * @ordered
	 */
	MINDURATION(5, "MINDURATION", "MINDURATION"),

	/**
	 * The '<em><b>MAXDURATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAXDURATION_VALUE
	 * @generated
	 * @ordered
	 */
	MAXDURATION(6, "MAXDURATION", "MAXDURATION"),

	/**
	 * The '<em><b>MEMORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMORY_VALUE
	 * @generated
	 * @ordered
	 */
	MEMORY(7, "MEMORY", "MEMORY");

	/**
	 * The '<em><b>EQUATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUATION_VALUE = 0;

	/**
	 * The '<em><b>MINDELAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINDELAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINDELAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MINDELAY_VALUE = 1;

	/**
	 * The '<em><b>MAXDELAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAXDELAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAXDELAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAXDELAY_VALUE = 2;

	/**
	 * The '<em><b>FREQUENCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREQUENCY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREQUENCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREQUENCY_VALUE = 3;

	/**
	 * The '<em><b>JITTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JITTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JITTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JITTER_VALUE = 4;

	/**
	 * The '<em><b>MINDURATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINDURATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINDURATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MINDURATION_VALUE = 5;

	/**
	 * The '<em><b>MAXDURATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAXDURATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAXDURATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAXDURATION_VALUE = 6;

	/**
	 * The '<em><b>MEMORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEMORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMORY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEMORY_VALUE = 7;

	/**
	 * An array of all the '<em><b>Property Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PropertyType[] VALUES_ARRAY = new PropertyType[] { EQUATION, MINDELAY, MAXDELAY, FREQUENCY,
			JITTER, MINDURATION, MAXDURATION, MEMORY, };

	/**
	 * A public read-only list of all the '<em><b>Property Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PropertyType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Property Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PropertyType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PropertyType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Property Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PropertyType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PropertyType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Property Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PropertyType get(int value) {
		switch (value) {
		case EQUATION_VALUE:
			return EQUATION;
		case MINDELAY_VALUE:
			return MINDELAY;
		case MAXDELAY_VALUE:
			return MAXDELAY;
		case FREQUENCY_VALUE:
			return FREQUENCY;
		case JITTER_VALUE:
			return JITTER;
		case MINDURATION_VALUE:
			return MINDURATION;
		case MAXDURATION_VALUE:
			return MAXDURATION;
		case MEMORY_VALUE:
			return MEMORY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private PropertyType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //PropertyType
