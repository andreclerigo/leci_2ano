import static java.lang.System.*;
import java.util.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class Interpreter extends ShapesBaseListener {
	@Override public void exitPrint(ShapesParser.PrintContext ctx) {
      out.println(realValues.get(ctx.expr()));
   }

	@Override public void exitAssignment(ShapesParser.AssignmentContext ctx) {
      String id = ctx.Identifier().getText();
      symbolTable.put(id, realValues.get(ctx.expr()));
   }

	@Override public void exitExprDistance(ShapesParser.ExprDistanceContext ctx) {
      realValues.put(ctx, realValues.get(ctx.distance()));
   }

	@Override public void exitExprNumber(ShapesParser.ExprNumberContext ctx) {
      realValues.put(ctx, Double.parseDouble(ctx.Number().getText()));
   }

	@Override public void exitExprIdentifier(ShapesParser.ExprIdentifierContext ctx) {
      String id = ctx.Identifier().getText();
      if (!symbolTable.containsKey(id))
         err.println("ERROR: Variable \""+id+"\" not defined!");
      else
         realValues.put(ctx, symbolTable.get(id));
   }

	@Override public void exitDistance(ShapesParser.DistanceContext ctx) {
      Double[] p1 = pointValues.get(ctx.p1);
      Double[] p2 = pointValues.get(ctx.p2);
      realValues.put(ctx, Math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1])));
   }

	@Override public void exitPoint(ShapesParser.PointContext ctx) {
      Double[] p = new Double[2];
      p[0] = realValues.get(ctx.x);
      p[1] = realValues.get(ctx.y);
      pointValues.put(ctx, p);
   }

   protected Map<String,Double> symbolTable = new HashMap<>();
   protected ParseTreeProperty<Double> realValues = new ParseTreeProperty<>();
   protected ParseTreeProperty<Double[]> pointValues = new ParseTreeProperty<>();
}
