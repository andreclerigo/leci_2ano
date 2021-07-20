package aula14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) throws IOException {
        String file = System.getProperty("user.dir");

                List<String> list = Files.readAllLines(Paths.get("aula14/Policarpo.txt"))
                .stream()
                .flatMap((str) -> Arrays.stream(str.trim().split("( |\n|\t|\\.|,|:|‘|’|;|\\?|!|-|\\*|\\{|}|=|\\+|&|/|\\(|\\)|[|]|”|“|\\|\"|\')")))
                .filter((str) -> str.length() >= 3)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        
        HashMap<String, Palavra> palavras = new HashMap<>();
        
        for(int i = 0; i < list.size()-1; i++) {
            String s = list.get(i);
            Palavra p = palavras.get(s);
            if (p == null) {
                p = new Palavra(s);
                palavras.put(s, p);
            }
            p.addPar(list.get(i+1));
        }

        String o = file + "/aula14/output";
        File f = new File(o);
        PrintWriter pw = new PrintWriter(f);
        
        HashMap<String, Palavra> sortedPalavras = palavras.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                                                                                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        sortedPalavras.entrySet().forEach(x -> System.out.println(x.getValue()));
        sortedPalavras.entrySet().forEach(x -> pw.println(x.getValue()));

        pw.close();
    }
}
