package de.tu_bs.ccc.contracting.core.grammar;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.AddoperatorContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.CompareformulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.CompoperatorContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.ConditionContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.ConnectiveformulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.ConnectoperatorContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.FaktorformulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.FormulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.MultoperatorContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.NottermContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.PowerformulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.Pred_constantContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.SummformulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.TermContext;

public class FOLZ3VisitorImpl implements FOLZ3Visitor<String> {

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
			if (ctx.formula()!= null) {
				return this.visitFormula(ctx.formula());
			} else {
				return this.visitTerm(ctx.term());
			}

		}
		if (ctx.VARIABLE() != null) {
			if (ctx.VARIABLE().getText().equals("TRUE"))
				return "true";
			if (ctx.VARIABLE().getText().equals("FALSE"))
				return "false";
			return ctx.VARIABLE().getText();

		}

		if (ctx.STRING() != null) {
			return ctx.STRING().getText();

		}
		return null;
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

				case "&":
					ret += "(" + "and" + " ";
					break;

				case "|":
					ret += "(" + "or" + " ";
					break;
				case "^":
					ret += "(" + "xor" + " ";
					break;
				case "->":
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

				case "=":
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


};
