grammar Shapes;

main: (instruction? ';')* EOF;

instruction: print | assignment;

print: 'print' expr;

assignment: Identifier ':=' expr;

expr: distance   #exprDistance
    | Number     #exprNumber
    | Identifier #exprIdentifier
    ;

distance: 'distance' p1=point p2=point;

point: '(' x=expr ',' y=expr ')';

Number: [0-9]+('.' [0-9]+)?;
Identifier: [a-zA-Z_]+;
LineComment: '--' .*? '\n' -> skip;
WhiteSpace: [ \t\r\n]+ -> skip;

