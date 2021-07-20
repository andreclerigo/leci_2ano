import static java.lang.System.*;
import java.util.*;

public class Interpreter extends ShapesBaseVisitor<Object> {
	@Override public Object visitPrint(ShapesParser.PrintContext ctx) {
      Double v = (Double)visit(ctx.expr());
      out.println(v);
      return null;
   }

	@Override public Object visitAssignment(ShapesParser.AssignmentContext ctx) {
      String id = ctx.Identifier().getText();
      Double v = (Double)visit(ctx.expr());
      symbolTable.put(id, v);
      return null;
   }

	@Override public Object visitExprDistance(ShapesParser.ExprDistanceContext ctx) {
      return visitDistance(ctx.distance());
   }

	@Override public Object visitExprNumber(ShapesParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }

	@Override public Object visitExprIdentifier(ShapesParser.ExprIdentifierContext ctx) {
      Double res = null;
      String id = ctx.Identifier().getText();
      if (!symbolTable.containsKey(id))
         err.println("ERROR: Variable \""+id+"\" not defined!");
      else
         res = symbolTable.get(id);
      return res;
   }

	@Override public Object visitDistance(ShapesParser.DistanceContext ctx) {
      Double[] p1 = (Double[])visitPoint(ctx.p1);
      Double[] p2 = (Double[])visitPoint(ctx.p2);
      return Math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]));
   }

	@Override public Object visitPoint(ShapesParser.PointContext ctx) {
      Double[] res = new Double[2];
      res[0] = (Double)visit(ctx.x);
      res[1] = (Double)visit(ctx.y);
      return res;
   }

   protected Map<String,Double> symbolTable = new HashMap<>();
}
