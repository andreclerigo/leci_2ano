grammar Calculator;

program:
		stat* EOF
	;
stat:
		assignment? NEWLINE 		#Assig
	|	expr? NEWLINE				#Exp
	;
assignment: ID '=' expr;
expr:
		op=('+'|'-') expr		    #ExprPlusMinus
	|	expr op=('*'|'/'|'%') expr	#ExprMultDivMod
	|	expr op=('+'|'-') expr		#ExprAddSub
	|	Integer						#ExprInteger
	|	'(' expr ')'				#ExprParent
	|   ID							#ExprID
	;

Integer: [0-9]+;	// implement long integers
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
