// Generated from C:/Users/Markus/OneDrive/Bachelor-Arbeitwc/Project/ContractModelling/src/contractmodelling/grammar/FOLZ3.g4 by ANTLR 4.7

	package de.tu_bs.ccc.contracting.core.grammar;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FOLZ3Parser}.
 */
public interface FOLZ3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(FOLZ3Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(FOLZ3Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#notformula}.
	 * @param ctx the parse tree
	 */
	void enterNotformula(FOLZ3Parser.NotformulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#notformula}.
	 * @param ctx the parse tree
	 */
	void exitNotformula(FOLZ3Parser.NotformulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(FOLZ3Parser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(FOLZ3Parser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#notterm}.
	 * @param ctx the parse tree
	 */
	void enterNotterm(FOLZ3Parser.NottermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#notterm}.
	 * @param ctx the parse tree
	 */
	void exitNotterm(FOLZ3Parser.NottermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(FOLZ3Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(FOLZ3Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(FOLZ3Parser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(FOLZ3Parser.OperatorContext ctx);
}