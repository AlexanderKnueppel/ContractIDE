package de.tu_bs.ccc.contracting.core.verification;

import java.util.ArrayList;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement;

public interface IViewpointSolver {
	public String getName();
	public boolean checkRealizability(Module m);
	public boolean checkWellFormedness(Module m);
	public boolean checkSubstitutability(Module m);
	
	public ArrayList<VerificationViewElement> getSummary();
}
