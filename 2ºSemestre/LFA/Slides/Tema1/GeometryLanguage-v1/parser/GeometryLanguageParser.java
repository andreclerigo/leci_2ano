package parser;

import static java.lang.System.*;
import static lexer.GeometryLanguageLexer.*;

public class GeometryLanguageParser {
   /**
    * Start rule: attempts to parse the whole input.
    */
   public static boolean parse() {
      assert token() == tokenIds.NONE;

      nextToken();
      return parseDistance();
   }

   /**
    * Distance rule parsing.
    */
   public static boolean parseDistance() {
      assert token() != tokenIds.NONE;

      boolean result = token() == tokenIds.DISTANCE;
      if (result) {
         nextToken();
         result = parsePoint();
         if (result) {
            result = parsePoint();
         }
      }
      return result;
   }

   /**
    * Point rule parsing.
    */
   public static boolean parsePoint() {
      assert token() != tokenIds.NONE;

      boolean result = token() == tokenIds.OPEN_PARENTHESES;
      if (result) {
         nextToken();
         result = token() == tokenIds.NUMBER;
         if (result) {
            nextToken();
            result = token() == tokenIds.COMMA;
            if (result) {
               nextToken();
               result = token() == tokenIds.NUMBER;
               if (result) {
                  nextToken();
                  result = token() == tokenIds.CLOSE_PARENTHESES;
                  if (result) {
                     nextToken();
                  }
               }
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      if(parse())
         out.println("Ok");
      else
         out.println("ERROR");
   }

}

