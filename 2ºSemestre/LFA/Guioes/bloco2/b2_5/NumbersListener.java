// Generated from Numbers.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NumbersParser}.
 */
public interface NumbersListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NumbersParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(NumbersParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumbersParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(NumbersParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumbersParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(NumbersParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumbersParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(NumbersParser.LineContext ctx);
}