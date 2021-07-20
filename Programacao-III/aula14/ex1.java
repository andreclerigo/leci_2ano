package aula14;

import java.util.*;
import java.util.stream.Collectors;

import aula14.Localidade.TipoLocalidade;

public class ex1 {
    public static void main(String[] args) {
        Localidade cid1= new Localidade("Szohod", 31212,TipoLocalidade.Cidade);
        Localidade cid2= new Localidade("Wadesdah", 23423,TipoLocalidade.Cidade);
        Localidade cid3= new Localidade("BedRock", 23423,TipoLocalidade.Vila);
        Estado est1= new Estado("North Borduria", 223133, cid1);
        Estado est2= new Estado("South Borduria", 84321, cid2);
        Pais p1= new Pais("Borduria", est1.getCapital());
        Pais p2= new Pais("Khemed", cid3);
        Pais p3 = new Pais("Aurelia");
        Pais p4 = new Pais("Atlantis");
        p1.addRegiao(est1);
        p1.addRegiao(est2);
        p2.addRegiao(new Provincia("Afrinia", 232475, "Aluko Pono"));
        p2.addRegiao(new Provincia("Eriador", 100000, "Dumpgase Liru"));
        p2.addRegiao(new Provincia("Laurania", 30000, "Mukabamba Dabba"));
        List<Pais> org= new ArrayList<Pais>();
        org.add(p1);
        org.add(p2);
        org.add(p3);
        org.add(p4);
        org.add(p1);
        System.out.println("----Iterar sobre o conjunto");
        Iterator<Pais> itr= org.iterator();

        while(itr.hasNext())
            System.out.println(itr.next());

        System.out.println("-------Iterar sobre o conjunto-For each (java 8)");

        for(Pais pais: org) 
            System.out.println(pais);
        
        System.out.println("----Iterar sobre o conjunto Ordenado");
        List<Pais> ordenado = org.stream().sorted(Comparator.comparing(Pais::getNome)).collect(Collectors.toList());

        ordenado.forEach(System.out::println);

        System.out.println("----Iterar sobre o conjunto Unico");
        List<Pais> uniques = org.stream().distinct().collect(Collectors.toList());
        uniques.forEach(System.out::println);
    }
}