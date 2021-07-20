grammar ELang;
stat : (expr ';')* EOF ;
expr : ID {System.out.println("ELang");} ;
WS : [ \r\t\n]+ -> skip ;
ID : [a-z]+ ;
