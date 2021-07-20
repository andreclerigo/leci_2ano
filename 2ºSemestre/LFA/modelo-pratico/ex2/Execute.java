import java.util.HashMap;
import java.util.Scanner;

public class Execute extends FracLangBaseVisitor<Fraction> {
    HashMap<String, Fraction> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    @Override public Fraction visitProgram(FracLangParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Fraction visitStatAssig(FracLangParser.StatAssigContext ctx) {
        return visit(ctx.assig());
    }

    @Override public Fraction visitStatDisplay(FracLangParser.StatDisplayContext ctx) {
        return visit(ctx.display());
    }

    @Override public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
        String op = ctx.op.getText();

        if (op.equals("+"))
            return visit(ctx.expr(0)).addTo(visit(ctx.expr(1)));
        
        if (op.equals("-"))
            return visit(ctx.expr(0)).subTo(visit(ctx.expr(1)));

        return null;
    }

    @Override public Fraction visitExprRead(FracLangParser.ExprReadContext ctx) {
        String text = ctx.STRING().getText();
        System.out.print(text.substring(1, text.length()-1) + ": ");
        String in = sc.nextLine();

        if (in.contains("/")) {
            String[] frac = in.split("/");
            try {
                return new Fraction(Integer.parseInt(frac[0]), Integer.parseInt(frac[1]));
            } catch (Exception e) {
                System.err.println("ERROR: invalid input");
                return null;
            }
        } else {
            try {
                return new Fraction(Integer.parseInt(in));
            } catch (Exception e) {
                System.err.println("ERROR: invalid input");
                return null;
            }
        }
    }

    @Override public Fraction visitExprParent(FracLangParser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }

    @Override public Fraction visitExprNumber(FracLangParser.ExprNumberContext ctx) {
        return new Fraction(Integer.parseInt( ctx.Number().getText() ));
    }

    @Override public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {
        String op = ctx.op.getText();

        if (op.equals("*"))
            return visit(ctx.expr(0)).multTo(visit(ctx.expr(1)));
        
        if (op.equals(":"))
            return visit(ctx.expr(0)).divTo(visit(ctx.expr(1)));

        return null;
    }

    @Override public Fraction visitExprPlusMinus(FracLangParser.ExprPlusMinusContext ctx) {
        if (ctx.op.getText().equals("-"))
            return visit(ctx.expr()).negFrac();

        return visit(ctx.expr());
    }

    @Override public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {
        return new Fraction( Integer.parseInt(ctx.Number(0).getText()), Integer.parseInt(ctx.Number(1).getText()) );
    }

    @Override public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
        String ID = ctx.ID().getText();

        if (!map.containsKey(ID)) {
            System.err.println("ERROR: variable " + ID + " not found!");
            return null;
        }
        
        return map.get(ID);
    }

    @Override public Fraction visitExprReduce(FracLangParser.ExprReduceContext ctx) {
        return visit(ctx.expr()).reduce();
    }


    @Override public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
        Fraction f = visit(ctx.expr());
        System.out.println(f);

        return null;
    }

    @Override public Fraction visitAssig(FracLangParser.AssigContext ctx) {
        String key = ctx.ID().getText();
        Fraction f = visit(ctx.expr());

        map.put(key, f);
        return f;
    }
}
