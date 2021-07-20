package aula5;

import java.io.*;

public class FileHandler {
    public static boolean validFile(String fileName) throws IOException {
        File fin = new File(fileName);
        
        if (!fin.exists()) {
            System.out.printf("Ficheiro " +  fileName + "doesn't exist!");
            return false;
        }
        if (fin.isDirectory()) {
            System.out.printf("Ficheiro " + fileName + " is a directory!");
            return false;
        }
        if (!fin.canRead()) {
            System.out.printf("ERRO: ficheiro " + fileName + "não pode ser lido!");
            return false;
        }
        System.out.println("The file is valid");
        return true;
    }
}