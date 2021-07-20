grammar Test;

@members {
boolean allowFloat() { return false; }
}

main: print* EOF;
print: 'print' expr;
expr: Number;

Number: [0-9]+ FractionalPart?;
fragment FractionalPart: {allowFloat()}? ('.' [0-9]+);
WS: [ \t\r\n]+ -> skip;
