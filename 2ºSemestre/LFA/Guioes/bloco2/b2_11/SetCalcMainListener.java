// Generated from SetCalcMain.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SetCalcMainParser}.
 */
public interface SetCalcMainListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SetCalcMainParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SetCalcMainParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SetCalcMainParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SetCalcMainParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link SetCalcMainParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssig(SetCalcMainParser.StatAssigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link SetCalcMainParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssig(SetCalcMainParser.StatAssigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatExpr}
	 * labeled alternative in {@link SetCalcMainParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatExpr(SetCalcMainParser.StatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatExpr}
	 * labeled alternative in {@link SetCalcMainParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatExpr(SetCalcMainParser.StatExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SetCalcMainParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SetCalcMainParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SetCalcMainParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SetCalcMainParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVariables}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprVariables(SetCalcMainParser.ExprVariablesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVariables}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprVariables(SetCalcMainParser.ExprVariablesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprWord}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprWord(SetCalcMainParser.ExprWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprWord}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprWord(SetCalcMainParser.ExprWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParentheses(SetCalcMainParser.ExprParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParentheses}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParentheses(SetCalcMainParser.ExprParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnion}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnion(SetCalcMainParser.ExprUnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnion}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnion(SetCalcMainParser.ExprUnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDiference}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDiference(SetCalcMainParser.ExprDiferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDiference}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDiference(SetCalcMainParser.ExprDiferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIntersect}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIntersect(SetCalcMainParser.ExprIntersectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIntersect}
	 * labeled alternative in {@link SetCalcMainParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIntersect(SetCalcMainParser.ExprIntersectContext ctx);
}