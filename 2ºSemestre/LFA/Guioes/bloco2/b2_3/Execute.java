public class Execute extends CalculatorBaseVisitor<Long> {

   @Override public Long visitProgram(CalculatorParser.ProgramContext ctx) {
	  return visitChildren(ctx);
   }

   @Override public Long visitStat(CalculatorParser.StatContext ctx) {
      if (ctx.expr() != null) {
         long res = visit(ctx.expr());
         System.out.println(res);
	  }
      return null;
   }

   @Override public Long visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      switch(ctx.op.getText()) {
         case "+": return visit(ctx.expr(0)) + visit(ctx.expr(1)); 
         case "-": return visit(ctx.expr(0)) - visit(ctx.expr(1));
         default: System.out.println("Error: visitExprAddSub");
	  }  
	return null;
   }

   @Override public Long visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Long.parseLong(ctx.Integer().getText());
   }

   @Override public Long visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      switch(ctx.op.getText()) {
         case "*": return visit(ctx.expr(0)) * visit(ctx.expr(1)); 
         case "/": return visit(ctx.expr(0)) / visit(ctx.expr(1));
         case "%": return visit(ctx.expr(0)) % visit(ctx.expr(1));
         default: System.out.println("Error: visitExprMultDivMod");
	  }  
      return null;
   }
   
   @Override public Long visitExprPlusMinus(CalculatorParser.ExprPlusMinusContext ctx) {
      switch(ctx.op.getText()) {
	     case "+": return Long.parseLong(ctx.expr().getText());
         case "-": return -Long.parseLong(ctx.expr().getText());
      }
      return null;
   }
}
