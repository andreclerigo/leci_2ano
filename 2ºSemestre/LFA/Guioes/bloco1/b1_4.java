import java.io.File;
import java.io.IOException;
import java.util.*;

public class b1_4 {
    static HashMap<String, Integer> conversion = new HashMap<>();
    public static void main(String[] args) throws IOException {
        File f = new File("material/numbers.txt");
        Scanner scf = new Scanner(f);
        while(scf.hasNextLine()) {
            String[] line = scf.nextLine().split(" - ");
            conversion.put(line[1], Integer.parseInt(line[0]));
        }
        scf.close();
        
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            System.out.println(expression(sc.nextLine().split(" |\\-")));
        }   
    }

    static String expression(String[] symbols) {
        String r = "";
        for (String s : symbols) {
            if(!conversion.containsKey(s))
                r += s + " ";
            else
                r += conversion.get(s) + " ";
        }
        return r;
    }
}
