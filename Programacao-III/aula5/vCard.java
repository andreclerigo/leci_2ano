package aula5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import aula1.Data;

public class vCard implements AgendaHandler {
    Pessoa[] Agenda = new Pessoa[500];
    int index = 0;
    boolean teleExiste = false;

    @Override
    public Pessoa[] readAgenda(File[] files) throws IOException {
        for (File f : files) {
            Scanner scFile = new Scanner(f);
            
            if (!scFile.nextLine().equals("vCard")) {
                scFile.close();
                System.exit(1);
            } else {
                while (scFile.hasNextLine()) {
                    teleExiste = false;
                    String[] campos = new String[4];
                    String s = scFile.nextLine();
                    campos = s.split("#");
                    
                    String[] ddmmyy = new String[4];
                    ddmmyy = campos[3].split("/");
                    int[] dataInteiro = new int[4];

                    int i = 0;
                    for (String data : ddmmyy) {
                        dataInteiro[i] = Integer.parseInt(data);
                        i++;
                    }

                    Pessoa p = new Pessoa(campos[1], new Data(dataInteiro[0], dataInteiro[1], dataInteiro[2]), Integer.parseInt(campos[2]));

                    for (Pessoa pTest : Agenda) {
                        if (pTest == null) break;
                        if(p.getNTelefone() == pTest.getNTelefone()) {
                            teleExiste = true;
                            break;
                        }
                    }

                    if (!teleExiste) Agenda[index++] = p;
                }
                scFile.close();
            }
        }
        return Agenda;
    }

    @Override
    public void writeAgenda(Pessoa[] agenda) throws IOException{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        File fout = new File("aula5/vCard"+ dateFormat.format(date)+ ".txt");

        PrintWriter pw = new PrintWriter(fout);

        for (Pessoa p : agenda) {
            if (p != null) pw.println("#" + p.getnome() + "#" + p.getNTelefone() + "#" + p.getdataNasc());
        }

        Agenda = null;
        index = 0;
        pw.close();
    }
}