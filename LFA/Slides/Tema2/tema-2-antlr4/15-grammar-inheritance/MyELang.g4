grammar MyELang;
import ELang;
expr : (INT | ID) {System.out.println("MyELang");} ;
INT : [0-9]+ ;
