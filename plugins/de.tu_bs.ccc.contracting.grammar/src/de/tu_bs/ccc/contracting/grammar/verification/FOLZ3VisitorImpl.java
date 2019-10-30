package de.tu_bs.ccc.contracting.grammar.verification;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.AddoperatorContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.ArrayContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.CompareformulaContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.CompoperatorContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.ComppropertyContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.ConditionContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.ConnectiveformulaContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.ConnectoperatorContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.FaktorformulaContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.FormulaContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.FunctioncallContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.MultoperatorContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.NottermContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.OperatorformulaContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.PortContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.PortpropertyContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.PowerformulaContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.Pred_constantContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.QuantifierContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.SummformulaContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.TermContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.TupelContext;
import de.tu_bs.ccc.contracting.grammar.verification.FOLZ3Parser.TupelformulaContext;

public class FOLZ3VisitorImpl implements FOLZ3Visitor<String> {
	public class FuncTupel {
		String funcName;

		public String getFuncName() {
			return funcName;
		}

		public ArrayList<String> getParameter() {
			return parameter;
		}

		ArrayList<String> parameter;

	}

	private static FOLZ3VisitorImpl instance;
	private ArrayList<String> productdef = new ArrayList<String>();
	private ArrayList<String> mindef = new ArrayList<String>();
	private ArrayList<String> maxdef = new ArrayList<String>();
	private Map<String, ArrayList<String>> funcDef = new HashMap<String, ArrayList<String>>();
//	public Map<String, ArrayList<String>> getFuncDef() {
//		return funcDef;
//	}
//
//	public void setFuncDef(Map<String, ArrayList<String>> funcDef) {
//		this.funcDef = funcDef;
//	}

	public Map<String, ArrayList<ArrayList<String>>> getFuncTupel() {
		return funcTupel;
	}

	public void setFuncTupel(Map<String, ArrayList<ArrayList<String>>> funcTupel) {
		this.funcTupel = funcTupel;
	}

	private Map<String, ArrayList<ArrayList<String>>> funcTupel = new HashMap<String, ArrayList<ArrayList<String>>>();

	public ArrayList<String> getProductdef() {
		return productdef;
	}

	public void setProductdef(ArrayList<String> productdef) {
		this.productdef = productdef;
	}

	public ArrayList<String> getSumdef() {
		return sumdef;
	}

	public void setSumdef(ArrayList<String> sumdef) {
		this.sumdef = sumdef;
	}

	private ArrayList<String> sumdef = new ArrayList<String>();

	public FOLZ3VisitorImpl() {
		super();
	}

	// Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes
	// Objekt erzeugt und dieses zurückliefert.
	public static FOLZ3VisitorImpl getInstance() {
		if (FOLZ3VisitorImpl.instance == null) {
			FOLZ3VisitorImpl.instance = new FOLZ3VisitorImpl();
		}
		return FOLZ3VisitorImpl.instance;
	}

	public static FOLZ3VisitorImpl reset() {
		FOLZ3VisitorImpl.instance = new FOLZ3VisitorImpl();
		return FOLZ3VisitorImpl.instance;
	}

	@Override
	public String visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitChildren(RuleNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(ParseTree arg0) {
		return "bla";
	}

	@Override
	public String visitTerm(TermContext ctx) {

		if (ctx.LPAREN() != null && ctx.RPAREN() != null) {
			if (ctx.formula() != null) {
				return this.visitFormula(ctx.formula());
			} else if (ctx.MINUS() != null) {
				return "-" + this.visitTerm(ctx.term());
			} else if (ctx.term() != null) {
				return this.visitTerm(ctx.term());
			}

		} else if (ctx.STRING() != null) {
			if (ctx.STRING().getText().equals("\"true\"")) {

				return "true";
			} else if (ctx.STRING().getText().equals("\"false\"")) {

				return "false";
			}
			return ctx.STRING().getText();
		}

		else if (ctx.TRUE() != null) {
			return "true";
		} else if (ctx.FALSE() != null) {
			return "false";
		}

		else if (ctx.IDENTIFIER() != null) {
			return ctx.IDENTIFIER().getText();
		} else if (ctx.NUMBER() != null) {
			return ctx.NUMBER().getText();
		} else if (ctx.functioncall() != null) {

			return visitFunctioncall(ctx.functioncall());
		} else if (ctx.compproperty() != null) {
			return ctx.compproperty().getText();
		} else if (ctx.port() != null) {

			return ctx.port().getText();
		} else if (ctx.array() != null) {
			return visitArray(ctx.array());
		} else if (ctx.portproperty() != null) {
			return visitPortproperty(ctx.portproperty());
		}
		return "ERROR";

	}

	@Override
	public String visitNotterm(NottermContext ctx) {
		if (ctx.NOT() == null) {
			return (this.visitTerm(ctx.term()));
		} else {
			return ("(" + "not" + " " + this.visitTerm(ctx.term()) + ")");
		}

	}

	@Override
	public String visitFormula(FormulaContext ctx) {
		if (ctx.tupelformula() != null) {
			return visitTupelformula(ctx.tupelformula());
		}
		if (ctx.quantifier() != null) {
			return visitQuantifier(ctx.quantifier());
		}
		if (ctx.operatorformula() != null) {
			return visitOperatorformula(ctx.operatorformula());
		}
		if (ctx.formula() != null) {
			return visitFormula(ctx.formula());
		}
		return this.visitConnectiveformula(ctx.connectiveformula());
	}

	@Override
	public String visitCondition(ConditionContext ctx) {
		// TODO Auto-generated method stub
		return visitFormula(ctx.formula());
	}

	@Override
	public String visitPowerformula(PowerformulaContext ctx) {
		String ret = new String();
		if (ctx.POWER().size() == 0) {
			return this.visitNotterm(ctx.notterm(0));
		} else {
			for (int i = (ctx.POWER().size() - 1); i >= 0; i--) {

				ret += "(" + "^ ";

			}

			for (int i = 1; i < ctx.notterm().size(); i++) {
				if (i == 1) {
					ret += this.visitNotterm(ctx.notterm(0));
				}
				ret += " " + this.visitNotterm(ctx.notterm(i)) + ")";
			}
		}

		return ret;
	}

	@Override
	public String visitFaktorformula(FaktorformulaContext ctx) {
		String ret = new String();
		if (ctx.multoperator().size() == 0) {
			return this.visitPowerformula(ctx.powerformula(0));
		} else {
			for (int i = (ctx.multoperator().size() - 1); i >= 0; i--) {
				switch (ctx.multoperator().get(i).getText()) {

				case "*":
					ret += "(" + "* ";
					break;

				case "/":
					ret += "(" + "/ ";
					break;
				case "%":
					ret += "(" + "mod" + " ";
					break;
				}
			}
			for (int i = 1; i < ctx.powerformula().size(); i++) {
				if (i == 1) {
					ret += this.visitPowerformula(ctx.powerformula(0));
				}
				ret += " " + this.visitPowerformula(ctx.powerformula(i)) + ")";
			}
		}

		return ret;
	}

	@Override
	public String visitSummformula(SummformulaContext ctx) {
		String ret = new String();
		if (ctx.addoperator().size() == 0) {
			return this.visitFaktorformula(ctx.faktorformula(0));
		} else {
			for (int i = (ctx.addoperator().size() - 1); i >= 0; i--) {
				switch (ctx.addoperator().get(i).getText()) {

				case "+":
					ret += "(" + "+ ";
					break;

				case "-":
					ret += "(" + "- ";
					break;

				}
			}
			for (int i = 1; i < ctx.faktorformula().size(); i++) {
				if (i == 1) {
					ret += this.visitFaktorformula(ctx.faktorformula(0));
				}
				ret += " " + this.visitFaktorformula(ctx.faktorformula(i)) + ")";
			}
		}

		return ret;
	}

	@Override
	public String visitConnectiveformula(ConnectiveformulaContext ctx) {
		String ret = new String();
		if (ctx.connectoperator().size() == 0) {
			return this.visitCompareformula(ctx.compareformula(0));
		} else {
			for (int i = (ctx.connectoperator().size() - 1); i >= 0; i--) {
				switch (ctx.connectoperator().get(i).getText()) {

				case "&&":
					ret += "(" + "and" + " ";
					break;

				case "||":
					ret += "(" + "or" + " ";
					break;
				case "^":
					ret += "(" + "xor" + " ";
					break;
				case "=>":
					ret += "(" + "=>" + " ";
					break;
				}
			}
			for (int i = 1; i < ctx.compareformula().size(); i++) {
				if (i == 1) {
					ret += this.visitCompareformula(ctx.compareformula(0));
				}
				ret += " " + this.visitCompareformula(ctx.compareformula(i)) + ")";
			}
		}

		return ret;
	}

	@Override
	public String visitCompareformula(CompareformulaContext ctx) {
		String ret = new String();
		if (ctx.compoperator().size() == 0) {
			return this.visitSummformula(ctx.summformula(0));
		} else {
			for (int i = (ctx.compoperator().size() - 1); i >= 0; i--) {
				switch (ctx.compoperator().get(i).getText()) {

				case "<":
					ret += "(" + "< ";
					break;

				case ">":
					ret += "(" + "> ";
					break;

				case ">=":
					ret += "(" + ">= ";
					break;

				case "<=":
					ret += "(" + "<= ";
					break;

				case "==":
					ret += "(" + "= ";
					break;

				}
			}
			for (int i = 1; i < ctx.summformula().size(); i++) {
				if (i == 1) {
					ret += this.visitSummformula(ctx.summformula(0));
				}
				ret += " " + this.visitSummformula(ctx.summformula(i)) + ")";
			}
		}

		return ret;
	}

	@Override
	public String visitCompoperator(CompoperatorContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMultoperator(MultoperatorContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitAddoperator(AddoperatorContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitConnectoperator(ConnectoperatorContext ctx) {

		return null;
	}

	@Override
	public String visitPred_constant(Pred_constantContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArray(ArrayContext ctx) {

		String ret = "(select ";
		if (ctx.IDENTIFIER().size() > 1) {
			for (int i = 0; i < ctx.IDENTIFIER().size() - 1; i++) {

				ret += ctx.IDENTIFIER().get(i).getText() + ".";

			}
		} else if (ctx.COMPONENT() != null) {
			ret += ctx.COMPONENT().getText() + ctx.CODEWORD().getText();

		}
		ret += ctx.IDENTIFIER().get(ctx.IDENTIFIER().size() - 1).getText() + " ";
		for (int i = 0; i < ctx.term().size() || i < ctx.formula().size(); i++) {

			if (ctx.term(i) != null) {
				ret += visitTerm(ctx.term(i));
			} else if (ctx.formula(i) != null) {
				ret += visitFormula(ctx.formula(i));
			}
		}
		ret += ")";

		return ret;
	}

	@Override
	public String visitCompproperty(ComppropertyContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPortproperty(PortpropertyContext ctx) {
		String ret = ctx.IDENTIFIER().get(0).getText() + ctx.CODEWORD();
		if (ctx.IDENTIFIER().get(1) != null) {
			ret += ctx.IDENTIFIER().get(1).getText();

		} else {
			ret += visitArray(ctx.array());
		}
		return ret;
	}

	@Override
	public String visitPort(PortContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitFunctioncall(FunctioncallContext ctx) {

		if (funcDef.containsKey(ctx.IDENTIFIER(0) + "." + ctx.IDENTIFIER(1))) {
			if (!funcTupel.containsKey(ctx.IDENTIFIER(0) + "." + ctx.IDENTIFIER(1))) {
				funcTupel.put(ctx.IDENTIFIER(0) + "." + ctx.IDENTIFIER(1), new ArrayList<ArrayList<String>>());

			}
		} else {
			funcTupel.put(ctx.IDENTIFIER(0) + "." + ctx.IDENTIFIER(1), new ArrayList<ArrayList<String>>());
		}
		ArrayList<String> tupelList = new ArrayList<String>();

		String ret = "(" + ctx.IDENTIFIER(0) + "." + ctx.IDENTIFIER(1) + " ";

		int i[] = { ctx.term().size(), ctx.formula().size() };
		for (int j = 0; j < Arrays.stream(i).max().getAsInt(); j++) {
			if (ctx.term().get(j) != null) {
				tupelList.add(visitTerm(ctx.term().get(j)));
				ret += visitTerm(ctx.term().get(j)) + " ";
			} else if (ctx.formula().get(j) != null) {
				tupelList.add(visitFormula(ctx.formula().get(j)));
				ret += visitFormula(ctx.formula().get(j)) + " ";
			}
		}
		ret += ")";
		funcTupel.get(ctx.IDENTIFIER(0) + "." + ctx.IDENTIFIER(1)).add(tupelList);

		return ret;
	}

//	private String[] getBorders(TermContext termContext, TermContext termContext2, TermContext termContext3,
//			TermContext termContext4, TerminalNode var, CompoperatorContext compoperatorContext,
//			CompoperatorContext compoperatorContext2) {
//		String bound1 = null;
//
//		String bound2 = null;
//		String term1 = termContext.getText();
//		String term2 = termContext2.getText();
//		String term3 = termContext3.getText();
//		String term4 = termContext4.getText();
//		String varr = var.getText();
//		if (termContext.getText().equals(var.getText())) {
//			if (compoperatorContext.getText().equals("<")) {
//				bound2 = "(- " + termContext2.getText() + " 1)";
//			}
//			if (compoperatorContext.getText().equals("<=")) {
//				bound2 = termContext2.getText();
//			}
//			if (compoperatorContext.getText().equals(">")) {
//				bound1 = "(+ " + termContext2.getText() + " 1)";
//			}
//			if (compoperatorContext.getText().equals(">=")) {
//				bound1 = termContext2.getText();
//			}
//		} else if (termContext2.getText().equals(var.getText())) {
//			if (compoperatorContext.getText().equals("<")) {
//				bound1 = "(+ " + termContext.getText() + " 1)";
//			}
//			if (compoperatorContext.getText().equals("<=")) {
//				bound1 = termContext.getText();
//			}
//			if (compoperatorContext.getText().equals(">")) {
//				bound2 = "(- " + termContext.getText() + " 1)";
//			}
//			if (compoperatorContext.getText().equals(">=")) {
//				bound2 = termContext.getText();
//			}
//		}
//		if (termContext3.getText().equals(var.getText())) {
//			if (compoperatorContext2.getText().equals("<")) {
//				bound2 = "(- " + termContext4.getText() + " 1)";
//			}
//			if (compoperatorContext2.getText().equals("<=")) {
//				bound2 = termContext4.getText();
//			}
//			if (compoperatorContext2.getText().equals(">")) {
//				bound1 = "(+ " + termContext4.getText() + " 1)";
//			}
//			if (compoperatorContext2.getText().equals(">=")) {
//				bound1 = termContext4.getText();
//			}
//		} else if (termContext4.getText().equals(var.getText())) {
//			if (compoperatorContext2.getText().equals("<")) {
//				bound1 = "(+ " + termContext3.getText() + " 1)";
//			}
//			if (compoperatorContext2.getText().equals("<=")) {
//				bound1 = termContext3.getText();
//			}
//			if (compoperatorContext2.getText().equals(">")) {
//				bound2 = "(- " + termContext3.getText() + " 1)";
//			}
//			if (compoperatorContext2.getText().equals(">=")) {
//				bound2 = termContext3.getText();
//			}
//		}
//
//		String[] ar = { bound1, bound2 };
//		return ar;
//
//	}

	@Override
	public String visitQuantifier(QuantifierContext ctx) {
		String identifier = new String();
		for (TerminalNode n : ctx.IDENTIFIER()) {
			identifier += "(" + n.getText() + " Int)";
		}
		if (ctx.QUANTIFER() != null && ctx.formula().get(0) != null && ctx.QUANTIFER().getText().equals("\\forall")) {

			String ret = MessageFormat.format("(forall ({0}) (=> {1} {2}))", identifier,
					visitFormula(ctx.formula().get(0)), visitFormula(ctx.formula().get(1)));

			return ret;
		} else if (ctx.QUANTIFER() != null && ctx.QUANTIFER().getText().equals("\\forall")) {
			String ret = MessageFormat.format("(forall ({0} ) ({1}))", identifier, visitFormula(ctx.formula().get(1)));

			return ret;
		} else if (ctx.QUANTIFER() != null && ctx.formula().get(0) != null
				&& ctx.QUANTIFER().getText().equals("\\exists")) {

			String ret = MessageFormat.format("(exists ({0}) (=> {1} {2}))", identifier,
					visitFormula(ctx.formula().get(0)), visitFormula(ctx.formula().get(1)));

			return ret;
		} else if (ctx.QUANTIFER() != null && ctx.QUANTIFER().getText().equals("\\exists")) {

			String ret = MessageFormat.format("(exists({0}) ({1}))", identifier, visitFormula(ctx.formula().get(1)));

			return ret;
		}

		return null;
	}

	@Override
	public String visitOperatorformula(OperatorformulaContext ctx) {

		if (ctx.OPERATOR() != null && ctx.term(0) != null && ctx.term(1) != null
				&& ctx.OPERATOR().getText().equals("\\sum")) {

			String rang = "(and(" + "> " + ctx.IDENTIFIER().getText() + " " + ctx.term().get(0).getText() + ")" + "(>= "
					+ ctx.term().get(1).getText() + " " + ctx.IDENTIFIER().getText() + "))";
			String reqdef = "(=($sum" + sumdef.size() + " " + ctx.IDENTIFIER().getText() + ")" + "(+($sum"
					+ sumdef.size() + " (+ " + ctx.IDENTIFIER().getText() + " 1))" + visitFormula(ctx.formula()) + "))";

			String ret = MessageFormat.format("(forall (({0} Int)) (ite {1} {2} {3}))", ctx.IDENTIFIER().getText(),
					rang, reqdef, "(=($sum" + sumdef.size() + " " + ctx.IDENTIFIER().getText() + ")0)");
			String placeholder = "($sum" + sumdef.size() + " " + ctx.term().get(0) + ")";
			sumdef.add(ret);

			return placeholder;
		} else if (ctx.OPERATOR() != null && ctx.term(0) != null && ctx.term(1) != null
				&& ctx.OPERATOR().getText().equals("\\product")) {

			String rang = "(and(" + ">= " + ctx.IDENTIFIER().getText() + " " + ctx.term().get(0).getText() + ")" + "(>= "
					+ ctx.term().get(1).getText() + " " + ctx.IDENTIFIER().getText() + "))";
			String ret = MessageFormat.format("(forall (({0} Int)) (ite {1} {2} {3}))", ctx.IDENTIFIER().getText(),
					rang,
					"(=($product" + productdef.size() + " " + ctx.IDENTIFIER().getText() + ")" + "(*($product"
							+ productdef.size() + " (+ " + ctx.IDENTIFIER().getText() + " 1))"
							+ visitFormula(ctx.formula()) + "))",
					"(=($product" + productdef.size() + " i)1)");
			String placeholder = "($product" + productdef.size() + " " + ctx.term(0).getText() + ")";
			productdef.add(ret);

			return placeholder;
		} else if (ctx.OPERATOR() != null && ctx.term(0) != null && ctx.term(1) != null
				&& ctx.OPERATOR().getText().equals("\\min")) {

			String rang = "(and(" + ">= " + ctx.IDENTIFIER().getText() + " " + ctx.term().get(0).getText() + ")" + "(>= "
					+ ctx.term().get(1).getText() + " " + ctx.IDENTIFIER().getText() + "))";
			String ret = MessageFormat.format("(forall (({0} Int)) (ite {1} {2} {3}))", ctx.IDENTIFIER().getText(),
					rang,
					"(=($min" + mindef.size() + " " + ctx.IDENTIFIER().getText() + ")" + "(ite (<($min" + mindef.size()
							+ " (+ " + ctx.IDENTIFIER().getText() + " 1))" + visitFormula(ctx.formula()) + ")" + "($min"
							+ mindef.size() + " (+ " + ctx.IDENTIFIER().getText() + " 1)" + visitFormula(ctx.formula())
							+ " )",
					"(=($min" + mindef.size() + " i)" + Double.MAX_VALUE + ")");
			String placeholder = "($min" + mindef.size() + " " + ctx.term(0).getText() + ")";
			mindef.add(ret);

			return placeholder;
		} else if (ctx.OPERATOR() != null && ctx.term(0) != null && ctx.term(1) != null
				&& ctx.OPERATOR().getText().equals("\\max")) {

			String rang = "(and(" + ">= " + ctx.IDENTIFIER().getText() + " " + ctx.term().get(0).getText() + ")" + "(>= "
					+ ctx.term().get(1).getText() + " " + ctx.IDENTIFIER().getText() + "))";
			String ret = MessageFormat.format("(forall (({0} Int)) (ite {1} {2} {3}))", ctx.IDENTIFIER().getText(),
					rang,
					"(=($max" + maxdef.size() + " " + ctx.IDENTIFIER().getText() + ")" + "(ite (>($max" + maxdef.size()
							+ " (+ " + ctx.IDENTIFIER().getText() + " 1))" + visitFormula(ctx.formula()) + ")" + "($max"
							+ maxdef.size() + " (+ " + ctx.IDENTIFIER().getText() + " 1)" + visitFormula(ctx.formula())
							+ " )",
					"(=($max" + maxdef.size() + " i)" + Double.MIN_VALUE + ")");
			String placeholder = "($max" + maxdef.size() + " " + ctx.term(0).getText() + ")";
			maxdef.add(ret);

			return placeholder;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitTupelformula(TupelformulaContext ctx) {
		int i = 0;
		String and = "(and(= ";
		String[] funcs = visitFunctioncall(ctx.functioncall(0), ctx.tupel(0).term().size());
		for (TermContext t : ctx.tupel(0).term()) {

			and += "(=" + visitTerm(t) + " " + funcs[i] + ")";
			i++;
		}
		return and;
	}

	@Override
	public String visitTupel(TupelContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] visitFunctioncall(FunctioncallContext ctx, int number) {
		String[] arr = new String[number];
		for (int k = 0; k < number; k++) {

			String ret = "(" + ctx.IDENTIFIER(0) + "." + ctx.IDENTIFIER(1) + k + " ";
			int i[] = { ctx.term().size(), ctx.formula().size() };
			for (int j = 0; j < Arrays.stream(i).max().getAsInt(); j++) {
				if (ctx.term().get(j) != null) {
					ret += visitTerm(ctx.term().get(j)) + " ";
				} else if (ctx.formula().get(j) != null) {
					ret += visitFormula(ctx.formula().get(j)) + " ";
				}
			}
			ret += ")";
			arr[k] = ret;
		}
		return arr;
	}

}
