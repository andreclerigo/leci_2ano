import java.io.File;
import java.util.*;

public class b1_6 {
    static HashMap<String, String> translation = new HashMap<>();
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("Not enough arguments");
        }

        File f = new File(args[0]);
        Scanner scf = new Scanner(f);
        while(scf.hasNextLine()) {
            String[] line = scf.nextLine().split(" ");
            translation.put(line[0], line[1]);
        }
        scf.close();

        for (int i = 1; i < args.length; i++) {
            f = new File(args[i]);
            scf = new Scanner(f);
            while(scf.hasNextLine()) {
                String line = scf.nextLine();
                String out = "\"" + line + "\" -> \"";

                String[] words = line.split(" ");
                for(String s : words) {
                    out += translate(s) +  " ";
                }
                out = out.substring(0, out.length() - 1);
                out += "\"";
                
                System.out.println(out);
            }
            scf.close();
        }
    }
    
    static String translate(String s) {
        String translated = translation.get(s);
        if (translated == null)
            return s;
        else
            return translated;
    }
}