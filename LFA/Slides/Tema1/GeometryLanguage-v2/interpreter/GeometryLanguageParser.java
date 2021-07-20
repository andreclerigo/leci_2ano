package interpreter;

import static java.lang.System.*;
import static lexer.GeometryLanguageLexer.*;
import java.util.*;

public class GeometryLanguageParser {
   /**
    * Start rule: attempts to parse the whole input.
    */
   public static boolean parse() {
      assert token() == tokenIds.NONE;

      nextToken();
      Double result = 0.0;
      while(result != null && token() != tokenIds.EOF) {
         result = parseDistance();
         if (result == null)
            result = parseAssignment();
         if (result != null)
            out.println("value = "+result);
      }
      return result != null;
   }

   /**
    * Assignment rule parsing.
    */
   public static Double parseAssignment() {
      assert token() != tokenIds.NONE;

      Double result = null;
      if (token() == tokenIds.ID) {
         String var = attr();
         nextToken();
         if (token() == tokenIds.EQUAL) {
            nextToken();
            result = parseExpression();
            if (result != null) {
               symbolTable.put(var, result);
            }
         }
      }
      return result;
   }

   /**
    * Expression rule parsing.
    */
   public static Double parseExpression() {
      assert token() != tokenIds.NONE;

      Double result = null;
      switch(token()) {
         case NUMBER:
            result = value();
            nextToken();
            break;
         case ID:
            if (!symbolTable.containsKey(attr())) {
               err.println("ERROR: undefined variable \""+attr()+"\"");
               exit(1);
            }
            result = symbolTable.get(attr());
            nextToken();
            break;
         default:
            result = parseDistance();
            break;
      }
      return result;
   }

   /**
    * Distance rule parsing.
    */
   public static Double parseDistance() {
      assert token() != tokenIds.NONE;

      Double result = null;
      if (token() == tokenIds.DISTANCE) {
         nextToken();
         Double[] p1 = parsePoint();
         if (p1 != null) {
            Double[] p2 = parsePoint();
            if (p2 != null) {
               result = Math.sqrt(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2));
            }
         }
      }
      return result;
   }

   /**
    * Point rule parsing.
    */
   public static Double[] parsePoint() {
      assert token() != tokenIds.NONE;

      Double[] result = null;
      if (token() == tokenIds.OPEN_PARENTHESES) {
         nextToken();
         Double x = parseExpression();
         if (x != null) {
            if (token() == tokenIds.COMMA) {
               nextToken();
               Double y = parseExpression();
               if (y != null) {
                  if (token() == tokenIds.CLOSE_PARENTHESES) {
                     nextToken();
                     result = new Double[2];
                     result[0] = x;
                     result[1] = y;
                  }
               }
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      if(!parse())
         out.println("ERROR");
   }

   protected static Map<String,Double> symbolTable = new HashMap<String,Double>();
}

