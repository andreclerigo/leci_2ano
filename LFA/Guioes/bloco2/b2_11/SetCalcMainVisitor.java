// Generated from SetCalcMain.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SetCalcMainParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SetCalcMainVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SetCalcMainParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SetCalcMainParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link SetCalcMainParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssig(SetCalcMainParser.StatAssigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatExpr}
	 * labeled alternative in {@link SetCalcMainParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatExpr(SetCalcMainParser.StatExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SetCalcMainParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SetCalcMainParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVariables}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVariables(SetCalcMainParser.ExprVariablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprWord}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprWord(SetCalcMainParser.ExprWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentheses(SetCalcMainParser.ExprParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnion}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnion(SetCalcMainParser.ExprUnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDiference}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDiference(SetCalcMainParser.ExprDiferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIntersect}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIntersect(SetCalcMainParser.ExprIntersectContext ctx);
}