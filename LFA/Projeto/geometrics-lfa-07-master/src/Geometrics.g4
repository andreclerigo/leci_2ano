grammar Geometrics;

program : NEWLINE* 'geometrics:' 'main' stat*  EOF;

stat returns[String var]: assig 					#StatAssig
	| add						#StatAdd
	| remove					#StatRemove
	| aux 						#StatAux
	| NEWLINE					#StatNewline //Allow \n between actual statements	
	;

animStat: translate 			#AnimStatTranslate
		| rotate 				#AnimStatRotate
		| waitms				#AnimStatWaitms
		;

aux: 'import' STRING NEWLINE;

// It is possible to assign Shape, Points, Animations and figures
assig returns[String var]: 	shape		feature* NEWLINE 							#AssigShape
	|	'point'		ID point NEWLINE							#AssigPoint
	| 	anim													#AssigAnimation
	|	fig														#AssigFigure
	|	ID '=' expr NEWLINE										#AssigExpr
	;

expr	returns[String var]:
		op=('+'|'-') expr										#ExprPlusMinus
	|	expr op=('*'|'/'|'%') expr								#ExprMultDivMod
	|	expr op=('+'|'-') expr									#ExprAddSub
	|	Number													#ExprNumber
	|	'(' expr ')'											#ExprParent
	|	ID														#ExprID
	;


// Allow adding a shape or point to a Figure, adding a Figure inside a Figure
// Adding and animation inside an animation
add:	'add'	shape feature* 	'to'	ID						#AddShape
	|	'add'	point 	'to'	ID								#AddPoint
	|	'add'  	fig 	'to' 	ID								#AddFigure
	|	'add' 	anim	'to'	ID								#AddAnim
	|	'add'  	feature 'to'	ID								#AddFeature
	|	'add'	(Number|'-'Number)	'to'	ID					#AddNumber
    |	'add'	ID		'to'	ID								#AddID
	;

// Remove any variable
remove: 'remove' 	ID;

translate: 'translate' obj=ID 'to' (point|ID) NEWLINE;

rotate: 'rotate' obj=ID (Number|'-' Number) ('over' (point|ID))? NEWLINE;

// Figures can also be reffered as its variable
// Figures can have Shapes, Points and Animations associated with the Figure
fig returns[String var = null]:		'figure' 	ID '{' NEWLINE stat* '}' NEWLINE;

anim returns[String var]: 	'animation' ID '{' NEWLINE tick loop? (animStat | stat)* '}' NEWLINE;

tick: 	'tick is' Number NEWLINE;

loop:	'loop' Number 'times' NEWLINE;

waitms:	'wait' Number NEWLINE;

shape returns[String var]:  
		'line' 		ID (point|ID) (point|ID)					#ShapeLine
	| 	'circle' 	ID (point|ID) radius=expr 		 			#ShapeCircle
	| 	'rectangle' ID (point|ID) height=expr width=expr 		#ShapeRect
	|	'square' 	ID (point|ID) side=expr	 					#ShapeSquare
	|	'ellipse' 	ID (point|ID) a=expr b=expr					#ShapeEllipse
	;

feature returns[String var]:'color' 	color 										#FeatureColor
	| 	'thickness' Number 										#FeatureThick 
	|	'filled' 	op=('yes'|'no')								#FeatureFilled 
	|	'hidden' 	op=('yes'|'no') 							#FeatureHidden 
	;
//As features são opcionais, porém algumas virão selecionadas por defeito

point returns[String var]:  '(' expr ',' expr ')';

color returns[String var]:  HTMLColor					 							#ColorHex
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
ID: [a-zA-Z_] [a-zA-Z0-9_]*;
NEWLINE: ('\r'? '\n') | EOF;
STRING: '"' .*? '.geom"';
WS: [ \t]+ -> skip;
COMMENT: '/*' .*? '*/' -> skip;
