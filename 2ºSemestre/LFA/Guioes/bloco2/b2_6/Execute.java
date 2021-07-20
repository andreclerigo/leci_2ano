import java.util.HashMap;

public class Execute extends CalculatorBaseVisitor<Long> {
   HashMap<String, Long> map = new HashMap<>();

   @Override public Long visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Long visitAssig(CalculatorParser.AssigContext ctx) {
      if (ctx.assignment() != null) {
         long res = visit(ctx.assignment());
         System.out.println(res);
	  }
      return null;
   }

   @Override public Long visitExp(CalculatorParser.ExpContext ctx) {
      if (ctx.expr() != null) {
         long res = visit(ctx.expr());
         System.out.println(res);
	  }
      return null;
   }

   @Override public Long visitAssignment(CalculatorParser.AssignmentContext ctx) {
      String key = ctx.ID().getText();
      long val = visit(ctx.expr()); 
	  map.put(key, val);
      return val;
   }

   @Override public Long visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      switch(ctx.op.getText()) {
         case "+": //
			long soma = 0L;
			for(CalculatorParser.ExprContext n : ctx.expr()) {
				soma += visit(n);
			}
			return soma;
			//return visit(ctx.expr(0)) + visit(ctx.expr(1)); 
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

   @Override public Long visitExprPlusMinus(CalculatorParser.ExprPlusMinusContext ctx) {
      switch(ctx.op.getText()) {
	     case "+": return visit(ctx.expr());
         case "-": return - visit(ctx.expr());
      }
      return null;
   }

   @Override public Long visitExprID(CalculatorParser.ExprIDContext ctx) {
	  String key = ctx.ID().getText();
      if (map.containsKey(key))
         return map.get(key);
      else
         System.out.println("Variable (" + key + ") not found!"); return 0L;
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
}
