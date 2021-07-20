grammar Seq;

all: sequence* EOF;

sequence
   @init {
      System.out.print("(");
   }
   @after {
      System.out.println(")");
   }
   : INT numbers[$INT.int];

numbers[int count]
locals [int c = 0]
   : ( {$c < $count}? INT {$c++; System.out.print(($c == 1 ? "" : " ")+$INT.text);} )+ ;

INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;
