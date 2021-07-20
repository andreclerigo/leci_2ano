import java.util.HashMap;
import java.util.Scanner;

public class Execute extends StrLangBaseVisitor<String> {
    HashMap<String, String> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    @Override public String visitProgram(StrLangParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public String visitStatAssig(StrLangParser.StatAssigContext ctx) {
        return visit(ctx.assig());
    }

    @Override public String visitStatPrint(StrLangParser.StatPrintContext ctx) {
        System.out.println(visit(ctx.print()));
        return "";
    }

    @Override public String visitAssig(StrLangParser.AssigContext ctx) {
        String res = visit(ctx.expr());
        String ID = ctx.ID().getText();

        if (res != null) map.put(ID, res);

        return "";
    }

    @Override public String visitPrint(StrLangParser.PrintContext ctx) {
        String res = visit(ctx.expr());
        if (res != null)
            return res;

        return "";
    }

    @Override public String visitExprString(StrLangParser.ExprStringContext ctx) {
        String res = ctx.STRING().getText();
        return res.substring(1, res.length()-1);
    }

    @Override public String visitExprParent(StrLangParser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }

    @Override public String visitExprSub(StrLangParser.ExprSubContext ctx) {
        String s1 = visit(ctx.expr(0));
        String s2 = visit(ctx.expr(1));
        s1 = s1.replaceAll(s2, "");

        return s1;
    }

    @Override public String visitExprInput(StrLangParser.ExprInputContext ctx) {
        System.out.print(visit(ctx.expr()));
        String res = sc.nextLine();

        return res;
    }

    @Override public String visitExprReplace(StrLangParser.ExprReplaceContext ctx) {
        String s = visit(ctx.expr(0));
        String in = visit(ctx.expr(1));
        String out = visit(ctx.expr(2));
        s = s.replaceAll(in, out);

        return s;
    }

    @Override public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
        return visit(ctx.expr()).trim();
    }

    @Override public String visitExprID(StrLangParser.ExprIDContext ctx) {
        String ID = ctx.ID().getText();

        if(!map.containsKey(ID)) {
            System.err.println("");
            return null;
        }
        return map.get(ID);
    }

    @Override public String visitExprAdd(StrLangParser.ExprAddContext ctx) {
        return visit(ctx.expr(0)) + visit(ctx.expr(1));
    }
}
