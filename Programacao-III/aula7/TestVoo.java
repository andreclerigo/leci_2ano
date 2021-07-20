package aula7;

import java.io.*;
import java.nio.file.*;
public class TestVoo {
    public static void main(String[] args) throws IOException{
        Airport aeroporto = new Airport("C:\\Users\\AndreClerigo\\OneDrive - Universidade de Aveiro\\UA\\2º Ano\\Programacao-III\\aula7\\voos.txt", "C:\\Users\\AndreClerigo\\OneDrive - Universidade de Aveiro\\UA\\2º Ano\\Programacao-III\\aula7\\companhias.txt");
        
        aeroporto.printTable(aeroporto.getTable());
        aeroporto.printDelay(aeroporto.getDelay());
        aeroporto.printCitys(aeroporto.getCitys());
        
        Path file1 = Paths.get("C:\\Users\\AndreClerigo\\OneDrive - Universidade de Aveiro\\UA\\2º Ano\\Programacao-III\\aula7\\Infopublico.txt");
        Path file2 = Paths.get("C:\\Users\\AndreClerigo\\OneDrive - Universidade de Aveiro\\UA\\2º Ano\\Programacao-III\\aula7\\Cidades.txt");
        Files.write(file1, aeroporto.getTable());
        Files.write(file2, aeroporto.getCitysList());
    }
}