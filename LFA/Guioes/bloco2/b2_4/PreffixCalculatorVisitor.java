// Generated from PreffixCalculator.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PreffixCalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PreffixCalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PreffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PreffixCalculatorParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PreffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(PreffixCalculatorParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPreffix}
	 * labeled alternative in {@link PreffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPreffix(PreffixCalculatorParser.ExprPreffixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link PreffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(PreffixCalculatorParser.ExprNumberContext ctx);
}