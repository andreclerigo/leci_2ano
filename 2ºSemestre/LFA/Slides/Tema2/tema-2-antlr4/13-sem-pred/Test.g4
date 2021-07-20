grammar Test;

@header {
import java.util.*;
}

@members {
   enum Type {NUMBER,STRING,BOOLEAN};
   Map<String,Type> symbolTable = new HashMap<>();

   void addType(String var, Type type) {
      symbolTable.put(var, type);
   }

   boolean isTypeNumber(String var) {
      return symbolTable.get(var) == Type.NUMBER;
   }

   boolean isTypeString(String var) {
      return symbolTable.get(var) == Type.STRING;
   }

   boolean isTypeBoolean(String var) {
      return symbolTable.get(var) == Type.BOOLEAN;
   }
}

main: stat* EOF;

stat: declaration
    | print
    ;

declaration: type VAR {addType($VAR.text, $type.res);};

type returns[Type res]: 'number'  {$res = Type.NUMBER;}
                       | 'string'  {$res = Type.STRING;}
                       | 'boolean' {$res = Type.BOOLEAN;}
                       ;

print: 'print' expr;

expr: numberExpr | stringExpr | booleanExpr;

numberExpr: {isTypeNumber(_input.LT(1).getText())}? VAR {System.out.println("number");};
stringExpr: {isTypeString(_input.LT(1).getText())}? VAR {System.out.println("string");};
booleanExpr: {isTypeBoolean(_input.LT(1).getText())}? VAR {System.out.println("boolean");};

VAR: [a-z]+;
WS: [ \t\r\n]+ -> skip;
