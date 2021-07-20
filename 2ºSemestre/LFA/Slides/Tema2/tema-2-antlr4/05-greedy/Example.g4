grammar Example;

all: STRING* EOF;

STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip;
