lexer grammar CSVLexer;

COMMA: ',';
EOL: '\r'? '\n';
TEXT: ~[,\n\r"]+;
STRING: '"' ( '""' | ~'"' )* '"';
