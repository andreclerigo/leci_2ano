public class Execute extends CalculatorBaseVisitor<String> {

    @Override public String visitProgram(CalculatorParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public String visitAssig(CalculatorParser.AssigContext ctx) {
        if (ctx.assignment() != null) {
			String res = visit(ctx.assignment());
			System.out.println(res);		
		}
		return null;
    }

    @Override public String visitExp(CalculatorParser.ExpContext ctx) {
   		if(ctx.expr() != null) {
			String res = visit(ctx.expr());
			System.out.println(res);
		}	
	    return null;
    }

    @Override public String visitAssignment(CalculatorParser.AssignmentContext ctx) {
        return ctx.ID().getText() + " = " + visit(ctx.expr());
    }

    @Override public String visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
		if (ctx.op.getText().equals("+") || ctx.op.getText().equals("-"))
	        return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
    	else
			return null;
	}

    @Override public String visitExprParent(CalculatorParser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }

    @Override public String visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
        return ctx.Integer().getText();
    }

    @Override public String visitExprPlusMinus(CalculatorParser.ExprPlusMinusContext ctx) {
        switch(ctx.op.getText()) {
			case "+": return visit(ctx.expr()) + " !+";
			case "-": return visit(ctx.expr()) + " !-";
		}
		return null;
    }

    @Override public String visitExprID(CalculatorParser.ExprIDContext ctx) {
        return ctx.ID().getText();
    }

    @Override public String visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
		if (ctx.op.getText().equals("*") || ctx.op.getText().equals("/"))
			return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
		else
        	return null;
    }
}
