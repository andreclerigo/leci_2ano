import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Java8GrammarMain {
   public static void main(String[] args) throws Exception {
      // create a CharStream that reads from standard input:
      CharStream input = CharStreams.fromStream(System.in);
      // create a lexer that feeds off of input CharStream:
      Java8GrammarLexer lexer = new Java8GrammarLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      Java8GrammarParser parser = new Java8GrammarParser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at compilationUnit rule:
      ParseTree tree = parser.compilationUnit();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         ParseTreeWalker walker = new ParseTreeWalker();
         AddClassCommentListener listener0 = new AddClassCommentListener(tokens);
         walker.walk(listener0, tree);
         listener0.print();
      }
   }
}
