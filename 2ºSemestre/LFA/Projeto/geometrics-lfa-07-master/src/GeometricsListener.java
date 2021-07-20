// Generated from Geometrics.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GeometricsParser}.
 */
public interface GeometricsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GeometricsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GeometricsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssig(GeometricsParser.StatAssigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssig(GeometricsParser.StatAssigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAdd}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAdd(GeometricsParser.StatAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAdd}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAdd(GeometricsParser.StatAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatRemove}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatRemove(GeometricsParser.StatRemoveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatRemove}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatRemove(GeometricsParser.StatRemoveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAux}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAux(GeometricsParser.StatAuxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAux}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAux(GeometricsParser.StatAuxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatNewline}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatNewline(GeometricsParser.StatNewlineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatNewline}
	 * labeled alternative in {@link GeometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatNewline(GeometricsParser.StatNewlineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnimStatTranslate}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 */
	void enterAnimStatTranslate(GeometricsParser.AnimStatTranslateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnimStatTranslate}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 */
	void exitAnimStatTranslate(GeometricsParser.AnimStatTranslateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnimStatRotate}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 */
	void enterAnimStatRotate(GeometricsParser.AnimStatRotateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnimStatRotate}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 */
	void exitAnimStatRotate(GeometricsParser.AnimStatRotateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnimStatWaitms}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 */
	void enterAnimStatWaitms(GeometricsParser.AnimStatWaitmsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnimStatWaitms}
	 * labeled alternative in {@link GeometricsParser#animStat}.
	 * @param ctx the parse tree
	 */
	void exitAnimStatWaitms(GeometricsParser.AnimStatWaitmsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#aux}.
	 * @param ctx the parse tree
	 */
	void enterAux(GeometricsParser.AuxContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#aux}.
	 * @param ctx the parse tree
	 */
	void exitAux(GeometricsParser.AuxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssigShape}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void enterAssigShape(GeometricsParser.AssigShapeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssigShape}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void exitAssigShape(GeometricsParser.AssigShapeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssigPoint}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void enterAssigPoint(GeometricsParser.AssigPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssigPoint}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void exitAssigPoint(GeometricsParser.AssigPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssigAnimation}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void enterAssigAnimation(GeometricsParser.AssigAnimationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssigAnimation}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void exitAssigAnimation(GeometricsParser.AssigAnimationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssigFigure}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void enterAssigFigure(GeometricsParser.AssigFigureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssigFigure}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void exitAssigFigure(GeometricsParser.AssigFigureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssigExpr}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void enterAssigExpr(GeometricsParser.AssigExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssigExpr}
	 * labeled alternative in {@link GeometricsParser#assig}.
	 * @param ctx the parse tree
	 */
	void exitAssigExpr(GeometricsParser.AssigExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(GeometricsParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(GeometricsParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(GeometricsParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(GeometricsParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(GeometricsParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(GeometricsParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPlusMinus(GeometricsParser.ExprPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPlusMinus(GeometricsParser.ExprPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(GeometricsParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(GeometricsParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(GeometricsParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link GeometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(GeometricsParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddShape}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddShape(GeometricsParser.AddShapeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddShape}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddShape(GeometricsParser.AddShapeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddPoint}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddPoint(GeometricsParser.AddPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddPoint}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddPoint(GeometricsParser.AddPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddFigure}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddFigure(GeometricsParser.AddFigureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddFigure}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddFigure(GeometricsParser.AddFigureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddAnim}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddAnim(GeometricsParser.AddAnimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddAnim}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddAnim(GeometricsParser.AddAnimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddFeature}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddFeature(GeometricsParser.AddFeatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddFeature}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddFeature(GeometricsParser.AddFeatureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddNumber}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddNumber(GeometricsParser.AddNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddNumber}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddNumber(GeometricsParser.AddNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddID}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddID(GeometricsParser.AddIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddID}
	 * labeled alternative in {@link GeometricsParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddID(GeometricsParser.AddIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#remove}.
	 * @param ctx the parse tree
	 */
	void enterRemove(GeometricsParser.RemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#remove}.
	 * @param ctx the parse tree
	 */
	void exitRemove(GeometricsParser.RemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#translate}.
	 * @param ctx the parse tree
	 */
	void enterTranslate(GeometricsParser.TranslateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#translate}.
	 * @param ctx the parse tree
	 */
	void exitTranslate(GeometricsParser.TranslateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#rotate}.
	 * @param ctx the parse tree
	 */
	void enterRotate(GeometricsParser.RotateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#rotate}.
	 * @param ctx the parse tree
	 */
	void exitRotate(GeometricsParser.RotateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#fig}.
	 * @param ctx the parse tree
	 */
	void enterFig(GeometricsParser.FigContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#fig}.
	 * @param ctx the parse tree
	 */
	void exitFig(GeometricsParser.FigContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#anim}.
	 * @param ctx the parse tree
	 */
	void enterAnim(GeometricsParser.AnimContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#anim}.
	 * @param ctx the parse tree
	 */
	void exitAnim(GeometricsParser.AnimContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#tick}.
	 * @param ctx the parse tree
	 */
	void enterTick(GeometricsParser.TickContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#tick}.
	 * @param ctx the parse tree
	 */
	void exitTick(GeometricsParser.TickContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(GeometricsParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(GeometricsParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#waitms}.
	 * @param ctx the parse tree
	 */
	void enterWaitms(GeometricsParser.WaitmsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#waitms}.
	 * @param ctx the parse tree
	 */
	void exitWaitms(GeometricsParser.WaitmsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeLine}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeLine(GeometricsParser.ShapeLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeLine}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeLine(GeometricsParser.ShapeLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeCircle}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeCircle(GeometricsParser.ShapeCircleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeCircle}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeCircle(GeometricsParser.ShapeCircleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeRect}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeRect(GeometricsParser.ShapeRectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeRect}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeRect(GeometricsParser.ShapeRectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeSquare}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeSquare(GeometricsParser.ShapeSquareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeSquare}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeSquare(GeometricsParser.ShapeSquareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShapeEllipse}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShapeEllipse(GeometricsParser.ShapeEllipseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShapeEllipse}
	 * labeled alternative in {@link GeometricsParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShapeEllipse(GeometricsParser.ShapeEllipseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureColor}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureColor(GeometricsParser.FeatureColorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureColor}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureColor(GeometricsParser.FeatureColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureThick}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureThick(GeometricsParser.FeatureThickContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureThick}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureThick(GeometricsParser.FeatureThickContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureFilled}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureFilled(GeometricsParser.FeatureFilledContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureFilled}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureFilled(GeometricsParser.FeatureFilledContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FeatureHidden}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeatureHidden(GeometricsParser.FeatureHiddenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FeatureHidden}
	 * labeled alternative in {@link GeometricsParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeatureHidden(GeometricsParser.FeatureHiddenContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(GeometricsParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(GeometricsParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColorHex}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColorHex(GeometricsParser.ColorHexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColorHex}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColorHex(GeometricsParser.ColorHexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColorRGBA}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColorRGBA(GeometricsParser.ColorRGBAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColorRGBA}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColorRGBA(GeometricsParser.ColorRGBAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColorName}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColorName(GeometricsParser.ColorNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColorName}
	 * labeled alternative in {@link GeometricsParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColorName(GeometricsParser.ColorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometricsParser#alpha}.
	 * @param ctx the parse tree
	 */
	void enterAlpha(GeometricsParser.AlphaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometricsParser#alpha}.
	 * @param ctx the parse tree
	 */
	void exitAlpha(GeometricsParser.AlphaContext ctx);
}