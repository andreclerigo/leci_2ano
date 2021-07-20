import java.io.File;
import java.util.*;

public class b1_5 {
    static HashMap<String, Integer> conversion = new HashMap<>();

    public static void main(String[] args) throws Exception {
        File f = new File("material/numbers.txt");
        Scanner scf = new Scanner(f);
        while(scf.hasNextLine()) {
            String[] line = scf.nextLine().split(" - ");
            int num = Integer.parseInt(line[0]);
            conversion.put(line[1], num);
        }
        scf.close();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            System.out.println(expression(sc.nextLine()));
        }
    }
    
    static String expression(String line) throws Exception {
        String r = line + " -> ";
        Stack<Integer> nums = new Stack<>();

        String[] symbols = line.split(" |\\-");
        for (String s : symbols) {
            if (s.equals("and")) {
                nums.add(value(nums));
                continue;
            } else if(!conversion.containsKey(s)) {
                throw new Exception("Number text \"" + s + "\" does not exist in table!");
            } else {
                nums.add(conversion.get(s));
            }
        }
        r += value(nums);
        return r;
    }

    static int value(Stack<Integer> numbers) {
        int v1, v2;

        while (numbers.size() > 1) {
            v1 = numbers.pop();
            v2 = numbers.pop();

            //Push the new value to the stack because it might have an higher order
            if ((v1/10) > (v2/10))
                numbers.push(v1 * v2);  
            else
                numbers.push(v1 + v2);
        }
        
        return numbers.pop();
    }
}
