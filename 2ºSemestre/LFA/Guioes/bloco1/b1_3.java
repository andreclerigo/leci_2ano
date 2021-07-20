import java.util.*;

public class b1_3 {
    public static void main(String[] args) {
        String[] tokens;
        Stack<Double> stack;
        double result;
        double op1, op2;
        
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            tokens = sc.nextLine().split(" ");

            stack = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                double val = value(tokens[i]);
                if (val != -1.0) {
                    stack.push(val);
                } else {
                    try {
                        op1 = stack.pop();
                        op2 = stack.pop();
                    } catch (EmptyStackException e) {
                        System.err.println("Number of operands not enough");
                        break;
                    }

                    switch (tokens[i]) {
                        case "+":
                                result = op1 + op2;
                                stack.push(result);
                                break;
                        case "-":   
                                result = op1 - op2;
                                stack.push(result);
                                break;
                        case "/":
                                result = op1 / op2;
                                stack.push(result);
                                break;
                        case "*":
                                result = op1 * op2;
                                stack.push(result);
                                break;
                        default:
                                System.err.println("Invalid operation");
                    }
                }
                
                int size = 0;
                System.out.print("Stack: [");
                for (double num : stack) {
                    if (size == stack.size() - 1) break;
                    System.out.print(num + ", ");
                    size++;
                }
                
                System.out.println(stack.peek() + "]");
            }
        }
    }

    static double value(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
