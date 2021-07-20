grammar GeometricsAux;

program: NEWLINE* 'geometrics:' 'database' (NEWLINE|fig)+ EOF;

stat:   shape       feature* NEWLINE                            #StatShape
    |	'point'		ID point NEWLINE                            #StatPoint
    |   fig                                                     #StatFig
    |   NEWLINE                                                 #StatNewline
    ;

// Figures can also be reffered as its variable
// Figures can have Shapes, Points and Animations associated with the Figure
fig:	ID 'is' '{' NEWLINE stat+ '}' NEWLINE;

expr:	op=('+'|'-') expr										#ExprPlusMinus
	|	expr op=('*'|'/'|'%') expr								#ExprMultDivMod
	|	expr op=('+'|'-') expr									#ExprAddSub
	|	Number													#ExprNumber
	|	'(' expr ')'											#ExprParent
	;

shape:  'line' 		ID (point|ID) (point|ID)					#ShapeLine
	| 	'circle' 	ID (point|ID) radius=expr 		 			#ShapeCircle
	| 	'rectangle' ID (point|ID) height=expr width=expr 		#ShapeRect
	|	'square' 	ID (point|ID) side=expr	 					#ShapeSquare
	|	'ellipse' 	ID (point|ID) a=expr b=expr					#ShapeEllipse
	;

feature:'color' 	color 										#FeatureColor
	| 	'thickness' Number 										#FeatureThick 
	|	'filled' 	op=('yes'|'no')								#FeatureFilled 
	|	'hidden' 	op=('yes'|'no') 							#FeatureHidden 
	;

point:  '(' expr ',' expr ')';

color:  HTMLColor					 							#ColorHex
	|   red=Number ',' green=Number ',' blue= Number alpha?		#ColorRGBA
	|  	('red'| 'blue'| 'green'| 'yellow' | 'black' 
	|   'white'| 'cyan' | 'orange' | 'purple'| 'pink' 
	|   'brown' | 'grey' ) (Number '%'?)?						#ColorName
	;	//Number coincide com a opacidade e se não houver número é 100%?

alpha: ',' Number;

fragment
Hex: [0-9A-Fa-f];
HTMLColor: '#' Hex Hex Hex Hex Hex Hex;

Number: [0-9]+;
ID: [a-zA-Z_] [a-zA-Z0-9_]+;
NEWLINE: ('\r'? '\n') | EOF;
WS: [ \t]+ -> skip;
COMMENT: '/*' .*? '*/' -> skip;
