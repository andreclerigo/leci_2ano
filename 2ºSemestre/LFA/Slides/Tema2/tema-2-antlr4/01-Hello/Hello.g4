grammar Hello;

r: 'hello' ID;
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
