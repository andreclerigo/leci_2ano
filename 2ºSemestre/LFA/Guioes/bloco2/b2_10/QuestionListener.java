// Generated from Question.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionParser}.
 */
public interface QuestionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(QuestionParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(QuestionParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(QuestionParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(QuestionParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(QuestionParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(QuestionParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(QuestionParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(QuestionParser.AnswerContext ctx);
}