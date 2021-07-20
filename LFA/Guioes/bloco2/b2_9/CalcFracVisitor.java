// Generated from CalcFrac.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcFracParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcFracVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalcFracParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CalcFracParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssig(CalcFracParser.StatAssigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statprint}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatprint(CalcFracParser.StatprintContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcFracParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(CalcFracParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcFracParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(CalcFracParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(CalcFracParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(CalcFracParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDiv(CalcFracParser.ExprMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPlusMinus(CalcFracParser.ExprPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprReduce(CalcFracParser.ExprReduceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(CalcFracParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Frac}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrac(CalcFracParser.FracContext ctx);
}