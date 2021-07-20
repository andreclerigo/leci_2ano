import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyListener extends HelloBaseListener {
	@Override public void exitR(HelloParser.RContext ctx) {
      System.out.println("Fim do r!!!!");
   }
}
