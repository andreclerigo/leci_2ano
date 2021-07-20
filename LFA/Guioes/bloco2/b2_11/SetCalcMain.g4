grammar SetCalcMain;

program: stat* EOF;

stat: assignment? NEWLINE	#StatAssig
	| expr?	NEWLINE			#StatExpr
	;

assignment: Variables '=' expr;

expr: '{' Numbers+ '}'		#ExprWord
	| Variables				#ExprVariables
	| expr '+' expr 		#ExprUnion
	| expr '&' expr			#ExprIntersect
	| expr '\\' expr		#ExprDiference
	| '(' expr ')'			#ExprParentheses
	;

Numbers:  Integer 
		| Integer ','
		;

ID: [a-z]+;
Variables: [A-Z];
Integer: [0-9]+;
WS: [ \t] -> skip;
NEWLINE: '\r'? '\n';
Comment: '--' .*? '\n' -> skip;
