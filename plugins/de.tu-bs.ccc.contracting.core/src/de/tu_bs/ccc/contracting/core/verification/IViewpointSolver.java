package de.tu_bs.ccc.contracting.core.verification;

import java.util.ArrayList;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement;

public interface IViewpointSolver {
	public String getName();

	/**
	 * checks whether an abstract component can be realized by other components
	 * @param m the abstract component
	 * @return
	 */
	public boolean checkRealizability(Module m);

	/**
	 * checks whether the contracts of a component have the right and proper syntax
	 * @param m the module whose contracts are checked for syntax correctness
	 * @return whether it is consistent
	 */
	public boolean checkConsistency(Module m);

	/**
	 * @param m
	 * @return
	 */
	public boolean checkWellFormedness(Module m);

	/**
	 * checks whether a component is replaceable by its subcomponents
	 * @param m the component containing subcomponents
	 * @return whether it is replaceable by its subcomponents
	 */
	public boolean checkSubstitutability(Module m);

	public ArrayList<VerificationViewElement> getSummary();
}
