grammar Shapes;

@header {
import static java.lang.System.*;
}

main: {out.println("--- Atribute grammar ---");} (stat {out.println($stat.res);} )* {out.println("--- end ---\n");};

stat  returns[double res]: distance {$res = $distance.res;}
    | assignment {$res = $assignment.res;}
    ;

distance returns[double res]: 'distance' p1=point p2=point {
   $res = Math.sqrt(Math.pow($p1.x-$p2.x,2)+Math.pow($p1.y-$p2.y,2));
};

point returns[double x,double y]: '(' e1=expr ',' e2=expr ')' {$x = $e1.res; $y=$e2.res;};

expr returns[double res]: distance {$res = $distance.res;}
    | NUM {$res = Double.parseDouble($NUM.text);}
    ;

assignment returns[double res]: ID '=' expr {$res = $expr.res;};

ID: [a-zA-Z][a-zA-Z0-9_]*;
NUM: [0-9]+;
WS: [ \t\r\n]+ -> skip;
