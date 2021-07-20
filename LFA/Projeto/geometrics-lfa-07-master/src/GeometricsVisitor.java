// Generated from Geometrics.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GeometricsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GeometricsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GeometricsParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssig(GeometricsParser.StatAssigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAdd}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAdd(GeometricsParser.StatAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatRemove}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatRemove(GeometricsParser.StatRemoveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAux}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAux(GeometricsParser.StatAuxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatNewline}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatNewline(GeometricsParser.StatNewlineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnimStatTranslate}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnimStatTranslate(GeometricsParser.AnimStatTranslateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnimStatRotate}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnimStatRotate(GeometricsParser.AnimStatRotateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnimStatWaitms}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnimStatWaitms(GeometricsParser.AnimStatWaitmsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#aux}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAux(GeometricsParser.AuxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssigShape}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigShape(GeometricsParser.AssigShapeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssigPoint}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigPoint(GeometricsParser.AssigPointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssigAnimation}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigAnimation(GeometricsParser.AssigAnimationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssigFigure}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigFigure(GeometricsParser.AssigFigureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssigExpr}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(GeometricsParser.AssigExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(GeometricsParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(GeometricsParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(GeometricsParser.ExprNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPlusMinus(GeometricsParser.ExprPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(GeometricsParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDivMod(GeometricsParser.ExprMultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddShape}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddShape(GeometricsParser.AddShapeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddPoint}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddPoint(GeometricsParser.AddPointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddFigure}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddFigure(GeometricsParser.AddFigureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddAnim}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddAnim(GeometricsParser.AddAnimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddFeature}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddFeature(GeometricsParser.AddFeatureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddNumber}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddNumber(GeometricsParser.AddNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddID}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddID(GeometricsParser.AddIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#remove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemove(GeometricsParser.RemoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#translate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslate(GeometricsParser.TranslateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#rotate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotate(GeometricsParser.RotateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#fig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFig(GeometricsParser.FigContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#anim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnim(GeometricsParser.AnimContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#tick}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTick(GeometricsParser.TickContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(GeometricsParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#waitms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitms(GeometricsParser.WaitmsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeLine}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeLine(GeometricsParser.ShapeLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeCircle}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeCircle(GeometricsParser.ShapeCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeRect}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeRect(GeometricsParser.ShapeRectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeSquare}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeSquare(GeometricsParser.ShapeSquareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShapeEllipse}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeEllipse(GeometricsParser.ShapeEllipseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureColor}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureColor(GeometricsParser.FeatureColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureThick}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureThick(GeometricsParser.FeatureThickContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureFilled}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureFilled(GeometricsParser.FeatureFilledContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FeatureHidden}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureHidden(GeometricsParser.FeatureHiddenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(GeometricsParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ColorHex}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorHex(GeometricsParser.ColorHexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ColorRGBA}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorRGBA(GeometricsParser.ColorRGBAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ColorName}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorName(GeometricsParser.ColorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometricsParser#alpha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlpha(GeometricsParser.AlphaContext ctx);
}