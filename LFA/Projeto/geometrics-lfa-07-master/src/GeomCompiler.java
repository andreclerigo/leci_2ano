import org.stringtemplate.v4.*;
import java.util.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

public class GeomCompiler extends GeometricsBaseVisitor<ST> {

   @Override public ST visitProgram(GeometricsParser.ProgramContext ctx) {
      
      templates = new STGroupFile("python.stg");
      ST res = templates.getInstanceOf("module");
      Iterator<GeometricsParser.StatContext> list = ctx.stat().iterator();
      while (list.hasNext()) {
         res.add("stat", visit(list.next()).render());
      }
      return res;
   }

   @Override public ST visitStatAux(GeometricsParser.StatAuxContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAux(GeometricsParser.AuxContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitStatAssig(GeometricsParser.StatAssigContext ctx) {
      ST res = templates.getInstanceOf("assign");
      res.add("stat", visit(ctx.assig()).render());
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.assig().var);
      return res;
   }

   @Override public ST visitStatAdd(GeometricsParser.StatAddContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitStatRemove(GeometricsParser.StatRemoveContext ctx) {
      return visitChildren(ctx);
   }
  
   @Override public ST visitStatNewline(GeometricsParser.StatNewlineContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAnimStatTranslate(GeometricsParser.AnimStatTranslateContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAnimStatRotate(GeometricsParser.AnimStatRotateContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAnimStatWaitms(GeometricsParser.AnimStatWaitmsContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAssigShape(GeometricsParser.AssigShapeContext ctx) {
      ST res = templates.getInstanceOf("shape");
      res.add("stat",visit(ctx.shape()).render());
      ctx.var  = newVar();
      res.add("var", ctx.var);
      res.add("stat", ctx.shape().var);
      return res;
   }

   @Override public ST visitAssigPoint(GeometricsParser.AssigPointContext ctx) {
      ST res = templates.getInstanceOf("assign");
      res.add("stat", visit(ctx.point()).render());
      res.add("var", "v_"+ctx.ID().getText());
      res.add("value", ctx.point().var);
      return res;
   }

   @Override public ST visitAssigAnimation(GeometricsParser.AssigAnimationContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAssigFigure(GeometricsParser.AssigFigureContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAssigExpr(GeometricsParser.AssigExprContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprAddSub(GeometricsParser.ExprAddSubContext ctx) {
      ctx.var = newVar();
      return binaryExpression(ctx, visit(ctx.expr(0)).render(), visit(ctx.expr(1)).render(), ctx.var, ctx.expr(0).var, ctx.op.getText(), ctx.expr(1).var);

   }

   @Override public ST visitExprParent(GeometricsParser.ExprParentContext ctx) {
      ST res = visit(ctx.expr());
      ctx.var = ctx.expr().var;
      return res;
   }

   @Override public ST visitExprNumber(GeometricsParser.ExprNumberContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.Number().getText());
      return res;

   }

   @Override public ST visitExprPlusMinus(GeometricsParser.ExprPlusMinusContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.expr()).render());
      ST decl = templates.getInstanceOf("decl");
      ctx.var = newVar();
      decl.add("var", ctx.var);
      decl.add("value", ctx.op.getText()+ctx.expr().var);
      res.add("stat", decl.render());
      return res;
   }

   @Override public ST visitExprID(GeometricsParser.ExprIDContext ctx) {
      /*ST res =templates.getInstanceOf("stats");
      ST decl =templates.getInstanceOf("decl");
      String id  = ctx.ID().getText();
      ctx.var = newVar();
      decl.add("var", ctx.var);
      decl.add("value", GeometricsParser.symbolTable.get(id).var());
      res.add("stat", decl.render());
      return res;*/
      return visitChildren(ctx);
   }

   @Override public ST visitExprMultDivMod(GeometricsParser.ExprMultDivModContext ctx) {
      ctx.var = newVar();
      return binaryExpression(ctx,visit(ctx.expr(0)).render(), visit(ctx.expr(1)).render(), ctx.var, ctx.expr(0).var, ctx.op.getText(), ctx.expr(1).var);
   }

   @Override public ST visitAddShape(GeometricsParser.AddShapeContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAddPoint(GeometricsParser.AddPointContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAddFigure(GeometricsParser.AddFigureContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAddAnim(GeometricsParser.AddAnimContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAddFeature(GeometricsParser.AddFeatureContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAddNumber(GeometricsParser.AddNumberContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAddID(GeometricsParser.AddIDContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitRemove(GeometricsParser.RemoveContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitTranslate(GeometricsParser.TranslateContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitRotate(GeometricsParser.RotateContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitFig(GeometricsParser.FigContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAnim(GeometricsParser.AnimContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitWaitms(GeometricsParser.WaitmsContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitLoop(GeometricsParser.LoopContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitTick(GeometricsParser.TickContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitShapeLine(GeometricsParser.ShapeLineContext ctx) {
      ST res = templates.getInstanceOf("line");
      res.add("stat", visit(ctx.point(0)).render());
      res.add("stat", visit(ctx.point(1)).render());
      res.add("var", "v_"+ctx.ID(0).getText());
      res.add("point1", ctx.point(0).var);
      res.add("point2", ctx.point(1).var);
      return res;
   }
  
   @Override public ST visitShapeCircle(GeometricsParser.ShapeCircleContext ctx) {
      ST res = templates.getInstanceOf("circle");
      res.add("stat", visit(ctx.point()).render());
      res.add("stat", visit(ctx.radius).render());
      res.add("var", "v_"+ctx.ID(0).getText());
      res.add("center", ctx.point().var);
      res.add("radius", ctx.radius.var);
      
      return res;
   }

   @Override public ST visitShapeRect(GeometricsParser.ShapeRectContext ctx) {
      ST res = templates.getInstanceOf("rect");
      res.add("stat", visit(ctx.point()).render());
      res.add("stat", visit(ctx.expr(0)).render());
      res.add("stat", visit(ctx.expr(1)).render());
      res.add("var", "v_"+ctx.ID(0).getText());
      res.add("center", ctx.point().var);
      res.add("height", ctx.expr(0).var);
      res.add("width", ctx.expr(1).var);

      return res;
   }

   @Override public ST visitShapeSquare(GeometricsParser.ShapeSquareContext ctx) {
      ST res = templates.getInstanceOf("rect");
      res.add("stat", visit(ctx.point()).render());
      res.add("stat", visit(ctx.expr()).render());
      res.add("var", "v_"+ctx.ID(0).getText());
      res.add("center", ctx.point().var);
      res.add("height", ctx.expr().var);
      res.add("width", ctx.expr().var);

      return res;
   }

   @Override public ST visitShapeEllipse(GeometricsParser.ShapeEllipseContext ctx) {
      ST res = templates.getInstanceOf("ellipse");
      res.add("stat", visit(ctx.point()).render());
      res.add("stat", visit(ctx.a).render());
      res.add("stat", visit(ctx.b).render());
      res.add("var", "v_"+ctx.ID(0).getText());
      res.add("center", ctx.point().var);
      res.add("a", ctx.a.var);
      res.add("b", ctx.b.var);

      return res;
   }

   @Override public ST visitFeatureColor(GeometricsParser.FeatureColorContext ctx) {
      ST res = templates.getInstanceOf("assign");
      res.add("stat", visit(ctx.color()).render());
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.color().getText());
      
      return res;
   }

   @Override public ST visitFeatureThick(GeometricsParser.FeatureThickContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.Number().getText());
      
      return res;
   }

   @Override public ST visitFeatureFilled(GeometricsParser.FeatureFilledContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.op.getText());

      return res;
   }

   @Override public ST visitFeatureHidden(GeometricsParser.FeatureHiddenContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.op.getText());

      return res;
   }

   @Override public ST visitPoint(GeometricsParser.PointContext ctx) {
      ST res = templates.getInstanceOf("point");
      ST st0 = visit(ctx.expr(0));
      ST st1 = visit(ctx.expr(1));
      res.add("stat", st0.render());
      res.add("stat", st1.render());
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("coord1", ctx.expr(0).var);
      res.add("coord2", ctx.expr(1).var);
      return res;
   }

   @Override public ST visitColorHex(GeometricsParser.ColorHexContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.HTMLColor().getText());

      return res;
   }

   @Override public ST visitColorRGBA(GeometricsParser.ColorRGBAContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.red.getText() + "," + ctx.green.getText() + "," + ctx.blue.getText());
      // FINISH -> Alpha?
      
      return res;
   }

   @Override public ST visitColorName(GeometricsParser.ColorNameContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ctx.var = newVar();
      res.add("var", ctx.var);
      res.add("value", ctx.getText());
      // FINISH -> Opacity%?
      
      return res;
   }

   @Override public ST visitAlpha(GeometricsParser.AlphaContext ctx) {
      return visitChildren(ctx);
   }

   protected ST binaryExpression(ParserRuleContext ctx, String e1Stats, String e2Stats, String e1Var, String var, String  op, String e2Var) {
      ST res = templates.getInstanceOf("binaryExpression");
      res.add("stat", e1Stats);
      res.add("stat", e2Stats);
      res.add("var", var);
      res.add("e1", e1Var);
      res.add("op",translateOp(op));
      res.add("e2", e2Var);
      return res;
   }

   protected String translateOp(String op) {
      String res = op;
      if(op == "/") res = "//";       
      return res;
   }

   private String newVar() {
      numVars++;
      return "v"+numVars;
   }
   private int numVars = 0;
   protected STGroup templates = null;
   
}
