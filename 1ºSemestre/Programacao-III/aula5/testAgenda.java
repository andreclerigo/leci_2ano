package aula5;

import java.io.*;
//args aula5/test2Nokia.txt aula5/test2CSV.txt (aula5/test1vCard.txt)
public class testAgenda {
    public static void main(String[] args) throws IOException {
        String[] fileNames = args;

        for (String fileName : fileNames) {
            if(!FileHandler.validFile(fileName))
                System.exit(0);
        }

        File[] files = new File[fileNames.length];
        files[0] = new File(fileNames[0]);                     //aula5/test2Nokia.txt
        files[1] = new File(fileNames[1]);                     //aula5/test2CSV.txt
        //files[2] = new File(fileNames[2]);                     //aula5/test1vCard.txt

        //Para Agendas do mesmo tipo dá merge da informação
        Pessoa[] AgendaNokia = new Nokia().readAgenda(files);
        //Pessoa[] AgendavCard = new vCard().readAgenda(files);
        //Pessoa[] AgendaCSV = new CSV().readAgenda(files);
        new vCard().writeAgenda(AgendaNokia);                       //vCardOut
        new CSV().writeAgenda(AgendaNokia);                         //CSVOut
        //new vCard().writeAgenda(AgendaCSV);                         
        //new Nokia().writeAgenda(AgendaCSV);                        
        //new CSV().writeAgenda(AgendavCard);                         
        //new Nokia().writeAgenda(AgendavCard);                       
    }
}