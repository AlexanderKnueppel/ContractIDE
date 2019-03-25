/**
 */
package de.tu_bs.ccc.contracting.Verification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>View Point</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.tu_bs.ccc.contracting.Verification.MmPackage#getViewPoint()
 * @model
 * @generated
 */
public enum ViewPoint implements Enumerator {
	/**
	 * The '<em><b>FUNCTIONAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTIONAL(0, "FUNCTIONAL", "FUNCTIONAL"),

	/**
	 * The '<em><b>TIMING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMING_VALUE
	 * @generated
	 * @ordered
	 */
	TIMING(1, "TIMING", "TIMING"),

	/**
	 * The '<em><b>MEMORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMORY_VALUE
	 * @generated
	 * @ordered
	 */
	MEMORY(2, "MEMORY", "MEMORY");

	/**
	 * The '<em><b>FUNCTIONAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FUNCTIONAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTIONAL_VALUE = 0;

	/**
	 * The '<em><b>TIMING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIMING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIMING_VALUE = 1;

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
	public static final int MEMORY_VALUE = 2;

	/**
	 * An array of all the '<em><b>View Point</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ViewPoint[] VALUES_ARRAY = new ViewPoint[] { FUNCTIONAL, TIMING, MEMORY, };

	/**
	 * A public read-only list of all the '<em><b>View Point</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ViewPoint> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>View Point</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ViewPoint get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ViewPoint result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>View Point</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ViewPoint getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ViewPoint result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>View Point</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ViewPoint get(int value) {
		switch (value) {
		case FUNCTIONAL_VALUE:
			return FUNCTIONAL;
		case TIMING_VALUE:
			return TIMING;
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
	private ViewPoint(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

} //ViewPoint
