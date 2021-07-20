grammar StrLang;

program: stat* EOF;

stat: assig					 	#StatAssig
	| print					   	#StatPrint
	;

assig: ID ':' expr;

print: 'print' expr;

expr: '(' expr ')' 				#ExprParent
	| expr '+' expr 			#ExprAdd
	| expr '-' expr   			#ExprSub
	| 'input' expr 		 		#ExprInput
	| 'trim' expr 				#ExprTrim
	| ID 						#ExprID
	| STRING 					#ExprString
	| expr '/' expr '/' expr	#ExprReplace
	;

ID: [a-zA-Z0-9_]+;
STRING: '"' .*? '"';
WS: [ \t\n\r]+ -> skip;
Comment: '//' .*? '\n' -> skip;