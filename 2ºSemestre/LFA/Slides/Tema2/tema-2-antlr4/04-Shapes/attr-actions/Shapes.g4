grammar Shapes;

@parser::header {
// MOS
import static java.lang.System.*;
import java.util.Map;
import java.util.HashMap;
}

@parser::members {
// MOS
protected Map<String,Double> symbolTable = new HashMap<>();
protected boolean errorInLine = false;
}

main: ({errorInLine=false;} instruction? ';')* EOF;

instruction: print | assignment;

print: 'print' expr
   {
      if (!errorInLine)
         out.println($expr.res);
   };

assignment: Identifier ':=' expr
   {
      if (!errorInLine)
      {
         String id = $Identifier.text;
         symbolTable.put(id, $expr.res);
      }
   };

expr returns[double res]:
     distance {$res = $distance.res;}
   | Number {$res = Double.parseDouble($Number.text);}
   | Identifier
     {
        String id = $Identifier.text;
        if (!symbolTable.containsKey(id))
        {
           err.println("ERROR: Variable \""+id+"\" not defined!");
           errorInLine = true;
        }
        else
           $res = symbolTable.get(id);
     };

distance returns[double res]: 'distance' p1=point p2=point
   {
      $res = Math.sqrt(($p1.x-$p2.x)*($p1.x-$p2.x) + ($p1.y-$p2.y)*($p1.y-$p2.y));
   };

point returns[double x, double y]: '(' xx=expr ',' yy=expr ')'
   {
      $x = $xx.res;
      $y = $yy.res;
   };

Number: [0-9]+('.' [0-9]+)?;
Identifier: [a-zA-Z_]+;
LineComment: '--' .*? '\n' -> skip;
WhiteSpace: [ \t\r\n]+ -> skip;

