package de.tu_bs.ccc.contracting.core.verification;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;

import com.microsoft.z3.Context;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;
import de.tu_bs.ccc.contracting.core.verification.grammar.GrammarSolver;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement.Property;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement.Result;

public class SafetyLevelSolver implements IViewpointSolver {
	private Context ctx;
	private GrammarSolver gs;

	private ArrayList<VerificationViewElement> vve = null;

	public SafetyLevelSolver() {
		this.ctx = new Context();
		this.gs = new GrammarSolver();
		vve = new ArrayList<VerificationViewElement>();
	}

	@Override
	public String getName() {
		return "Safety Level Check";
	}

	@Override
	public boolean checkRealizability(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkWellFormedness(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkSubstitutability(Module m) {
		if (!(m instanceof Compound))
			return true;

		boolean realizable = true;
		Compound c = (Compound) m;

		Symbol[] declNames = new Symbol[c.getConsistsOf().size() + 1];
		FuncDecl[] decl = new FuncDecl[c.getConsistsOf().size() + 1];

		declNames[0] = this.ctx.mkSymbol(c.getName() + ".ASIL");
		decl[0] = this.ctx.mkConstDecl(declNames[0], ctx.mkRealSort());

		for (int i = 1; i < c.getConsistsOf().size() + 1; i++) {
			declNames[i] = this.ctx.mkSymbol(c.getConsistsOf().get(i - 1).getName().replaceAll(" ", "") + ".ASIL");
			decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkRealSort());

		}

		Solver s = this.ctx.mkSolver();
		for (Module mod : c.getConsistsOf()) {
			for (de.tu_bs.ccc.contracting.Verification.Property cont : mod.getModule().getEnviromentalProperties()) {
				if (cont.getName().equals("ASIL")) {
					String inter = cont.getValue().replaceAll("this.ASIL",
							mod.getName().replaceAll(" ", "") + ".ASIL");
					inter = this.gs.parseString(inter);
					s.add(ctx.parseSMTLIB2String("(assert " + inter + ")", null, null, declNames, decl));
				}
			}

		}
		for (Contract cont : c.getContract()) {
			if (cont.getViewPoint().getValue() == ViewPoint.MEMORY_VALUE) {
				String guarantee = cont.getGuarantee().get(0).getProperty().replaceAll("this.ram",
						c.getName().replaceAll(" ", "") + ".ram");
				guarantee = this.gs.parseString(guarantee);
				String assumption = new String();
				for (Module mod : c.getConsistsOf()) {

					assumption = assumption + " " + mod.getName().replaceAll(" ", "") + ".ram";

				}

				if (c.getConsistsOf().size() == 0) {

				} else if (c.getConsistsOf().size() == 1) {
					s.add(ctx.parseSMTLIB2String(
							"(define-fun ValidContract () Bool (=> " + "(= " + c.getName().replaceAll(" ", "") + ".ram " + ""
									+ assumption + ") " + guarantee + "))(assert (not ValidContract))",
							null, null, declNames, decl));
				}

				else {

					s.add(ctx.parseSMTLIB2String(
							"(define-fun ValidContract () Bool (=> " + "(= " + c.getName().replaceAll(" ", "") + ".ram " + "(+"
									+ assumption + "))" + " " + guarantee + "))(assert (not ValidContract))",
							null, null, declNames, decl));
				}

				if (s.check() == Status.SATISFIABLE) {
					realizable = false;
					URI fileURI = c.eResource().getURI();
					fileURI = fileURI.trimFileExtension();

					vve.add(new VerificationViewElement(ViewPoint.MEMORY_VALUE, s.getModel().toString(), c.getName(), c,
							Result.FAILED, Property.SUBSTITUTABILITY));
				} else {
					vve.add(new VerificationViewElement(ViewPoint.MEMORY_VALUE, s.toString(), c.getName(), c,
							Result.SUCCESS, Property.SUBSTITUTABILITY));
				}
			}

		}

		return realizable;
	}

	@Override
	public ArrayList<VerificationViewElement> getSummary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkConsistency(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

}
