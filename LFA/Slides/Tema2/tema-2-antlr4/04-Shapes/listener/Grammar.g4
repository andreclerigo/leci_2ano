grammar Grammar;

main: a* EOF;

a: X #aX
 | Y #aY
 | Z #aZ
 ;

X: [xX];
Y: [yY];
Z: [zZ];

WS: [ \t\r\n]+ -> skip;
