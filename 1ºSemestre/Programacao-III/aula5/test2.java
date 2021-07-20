package aula5;

import java.util.*;

public class test2{
    public static void main(String[] args)  {
        Ligeiros l1 = new Ligeiros(1500, 250, 4, 3500, 100, 10,"ABCDEF");
        Motociclo m2 = new Motociclo(125, 200, 2, 70,100, 6,"BDGEFR");
        MotoPolicia mp1 = new MotoPolicia(340, 200, 2, 1400, 80, 8, "JLKONF", "INEM", 12345);
        CarroPolicia cp2 = new CarroPolicia(1500, 250, 4, 3500, 100, 10,"12SADF","PJ",1234);
        BicicletaPolicia b1 = new BicicletaPolicia("A", "PSP", 123);
        Vector<Veiculos> veiculos = new Vector<>();
        veiculos.add(l1);
        veiculos.add(m2);
        veiculos.add(mp1);
        veiculos.add(cp2);
        veiculos.add(b1);
        System.out.println(b1.getCilindrada());
        System.out.println(b1.getTipo());
        System.out.println(l1.getCilindrada());
        System.out.println(l1.getCombustivel());
        System.out.println(cp2.getID());
        System.out.println(cp2.getCombustivel());
        System.out.println(l1.toString());
        System.out.println(m2.toString());
        System.out.println(mp1.toString());

    }
}
