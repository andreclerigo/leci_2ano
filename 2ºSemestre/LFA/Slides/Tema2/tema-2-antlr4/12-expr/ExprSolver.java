import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ExprSolver extends ExprBaseListener {
   void setVal(ParseTree node, int val) {
      mapVal.put(node, val);
   }

   int getVal(ParseTree node) {
      return mapVal.get(node);
   }

   void setTxt(ParseTree node, String txt) {
      mapTxt.put(node, txt);
   }

   String getTxt(ParseTree node) {
      return mapTxt.get(node);
   }

	@Override public void exitStat(ExprParser.StatContext ctx) {
      System.out.println(getTxt(ctx.expr()) + " = " + getVal(ctx.expr()));
   }

	@Override public void exitAdd(ExprParser.AddContext ctx) {
      int left = getVal(ctx.expr(0));
      int right = getVal(ctx.expr(1));
      setVal(ctx, left + right);
      setTxt(ctx, ctx.getText());
   }

	@Override public void exitMult(ExprParser.MultContext ctx) {
      int left = getVal(ctx.expr(0));
      int right = getVal(ctx.expr(1));
      setVal(ctx, left * right);
      setTxt(ctx, ctx.getText());
   }

	@Override public void exitInt(ExprParser.IntContext ctx) {
      int val  = Integer.parseInt(ctx.INT().getText());
      setVal(ctx, val);
      setTxt(ctx, ctx.getText());
   }

   protected ParseTreeProperty<Integer> mapVal = new ParseTreeProperty<>();
   protected ParseTreeProperty<String> mapTxt = new ParseTreeProperty<>();
}
