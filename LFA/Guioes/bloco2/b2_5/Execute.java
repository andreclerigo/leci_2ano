import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.HashMap;

public class Execute extends NumbersBaseListener {
	HashMap<String, Integer> map = new HashMap<>();
    @Override public void enterStat(NumbersParser.StatContext ctx) {
    }

    @Override public void exitStat(NumbersParser.StatContext ctx) {
    }

    @Override public void enterLine(NumbersParser.LineContext ctx) {
    	map.put(ctx.ID().getText(), Integer.parseInt(ctx.Num().getText()));
	}
	
	public HashMap<String, Integer> getMap(){
		return map;
	}

    @Override public void exitLine(NumbersParser.LineContext ctx) {
    }

    @Override public void enterEveryRule(ParserRuleContext ctx) {
    }

    @Override public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override public void visitTerminal(TerminalNode node) {
    }

    @Override public void visitErrorNode(ErrorNode node) {
    }
}
