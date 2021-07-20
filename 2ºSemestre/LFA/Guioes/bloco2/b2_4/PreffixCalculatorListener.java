// Generated from PreffixCalculator.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PreffixCalculatorParser}.
 */
public interface PreffixCalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PreffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PreffixCalculatorParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PreffixCalculatorParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(PreffixCalculatorParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(PreffixCalculatorParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPreffix}
	 * labeled alternative in {@link PreffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPreffix(PreffixCalculatorParser.ExprPreffixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPreffix}
	 * labeled alternative in {@link PreffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPreffix(PreffixCalculatorParser.ExprPreffixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link PreffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(PreffixCalculatorParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link PreffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(PreffixCalculatorParser.ExprNumberContext ctx);
}