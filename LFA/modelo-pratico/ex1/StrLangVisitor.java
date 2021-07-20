// Generated from StrLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StrLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StrLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StrLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(StrLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssig(StrLangParser.StatAssigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatPrint}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatPrint(StrLangParser.StatPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrLangParser#assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssig(StrLangParser.AssigContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrLangParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(StrLangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprReplace}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprReplace(StrLangParser.ExprReplaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprString(StrLangParser.ExprStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(StrLangParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSub(StrLangParser.ExprSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInput}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInput(StrLangParser.ExprInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTrim}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTrim(StrLangParser.ExprTrimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(StrLangParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(StrLangParser.ExprAddContext ctx);
}