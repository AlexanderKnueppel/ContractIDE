// Generated from FOLZ3.g4 by ANTLR 4.4

	package contractmodelling.grammar;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FOLZ3Parser}.
 */
public interface FOLZ3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#notformula}.
	 * @param ctx the parse tree
	 */
	void enterNotformula(@NotNull FOLZ3Parser.NotformulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#notformula}.
	 * @param ctx the parse tree
	 */
	void exitNotformula(@NotNull FOLZ3Parser.NotformulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull FOLZ3Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull FOLZ3Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(@NotNull FOLZ3Parser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(@NotNull FOLZ3Parser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull FOLZ3Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull FOLZ3Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(@NotNull FOLZ3Parser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(@NotNull FOLZ3Parser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLZ3Parser#notterm}.
	 * @param ctx the parse tree
	 */
	void enterNotterm(@NotNull FOLZ3Parser.NottermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLZ3Parser#notterm}.
	 * @param ctx the parse tree
	 */
	void exitNotterm(@NotNull FOLZ3Parser.NottermContext ctx);
}