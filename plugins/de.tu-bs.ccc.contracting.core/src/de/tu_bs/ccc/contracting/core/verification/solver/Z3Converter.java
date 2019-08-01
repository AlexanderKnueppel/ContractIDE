package de.tu_bs.ccc.contracting.core.verification.solver;

import org.eclipse.emf.common.util.EList;

import com.microsoft.z3.Context;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Symbol;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.ContractProperty;
import de.tu_bs.ccc.contracting.grammar.verification.GrammarSolver;

public class Z3Converter {
	private static GrammarSolver gs = new GrammarSolver();
	public static Z3Converter z= new Z3Converter();

	public static String[] getNames(Compound m) {
		String[] names = new String[m.getConsistsOf().size() + 1];
		names[0] = m.getName();
		for (int i = 1; i < m.getConsistsOf().size() + 1; i++) {
			names[i] = m.getConsistsOf().get(i).getName();
		}
		return names;

	}

	public static void addAssetion(String assertion, Context ctx, Solver s, Symbol[] declNames, FuncDecl[] decl) {

		s.add(ctx.parseSMTLIB2String("(assert " + assertion + ")", null, null, declNames, decl));

	}

	public static Symbol[] defineSymbol(String[] names, String[] appendix, Context ctx) {
		Symbol[] symbols = new Symbol[names.length * appendix.length];
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < appendix.length; j++) {
				symbols[i + (i * j)] = ctx.mkSymbol(names[i] + appendix[j]);
			}
		}

		return symbols;

	}

	public static FuncDecl[] defineFunc(String[] names, String[] appendix, Context ctx, Symbol[] symbols) {
		FuncDecl[] func = new FuncDecl[names.length * appendix.length];
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < appendix.length; j++) {
				func[i + (i * j)] = ctx.mkConstDecl(symbols[0], ctx.mkRealSort());
			}
		}
		return func;
	}

	public static boolean ContractCheck(Contract c,Context ctx,Solver s,Symbol[] symbols,FuncDecl[] func) {
		s.add(ctx.parseSMTLIB2String(
				"(define-fun ValidContract () Bool (=> "  + getProperties(c.getAssumption())  + getProperties(c.getGuarantee())+ "))(assert (not ValidContract))",
				null, null, symbols, func));
		return false;
		
	}

	private static String getProperties(EList<? extends ContractProperty> eList) {
		String z3String = new String();
		for (ContractProperty contractProperty : eList) {
			z3String += "( and";
		}
		if (eList.size()>0) {
			z3String += gs.parseString(eList.get(0).getProperty())+" ";
		}
		for (int i = 1; i < eList.size(); i++) {
			
		
			z3String += gs.parseString(eList.get(i).getProperty()) + ")";
		}
		

		return z3String;
	}
	



}
