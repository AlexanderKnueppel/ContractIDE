// Generated from FOLZ3.g4 by ANTLR 4.4
package de.tu_bs.ccc.contracting.grammar.verification;
import org.antlr.v4.runtime.misc.NotNull;
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
	 * Visit a parse tree produced by {@link FOLZ3Parser#compproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompproperty(@NotNull FOLZ3Parser.ComppropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#pred_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_constant(@NotNull FOLZ3Parser.Pred_constantContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#multoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultoperator(@NotNull FOLZ3Parser.MultoperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(@NotNull FOLZ3Parser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#compareformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareformula(@NotNull FOLZ3Parser.CompareformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#summformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummformula(@NotNull FOLZ3Parser.SummformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#powerformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerformula(@NotNull FOLZ3Parser.PowerformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(@NotNull FOLZ3Parser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#faktorformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFaktorformula(@NotNull FOLZ3Parser.FaktorformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#tupel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupel(@NotNull FOLZ3Parser.TupelContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#notterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotterm(@NotNull FOLZ3Parser.NottermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#compoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoperator(@NotNull FOLZ3Parser.CompoperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#portproperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPortproperty(@NotNull FOLZ3Parser.PortpropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull FOLZ3Parser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#connectiveformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectiveformula(@NotNull FOLZ3Parser.ConnectiveformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#tupelformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupelformula(@NotNull FOLZ3Parser.TupelformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull FOLZ3Parser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#port}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort(@NotNull FOLZ3Parser.PortContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#addoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddoperator(@NotNull FOLZ3Parser.AddoperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(@NotNull FOLZ3Parser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#operatorformula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorformula(@NotNull FOLZ3Parser.OperatorformulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull FOLZ3Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLZ3Parser#connectoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectoperator(@NotNull FOLZ3Parser.ConnectoperatorContext ctx);
}