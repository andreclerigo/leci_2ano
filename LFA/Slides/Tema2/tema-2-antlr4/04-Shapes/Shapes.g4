grammar Shapes;

main: (instruction? ';')* EOF;

instruction: print | assignment;

print: 'print' expr;

assignment: Identifier ':=' expr;

expr: distance | Number | Identifier;

distance: 'distance' point point;

point: '(' expr ',' expr ')';

Number: [0-9]+('.' [0-9]+)?;
Identifier: [a-zA-Z_]+;
LineComment: '--' .*? '\n' -> skip;
WhiteSpace: [ \t\r\n]+ -> skip;

