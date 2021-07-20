grammar CSV;

@header {
import static java.lang.System.*;
}

@parser::members {
   protected String[] names = new String[0];
   public int dimNames() {
      return names.length;
   }
   public void addName(String name) {
      assert name != null && !name.isEmpty();
      String[] tmp = new String[names.length + 1];
      arraycopy(names, 0, tmp, 0, names.length);
      tmp[names.length] = name;
      names = tmp;
   }
   public String getName(int idx) {
      assert idx >= 0 && idx < dimNames();
      return names[idx];
   }
}

file: line[true] line[false]* EOF;

line[boolean firstLine]
   locals[int col = 0]
   @after {
      if (!firstLine)
         out.println();
   }
   : field[$firstLine,$col++] (SEP field[$firstLine,$col++])* '\r'? '\n';

field[boolean firstLine, int col]
   returns[String res = ""]
   @after {
      if ($firstLine)
         addName($res);
      else if ($col >= 0 && $col < dimNames())
         out.print("  "+getName($col)+": "+$res);
      else
         err.println("\nERROR: invalid field \""+$res+"\" in column "+($col+1));
   }
   :
   (PHRASE {$res = $PHRASE.text.trim();}) |
   (STRING {$res = $STRING.text.trim();}) |
   ;

SEP: ','; // (' ' | '\t')*
PHRASE: ~[,"\r\n]~[,\r\n]*;
STRING: [ \t]* '"' .*? '"' [ \t]*;
