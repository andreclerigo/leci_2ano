grammar Numbers;

stat: line line* EOF;

line: Num '-' ID '\n';

Num: [0-9]+;
ID: [a-zA-Z]+;
WS: [ \t\r] -> skip;
