import static java.lang.System.*;

public class MyListener2 extends ShapesBaseListener {
	@Override public void enterMain(ShapesParser.MainContext ctx) {
      out.println("--- MyListener2 ---");
   }
	@Override public void exitMain(ShapesParser.MainContext ctx) {
      out.println("--- end ---\n");
   }
	@Override public void exitAssignment(ShapesParser.AssignmentContext ctx) {
      System.out.println("assignment to "+ctx.ID());
   }
}
