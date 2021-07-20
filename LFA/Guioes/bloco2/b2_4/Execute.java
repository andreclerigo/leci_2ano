public class Execute extends PreffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(PreffixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitStat(PreffixCalculatorParser.StatContext ctx) {
      if (ctx.expr() != null) {
	     double res = visit(ctx.expr());
         System.out.println(res);
      }
      return null;
   }

   @Override public Double visitExprPreffix(PreffixCalculatorParser.ExprPreffixContext ctx) {
      switch(ctx.op.getText()) {
         case "+":
                    return visit(ctx.expr(0)) + visit(ctx.expr(1)); 
         
         case "-":
                    return visit(ctx.expr(0)) - visit(ctx.expr(1)); 
         
         case "*":
                    return visit(ctx.expr(0)) * visit(ctx.expr(1)); 
         
         case "/":
                    return visit(ctx.expr(0)) / visit(ctx.expr(1)); 
         default: System.out.println("Operator not valid");
      }
      return null;
   }

   @Override public Double visitExprNumber(PreffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }
}
