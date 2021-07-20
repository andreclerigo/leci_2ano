package aula14;

import java.util.*;
import java.util.stream.Collectors;

public class testBB {
    public static void main(String[] args) {
        Empresa bb = new Empresa("BB");
        Empregado e1 = new Empregado("Joao", bb);
        Empregado e2 = new Empregado("Andre", bb);
        Empregado e3 = new Empregado("Pedro", bb);
        Empregado e4 = new Empregado("ATUAMAE", bb);
        Empregado e5 = new Empregado("ATUAMAE", bb);
        Brinquedo b1 = new Brinquedo("Dildo1");
        Brinquedo b2 = new Brinquedo("Dildo2");
        Brinquedo b3 = new Brinquedo("Dildo3");
        Brinquedo b4 = new Brinquedo("Dildo4");
        Brinquedo b5 = new Brinquedo("Dildo5");

        bb.addBrinquedo(b1);
        bb.addBrinquedo(b2);
        bb.addBrinquedo(b3);
        bb.addBrinquedo(b4);
        bb.addBrinquedo(b5);

        List<Empregado> empregados = new ArrayList<>();
        empregados.add(e1);
        empregados.add(e2);
        empregados.add(e3);
        empregados.add(e4);
        empregados.add(e5);
        List<Empregado> empregadosUnicos = empregados.stream().distinct().collect(Collectors.toList());

        List<String> nomeEmpregados = empregadosUnicos.stream().map(Empregado::toString).collect(Collectors.toList());
        System.out.println("\nEmpregados:");
        nomeEmpregados.forEach(System.out::println);  //Debug

        ArrayList<Brinquedo> brinquedosEmpregados = bb.getBrinquedos();
        for(Brinquedo b : brinquedosEmpregados) {
            int i = brinquedosEmpregados.indexOf(b);
            if (i < empregados.size() - 1)
                brinquedosEmpregados.get(i).setNome(nomeEmpregados.get(i));;
        }

        System.out.println("\nBrinquedosEmpregados:");
        brinquedosEmpregados.forEach(System.out::println);
    }
}
