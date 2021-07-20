// Generated from Question.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(QuestionParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(QuestionParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(QuestionParser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(QuestionParser.AnswerContext ctx);
}