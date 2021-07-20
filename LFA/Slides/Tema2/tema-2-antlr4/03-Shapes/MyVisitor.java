import static java.lang.System.*;

public class MyVisitor extends ShapesBaseVisitor<Object> {
   protected static final boolean traceCallbacks = true;

	@Override public Object visitMain(ShapesParser.MainContext ctx) {
      out.println("--- MyVisitor ---");
      if(traceCallbacks)
         out.println("visitMain");
      else
         out.println("trace off");
      Object res = visitChildren(ctx);
      out.println("--- end ---");
      return res;
   }
	@Override public Object visitStat(ShapesParser.StatContext ctx) {
      if(traceCallbacks)
         out.println("visitStat");
      return visitChildren(ctx);
   }
	@Override public Object visitDistance(ShapesParser.DistanceContext ctx) {
      if(traceCallbacks)
         out.println("visitDistance");
      return visitChildren(ctx);
   }
	@Override public Object visitPoint(ShapesParser.PointContext ctx) {
      if(traceCallbacks)
         out.println("visitPoint");
      return visitChildren(ctx);
   }
	@Override public Object visitExpr(ShapesParser.ExprContext ctx) {
      if(traceCallbacks)
         out.println("visitExpr");
      return visitChildren(ctx);
   }
	@Override public Object visitAssignment(ShapesParser.AssignmentContext ctx) {
      if(traceCallbacks)
         out.println("visitAssignment");
      return visitChildren(ctx);
   }
}
