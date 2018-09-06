package de.tu_bs.ccc.contracting.core.grammar;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.ConditionContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.FormulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.NotformulaContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.NottermContext;
import de.tu_bs.ccc.contracting.core.grammar.FOLZ3Parser.OperatorContext;
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
			if (ctx.notformula() != null) {
				return this.visitNotformula(ctx.notformula());
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
	public String visitOperator(OperatorContext ctx) {
		return ctx.getText();
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
	public String visitNotformula(NotformulaContext ctx) {

		if (ctx.NOT() == null) {
			return (this.visitFormula(ctx.formula()));
		} else {
			return ("(" + "not" + this.visitFormula(ctx.formula()) + ")");
		}

	}

	@Override
	public String visitFormula(FormulaContext ctx) {
		if (ctx.LPAREN() == null && ctx.RPAREN() == null) {
			switch (ctx.operator().getText()) {
			case "<<":
				return "(" + "<" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			case ">>":
				return "(" + ">" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			case ">=":
				return "(" + ">=" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			case "<=":
				return "(" + "<=" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			case "=":
				return "(" + "=" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			case "+":
				return "(" + "+" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			case "-":
				return "(" + "-" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";
			case "%":
				return "(" + "mod" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";
			case "/":
				return "(" + "/" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";
			case "*":
				return "(" + "=" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";
			case "&":
				return "(" + "and" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			case "|":
				return "(" + "or" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";
			case "^":
				return "(" + "xor" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";
			case "=>":
				return "(" + "=>" + " " + this.visitNotterm(ctx.notterm(0)) + " " + this.visitNotterm(ctx.notterm(1))
						+ ")";

			}

			return "(" + this.visitOperator(ctx.operator()) + " " + this.visitNotterm(ctx.notterm(0)) + " "
					+ this.visitNotterm(ctx.notterm(1)) + ")";

		} else {
			return this.visitFormula(ctx.formula());
		}
	}

	@Override
	public String visitCondition(ConditionContext ctx) {
		// TODO Auto-generated method stub
		return visitNotformula(ctx.notformula());
	}

};
