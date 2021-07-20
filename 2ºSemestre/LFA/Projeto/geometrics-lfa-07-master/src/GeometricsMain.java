import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

public class GeometricsMain {
   public static void main(String[] args) {
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName(args[0]);
		 File f = new File(args[0]);
         // create a lexer that feeds off of input CharStream:
         GeometricsLexer lexer = new GeometricsLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         GeometricsParser parser = new GeometricsParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            Semantic visitor0 = new Semantic();
            visitor0.setPath(f.getParent());
            visitor0.visit(tree);
            
            GeomCompiler compiler = new GeomCompiler();
            ST result = compiler.visit(tree);
            result.add("name", "Output");
            System.out.println(result.render());
            String file = "geometrics.py";
            PrintWriter pw = new PrintWriter(new File(file));
            pw.print(result.render());
            pw.close();
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
   }
}
