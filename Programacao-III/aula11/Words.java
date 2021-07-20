package aula11;

import java.util.*;
import java.io.*;

public class Words {
    public static void main(String[] args) {
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

        Set<String> str = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> sortedMap = new TreeMap<>((a, b) -> a.compareTo(b));
        List<Map.Entry<String, Integer>> sortedMapByValue = new ArrayList<>();
        int i = 0;

		while(scf.hasNext()) {
            String line = scf.next().replaceAll("\\.+$", "");
            if (line.endsWith(","))
                line = line.substring(0, line.length() - 1);

			if(!str.add(line))
                i++;
                
            if(map.containsKey(line)) {
                map.put(line, map.get(line) + 1);
                sortedMap.put(line, sortedMap.get(line) + 1);

                for(Map.Entry<String, Integer> entry : sortedMapByValue) {
                    if (entry.getKey().equals(line))
                        entry.setValue(entry.getValue() + 1);
                }
            } else {
                map.put(line, 1);
                sortedMap.put(line, 1);
                sortedMapByValue.add(new AbstractMap.SimpleEntry<String, Integer>(line, 1));
            }
        }
        scf.close();

		System.out.println("Número total de palavras: " + (i + str.size()));
		System.out.println("Número de palavras diferentes: " + str.size());
        
        System.out.println("\nMap:");
		Set<String> keys = map.keySet();
		Iterator<String> keysIterator = keys.iterator();
		
		while(keysIterator.hasNext()) {
			String k = keysIterator.next();
			System.out.println(k + ": " + map.get(k));
        }
        
        System.out.println("\nSorted Map:");
        Set<String> sortedKeys = sortedMap.keySet();
		Iterator<String> sortedKeysIterator = sortedKeys.iterator();
		
		while(sortedKeysIterator.hasNext()) {
			String k = sortedKeysIterator.next();
			System.out.println(k + ": " + map.get(k));
        }
        
        Collections.sort(sortedMapByValue, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println("\nSorted Map by value:");
        for(Map.Entry<String, Integer> entry : sortedMapByValue) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
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