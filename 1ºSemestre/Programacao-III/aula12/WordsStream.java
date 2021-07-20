package aula12;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class WordsStream {
    public static void main(String[] args) {
        List<String> content = new ArrayList<>();

        String file = System.getProperty("user.dir");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do ficheiro (.txt): ");
    
        if (isWindows()) {
            file = file + "\\aula11\\" + sc.nextLine() + ".txt";
        } else if (isUnix() || isMacOS()) {
            file = file + "/aula11/" + sc.nextLine() + ".txt";
        } else {
            file = file + sc.nextLine() + ".txt";
        }
    
        sc.close();
        Scanner scf;
        try {
            scf = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            scf = null;
            System.out.println(file + " not found.");
            System.exit(0);
        }

        while(scf.hasNext()) {
            content.add(scf.next().replaceAll("\\.+$", "").replaceAll(",", ""));
        }
        Set<String> uniqueWords = getSet(content);
        System.out.println("Numero Totla de palavras: " + content.size());
        System.out.println("Numero de diferentes palavras: " + uniqueWords.size());
        Map<String, Long> map = getMap(content);
        System.out.println("\nMap:");
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<String, Long> sortedMap = getMapSorted(map);
        System.out.println("\nSorted Map:");
        for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }    
    }
    
    public static Map<String, Long> getMapSorted(Map<String, Long> unsortedMap) {
        Map<String, Long> map = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return map;
    }

    public static Map<String, Long> getMap(List<String> content) {
        Map<String, Long> map = content.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return map;
    }

    public static Set<String> getSet(List<String> content) {
        return content.stream().collect(Collectors.toSet());
    }

    public static String getOsName() {
        String OS = null;
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }

    public static boolean isWindows() { return getOsName().startsWith("Windows"); }

    public static boolean isUnix() { return getOsName().startsWith("Linux"); }

    public static boolean isMacOS() { return getOsName().startsWith("MacOS"); }
}