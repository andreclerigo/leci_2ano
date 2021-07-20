import java.util.*;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class NumbersMain {
   public static void main(String[] args) {
      HashMap<String, Integer> map = parser();	
      Scanner sc = new Scanner(System.in);
      while(sc.hasNextLine()) {
         System.out.println(expression(sc.nextLine().split(" |\\-"), map));
      }   
   }
   
   public static String expression(String[] symbols, HashMap<String, Integer> conversion){  
      String r = "";
      for (String s : symbols) {
         if(!conversion.containsKey(s))
            r += s + " ";
         else
            r += conversion.get(s) + " ";
      }
      return r;
   }

   public static HashMap<String, Integer> parser(){  
	  try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName("numbers.txt");
         // create a lexer that feeds off of input CharStream:
         NumbersLexer lexer = new NumbersLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         NumbersParser parser = new NumbersParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at stat rule:
         ParseTree tree = parser.stat();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            ParseTreeWalker walker = new ParseTreeWalker();
            Execute listener0 = new Execute();
            walker.walk(listener0, tree);
     		return listener0.getMap();       
         } 
   
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
      return null;
   }
}
