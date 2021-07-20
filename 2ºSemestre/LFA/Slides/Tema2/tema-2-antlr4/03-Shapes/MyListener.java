import static java.lang.System.*;

public class MyListener extends ShapesBaseListener {

   protected static final boolean traceCallbacks = false;

   @Override public void enterMain(ShapesParser.MainContext ctx) {
      out.println("--- MyListener ---");
      if(traceCallbacks)
         out.println("enterMain");
      else
         out.println("trace off");
   }
   @Override public void exitMain(ShapesParser.MainContext ctx) {
      if(traceCallbacks)
         out.println("exitMain");
      out.println("--- end ---\n");
   }
   @Override public void enterStat(ShapesParser.StatContext ctx) {
      if(traceCallbacks)
         out.println("enterStat");
   }
   @Override public void exitStat(ShapesParser.StatContext ctx) {
      if(traceCallbacks)
         out.println("exitStat");
   }
   @Override public void enterDistance(ShapesParser.DistanceContext ctx) {
      if(traceCallbacks)
         out.println("enterDistance");
   }
   @Override public void exitDistance(ShapesParser.DistanceContext ctx) {
      if(traceCallbacks)
         out.println("exitDistance");
   }
   @Override public void enterPoint(ShapesParser.PointContext ctx) {
      if(traceCallbacks)
         out.println("enterPoint");
   }
   @Override public void exitPoint(ShapesParser.PointContext ctx) {
      if(traceCallbacks)
         out.println("exitPoint");
   }
   @Override public void enterExpr(ShapesParser.ExprContext ctx) {
      if(traceCallbacks)
         out.println("enterExpr");
   }
   @Override public void exitExpr(ShapesParser.ExprContext ctx) {
      if(traceCallbacks)
         out.println("exitExpr");
   }
   @Override public void enterAssignment(ShapesParser.AssignmentContext ctx) {
      if(traceCallbacks)
         out.println("enterAssignment");
   }
   @Override public void exitAssignment(ShapesParser.AssignmentContext ctx) {
      if(traceCallbacks)
         out.println("exitAssignment");
   }
}
