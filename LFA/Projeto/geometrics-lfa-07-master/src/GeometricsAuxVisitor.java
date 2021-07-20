// Generated from GeometricsAux.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GeometricsAuxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GeometricsAuxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GeometricsAuxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GeometricsAuxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatShape}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatShape(GeometricsAuxParser.StatShapeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatPoint}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatPoint(GeometricsAuxParser.StatPointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatFig}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatFig(GeometricsAuxParser.StatFigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatNewline}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatNewline(GeometricsAuxParser.StatNewlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsAuxParser#fig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFig(GeometricsAuxParser.FigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(GeometricsAuxParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(GeometricsAuxParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(GeometricsAuxParser.ExprNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPlusMinus(GeometricsAuxParser.ExprPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDivMod(GeometricsAuxParser.ExprMultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeLine}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeLine(GeometricsAuxParser.ShapeLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeCircle}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeCircle(GeometricsAuxParser.ShapeCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeRect}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeRect(GeometricsAuxParser.ShapeRectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeSquare}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeSquare(GeometricsAuxParser.ShapeSquareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeEllipse}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeEllipse(GeometricsAuxParser.ShapeEllipseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureColor}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureColor(GeometricsAuxParser.FeatureColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureThick}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureThick(GeometricsAuxParser.FeatureThickContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureFilled}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureFilled(GeometricsAuxParser.FeatureFilledContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureHidden}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureHidden(GeometricsAuxParser.FeatureHiddenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsAuxParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(GeometricsAuxParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ColorHex}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorHex(GeometricsAuxParser.ColorHexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ColorRGBA}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorRGBA(GeometricsAuxParser.ColorRGBAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ColorName}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorName(GeometricsAuxParser.ColorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsAuxParser#alpha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlpha(GeometricsAuxParser.AlphaContext ctx);
}