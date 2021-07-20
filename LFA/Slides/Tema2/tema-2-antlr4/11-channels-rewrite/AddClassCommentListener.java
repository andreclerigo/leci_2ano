import org.antlr.v4.runtime.*;

public class AddClassCommentListener extends Java8GrammarBaseListener {

   protected TokenStreamRewriter rewriter;

   public AddClassCommentListener(TokenStream tokens) {
      rewriter = new TokenStreamRewriter(tokens);
   }

   public void print() {
      System.out.print(rewriter.getText());
   }

   @Override public void enterNormalClassDeclaration(Java8GrammarParser.NormalClassDeclarationContext ctx) {
      rewriter.insertBefore(ctx.start, "/**\n * class "+ctx.Identifier().getText()+"\n */\n");
      rewriter.insertAfter(ctx.stop, "\n/* That's all folks! */\n");
   }
}
