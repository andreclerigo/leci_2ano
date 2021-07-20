import java.util.HashMap;

public class Execute extends CalcFracBaseVisitor<Fraction> {
	HashMap<String, Fraction> variables = new HashMap<>();

    @Override public Fraction visitProgram(CalcFracParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Fraction visitStatAssig(CalcFracParser.StatAssigContext ctx) {
        return visit(ctx.assignment());
    }

    @Override public Fraction visitStatprint(CalcFracParser.StatprintContext ctx) {
        return visit(ctx.print());
    }

    @Override public Fraction visitPrint(CalcFracParser.PrintContext ctx) {
        Fraction f = visit(ctx.expr());
		System.out.println(f);
		return null;
    }

    @Override public Fraction visitAssignment(CalcFracParser.AssignmentContext ctx) {
        String key = ctx.ID().getText();
		Fraction f = visit(ctx.expr());
		variables.put(key, f);
		return f;
    }

    @Override public Fraction visitExprAddSub(CalcFracParser.ExprAddSubContext ctx) {
        if (ctx.op.getText().equals("+"))
			return visit(ctx.expr(0)).addTo(visit(ctx.expr(1)));
		else if (ctx.op.getText().equals("-"))
			return visit(ctx.expr(0)).subTo(visit(ctx.expr(1)));

   		return null;
	}

    @Override public Fraction visitExprParent(CalcFracParser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }

    @Override public Fraction visitExprMultDiv(CalcFracParser.ExprMultDivContext ctx) {
		if (ctx.op.getText().equals("*"))
			return visit(ctx.expr(0)).mulTo(visit(ctx.expr(1)));
		else if (ctx.op.getText().equals(":"))
			return visit(ctx.expr(0)).divTo(visit(ctx.expr(1)));
		
        return null;
    }

    @Override public Fraction visitExprPlusMinus(CalcFracParser.ExprPlusMinusContext ctx) {
        if (ctx.op.getText().equals("-"))
			return (new Fraction()).subTo(visit(ctx.expr()));
		else if (ctx.op.getText().equals("+"))
			return visit(ctx.expr());
    	
		return null;
	}
		
    @Override public Fraction visitExprID(CalcFracParser.ExprIDContext ctx) {
        return variables.get(ctx.ID().getText());
    }

    @Override public Fraction visitExprReduce(CalcFracParser.ExprReduceContext ctx) {
       	return new Fraction(visit(ctx.expr()));	
    }
    @Override public Fraction visitFrac(CalcFracParser.FracContext ctx) {
        return new Fraction(Integer.parseInt(ctx.Integer(0).getText()), Integer.parseInt(ctx.Integer(1).getText()));
    }
}
