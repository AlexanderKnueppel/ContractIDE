// Generated from C:/Users/Markus/OneDrive/Bachelor-Arbeitwc/Project/ContractModelling/src/contractmodelling/grammar/FOLZ3.g4 by ANTLR 4.7

	package de.tu_bs.ccc.contracting.core.grammar;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FOLZ3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FOLZ3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(FOLZ3Parser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#notformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotformula(FOLZ3Parser.NotformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(FOLZ3Parser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#notterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotterm(FOLZ3Parser.NottermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(FOLZ3Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(FOLZ3Parser.OperatorContext ctx);
}