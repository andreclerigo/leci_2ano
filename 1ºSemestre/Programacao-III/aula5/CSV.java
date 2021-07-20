package aula5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import aula1.Data;

public class CSV implements AgendaHandler{
    Pessoa[] Agenda = new Pessoa[500];
    int index = 0;
    boolean teleExiste = false;

    @Override
    public Pessoa[] readAgenda(File[] files) throws IOException {
        for (File f : files) {
            Scanner scFile = new Scanner(f);
            
            if (!scFile.nextLine().equals("CSV")) {
                scFile.close();
            } else {
                while (scFile.hasNextLine()) {
                    teleExiste = false;
                    String[] campos = new String[3];
                    String s = scFile.nextLine();
                    campos = s.split("\t");
                    
                    String[] ddmmyy = new String[3];
                    ddmmyy = campos[2].split("/");
                    int[] dataInteiro = new int[3];
                    
                    int i = 0;
                    for (String data : ddmmyy) {
                        dataInteiro[i] = Integer.parseInt(data);
                        i++;
                    }
                    
                    Pessoa p = new Pessoa(campos[0], new Data(dataInteiro[0], dataInteiro[1], dataInteiro[2]), Integer.parseInt(campos[1]));

                    for (Pessoa pTest : Agenda) {
                        if (pTest == null) break;
                        if(p.getNTelefone() == pTest.getNTelefone()) {
                            teleExiste = true;
                            break;
                        }
                    }
                    if (!teleExiste) Agenda[index++] = p;
                }
            }
            scFile.close();
        }
        return Agenda;
    }

    @Override
    public void writeAgenda(Pessoa[] agenda) throws IOException {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        File fout = new File("aula5/CSVOut"+ dateFormat.format(date)+ ".txt");

        PrintWriter pw = new PrintWriter(fout);

        for (Pessoa p : agenda) {
            if (p != null) pw.println(p.getnome() + "\t" + p.getNTelefone() + "\t" + p.getdataNasc());
        }

        Agenda = null;
        index = 0;
        pw.close();
    }
}