grammar Question;

file: questions+ EOF;

questions: head '{' answer+ '}'; 

head: ID '.' ID '("' .+? '")';
answer: '"' .+? '":' Integer ';';

WS: [ \t\r\n]+ -> skip;
ID: [a-zA-Z_] [a-zA-Z0-9_]*;
Integer: [0-9]+;
Comment: '#' .*? '\n' -> skip;
