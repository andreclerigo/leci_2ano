grammar Hello;					//Define a grammar called Hello
statement: (greetings | bye)+ ;
greetings: 'hello' name ;		//Match keyword hello followed by an identifier
bye: 'bye' name ;
name: ID+ ;
ID: [a-zA-Z]+ ;					//Match lower-case indentifiers
WS: [ \t\r\n]+ -> skip ;		//Skip spaces, tabs, newlines, \r (Windows)

