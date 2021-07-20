import java.util.*;

public class b1_2 {
    static HashMap<String, Double> variables = new HashMap<String, Double>();
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        
        try {
            while(sc.hasNextLine()) {
                instruction(sc.nextLine().split(" "));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    static double value(String s) throws Exception {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            try { 
                return variables.get(s);
            } catch (Exception er) {
                throw new Exception("Variable not found");
            }
        }
    }

    static void instruction( String[] symbols ) throws Exception {
        if(symbols.length >= 3 && symbols[1].equals("=")) {
            variables.put( symbols[0], expression( Arrays.copyOfRange( symbols, 2, symbols.length ) ) );
        } else {
            System.out.println( expression(symbols) );
        }
    }

    static double expression( String[] symbols ) throws Exception {
        if( symbols.length == 1 ) {
            return value(symbols[0]);
        } else if ( symbols.length == 3) {
            double in1 = value(symbols[0]);
            double in2 = value(symbols[2]);

            switch(symbols[1]) {
                case "+": 
                        return in1 + in2;
                        //break;

                case "-":
                        return in1 - in2;
                        //break;

                case "*":
                        return in1 * in2;
                        //break;
                
                case "/":
                        return in1 / in2;
                        //break;
                default:
                        throw new Exception("Invalid operation");
            }
        } else {
            throw new Exception("Invalid expression");
        }
    }
}
