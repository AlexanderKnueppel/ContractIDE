package solver;

import com.microsoft.z3.Context;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Symbol;

import de.tu_bs.ccc.contracting.Verification.Compound;

public class Z3Converter {
	public static String[] getNames(Compound m) {
		String[] names = new String[m.getConsistsOf().size()+1];
		names[0]= m.getName();
		for (int i = 1; i < m.getConsistsOf().size()+1; i++) {
			names[i]= m.getConsistsOf().get(i).getName();
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

}
