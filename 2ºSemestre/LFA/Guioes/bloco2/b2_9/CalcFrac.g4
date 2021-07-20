grammar CalcFrac;

program:
		stat* EOF
	;
stat:
		assignment? NEWLINE			#StatAssig
	|	print? NEWLINE				#Statprint
	;

print: 'print' expr ';';

assignment: expr '->' ID ';';
expr:
		op=('+'|'-') expr		    #ExprPlusMinus
	|	expr op=('*'|':') expr		#ExprMultDiv
	|	expr op=('+'|'-') expr		#ExprAddSub
	|	Integer '/' Integer			#Frac
	|	'(' expr ')'				#ExprParent
	|	'reduce' expr				#ExprReduce
	|	ID							#ExprID
	;

ID: [a-zA-Z_]+;
Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
