grammar Expr;

main: (stat ';'?)*;
stat: assignment | show;
assignment: ID '=' e=expr[true] {System.out.println($ID.text+" = "+$e.res);};
show: 'show' expr[false] {System.out.println($expr.res);};
expr[boolean inAssign] returns[int res]: NUM {
   if ($inAssign)
      System.out.println("Woh! Inside an assignment!");
   $res = Integer.parseInt($NUM.text);
};
ID: [a-z]+;
NUM: [0-9]+;
WS: [ \t\r\n]+ -> skip;
