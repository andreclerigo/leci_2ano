grammar FracLang;

program: stat* EOF;

stat:   assig ';'           #StatAssig
    |   display ';'         #StatDisplay
    ;

expr:   '(' expr ')'                #ExprParent   
    |   expr op=('*' | ':') expr    #ExprMultDiv
    |   expr op=('+' | '-') expr    #ExprAddSub
    |   Number '/' Number           #ExprFraction   
    |   Number                      #ExprNumber
    |   ID                          #ExprID
    |   'read' STRING               #ExprRead
    |   'reduce' expr               #ExprReduce
    |   op=('+' | '-') expr         #ExprPlusMinus
    ;

display: 'display' expr;

assig: ID '<=' expr;

STRING: '"' .*? '"';
Number: [0-9]+;
ID: [a-z]+;
WS: [ \t\r\n]+ -> skip;
Comment: '--' .*? '\n' -> skip;