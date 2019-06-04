package de.tu_bs.ccc.contracting.core.verification.grammar;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.AddoperatorContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.CompareformulaContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.CompoperatorContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.ConditionContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.ConnectiveformulaContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.ConnectoperatorContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.FaktorformulaContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.FormulaContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.MultoperatorContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.NottermContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.PowerformulaContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.Pred_constantContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.SummformulaContext;
import de.tu_bs.ccc.contracting.core.verification.grammar.FOLZ3Parser.TermContext;

public class ConsistencyChecker implements FOLZ3Visitor<String> {

	@Override
	public String visit(ParseTree arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitChildren(RuleNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitCondition(ConditionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitFormula(FormulaContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitConnectiveformula(ConnectiveformulaContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitCompareformula(CompareformulaContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitSummformula(SummformulaContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitFaktorformula(FaktorformulaContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPowerformula(PowerformulaContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitNotterm(NottermContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitTerm(TermContext ctx) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPred_constant(Pred_constantContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}


}
