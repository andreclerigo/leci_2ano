import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitStatement(HelloParser.StatementContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      System.out.print("Olá");
      visit(ctx.name());
      return null;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      System.out.print("Adeus");
      visit(ctx.name());
      return null;
   }


   @Override public String visitName(HelloParser.NameContext ctx) {
      for(TerminalNode n : ctx.ID()) {
	System.out.print(" " + n.getText());    
      }
      System.out.println();      
      return null;
   }
}
