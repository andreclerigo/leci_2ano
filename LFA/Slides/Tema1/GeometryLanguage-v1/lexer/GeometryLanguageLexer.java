package lexer;

import static java.lang.System.*;
import java.util.Scanner;

public class GeometryLanguageLexer {
   /**
    * token types
    */ 
   public enum tokenIds {
      NONE, NUMBER, COMMA, OPEN_PARENTHESES, CLOSE_PARENTHESES, DISTANCE, EOF
   }

   /**
    * Updates actual token to the next input token.
    */ 
   public static void nextToken() {
      assert token != tokenIds.EOF;

      token = tokenIds.EOF;
      attr = "";
      if (sc.hasNext()) {
         text = sc.next();
         switch(text) {
            case ",": token = tokenIds.COMMA; break;
            case "(": token = tokenIds.OPEN_PARENTHESES; break;
            case ")": token = tokenIds.CLOSE_PARENTHESES; break;
            case "distance": token = tokenIds.DISTANCE; break;
            default:
               try {
                  attr = text;
                  value = Double.parseDouble(text);
                  token = tokenIds.NUMBER;
               }
               catch(NumberFormatException e) {
                  err.println("ERROR: unknown lexeme \""+text+"\"");
                  exit(1);
               }
               break;
         }
      }
   }

   /**
    * Actual token type
    */
   public static tokenIds token() { return token; }
   /**
    * Actual token attribute
    */
   public static String attr() { return attr; }
   /**
    * Actual token value
    */
   public static Double value() { return value; }

   public static void main(String[] args) {
      do {
         nextToken();
         out.print(" <"+token()+(attr().length() > 0 ? ","+attr() : "")+">");
      }
      while(token() != tokenIds.EOF);
      out.println();
   }

   protected static final Scanner sc = new Scanner(System.in);

   protected static tokenIds token = tokenIds.NONE;
   protected static String text = "";
   protected static String attr;
   protected static double value;

}

