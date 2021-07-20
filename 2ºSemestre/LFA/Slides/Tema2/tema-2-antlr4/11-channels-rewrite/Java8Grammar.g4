grammar Java8Grammar;
import Java8;


WS  :  [ \t\r\n\u000C]+ -> channel(1)
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(2)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(2)
    ;
