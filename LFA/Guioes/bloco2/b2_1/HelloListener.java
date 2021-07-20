// Generated from Hello.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HelloParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HelloParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void enterGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void exitGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#bye}.
	 * @param ctx the parse tree
	 */
	void enterBye(HelloParser.ByeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#bye}.
	 * @param ctx the parse tree
	 */
	void exitBye(HelloParser.ByeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(HelloParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(HelloParser.NameContext ctx);
}