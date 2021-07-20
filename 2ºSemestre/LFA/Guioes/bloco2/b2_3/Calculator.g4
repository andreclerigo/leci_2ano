grammar Calculator;

program:
		stat* EOF
	;
stat:
		expr? NEWLINE
	;
expr:
		op=('+'|'-') expr		    #ExprPlusMinus
	|	expr op=('*'|'/'|'%') expr	#ExprMultDivMod
	|	expr op=('+'|'-') expr		#ExprAddSub
	|	Integer						#ExprInteger
	|	'(' expr ')'				#ExprParent
	;

Integer: [0-9]+;	// implement long integers
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
