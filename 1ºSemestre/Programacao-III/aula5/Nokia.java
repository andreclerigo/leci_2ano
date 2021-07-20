package aula5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import aula1.Data;

public class Nokia implements AgendaHandler {
    Pessoa[] Agenda = new Pessoa[500];
    int index = 0;
    boolean teleExiste = false;

    @Override
    public Pessoa[] readAgenda(File[] files) throws IOException {
        System.out.println(files.length);

        for (File f : files) {
            Scanner scFile = new Scanner(f);
            
            if (!scFile.nextLine().equals("Nokia")) {
                scFile.close();
            }else {
                while (scFile.hasNextLine()) {
                    teleExiste = false;
                    String[] campos = new String[3];

                    for (int i = 0; i < 3; i++) {
                        campos[i] = scFile.nextLine();
                    }
                    if(scFile.hasNextLine()) scFile.nextLine();

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
                        if (pTest == null)
                            break;
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
        File fout = new File("aula5/NokiaOut"+ dateFormat.format(date)+ ".txt");

        PrintWriter pw = new PrintWriter(fout);

        for (Pessoa p : agenda) {
            if (p != null) {
                pw.println(p.getnome());
                pw.println(p.getNTelefone());
                pw.println(p.getdataNasc());
            }
        }

        Agenda = null;
        index = 0;
        pw.close();
    }  
}