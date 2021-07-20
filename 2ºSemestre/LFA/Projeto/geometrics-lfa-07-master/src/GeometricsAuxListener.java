// Generated from GeometricsAux.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GeometricsAuxParser}.
 */
public interface GeometricsAuxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GeometricsAuxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GeometricsAuxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsAuxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GeometricsAuxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatShape}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatShape(GeometricsAuxParser.StatShapeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatShape}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatShape(GeometricsAuxParser.StatShapeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatPoint}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatPoint(GeometricsAuxParser.StatPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatPoint}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatPoint(GeometricsAuxParser.StatPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatFig}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatFig(GeometricsAuxParser.StatFigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatFig}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatFig(GeometricsAuxParser.StatFigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatNewline}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatNewline(GeometricsAuxParser.StatNewlineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatNewline}
	 * labeled alternative in {@link GeometricsAuxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatNewline(GeometricsAuxParser.StatNewlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsAuxParser#fig}.
	 * @param ctx the parse tree
	 */
	void enterFig(GeometricsAuxParser.FigContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsAuxParser#fig}.
	 * @param ctx the parse tree
	 */
	void exitFig(GeometricsAuxParser.FigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(GeometricsAuxParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(GeometricsAuxParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(GeometricsAuxParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(GeometricsAuxParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(GeometricsAuxParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(GeometricsAuxParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPlusMinus(GeometricsAuxParser.ExprPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPlusMinus(GeometricsAuxParser.ExprPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(GeometricsAuxParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link GeometricsAuxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(GeometricsAuxParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeLine}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeLine(GeometricsAuxParser.ShapeLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeLine}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeLine(GeometricsAuxParser.ShapeLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeCircle}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeCircle(GeometricsAuxParser.ShapeCircleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeCircle}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeCircle(GeometricsAuxParser.ShapeCircleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeRect}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeRect(GeometricsAuxParser.ShapeRectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeRect}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeRect(GeometricsAuxParser.ShapeRectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeSquare}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeSquare(GeometricsAuxParser.ShapeSquareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeSquare}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeSquare(GeometricsAuxParser.ShapeSquareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeEllipse}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeEllipse(GeometricsAuxParser.ShapeEllipseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeEllipse}
	 * labeled alternative in {@link GeometricsAuxParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeEllipse(GeometricsAuxParser.ShapeEllipseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureColor}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureColor(GeometricsAuxParser.FeatureColorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureColor}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureColor(GeometricsAuxParser.FeatureColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureThick}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureThick(GeometricsAuxParser.FeatureThickContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureThick}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureThick(GeometricsAuxParser.FeatureThickContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureFilled}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureFilled(GeometricsAuxParser.FeatureFilledContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureFilled}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureFilled(GeometricsAuxParser.FeatureFilledContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureHidden}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureHidden(GeometricsAuxParser.FeatureHiddenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureHidden}
	 * labeled alternative in {@link GeometricsAuxParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureHidden(GeometricsAuxParser.FeatureHiddenContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsAuxParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(GeometricsAuxParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsAuxParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(GeometricsAuxParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColorHex}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColorHex(GeometricsAuxParser.ColorHexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColorHex}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColorHex(GeometricsAuxParser.ColorHexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColorRGBA}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColorRGBA(GeometricsAuxParser.ColorRGBAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColorRGBA}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColorRGBA(GeometricsAuxParser.ColorRGBAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColorName}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColorName(GeometricsAuxParser.ColorNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColorName}
	 * labeled alternative in {@link GeometricsAuxParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColorName(GeometricsAuxParser.ColorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsAuxParser#alpha}.
	 * @param ctx the parse tree
	 */
	void enterAlpha(GeometricsAuxParser.AlphaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsAuxParser#alpha}.
	 * @param ctx the parse tree
	 */
	void exitAlpha(GeometricsAuxParser.AlphaContext ctx);
}