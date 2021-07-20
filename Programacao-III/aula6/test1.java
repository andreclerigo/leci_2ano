package aula6;

import aula5.UtilCompare;

public class test1 {
    public static void main(String[] args) {
        Prato[] pratos = new Prato[2];
        Prato p1 = new Prato("Prato Misto");
        pratos[1] = p1;
        Carne c = new Carne(Carne.Tipo.Vaca, 100, 300, 0.1);
        Peixe p = new Peixe(Peixe.Tipo.Congelado, 100, 200, 0.1);
        Legume l = new Legume("Beringela", 100, 50, 0.1);
        Cereal cer = new Cereal("Milho", 150, 80, 0.5);
        
        p1.addIngrediente(c);
        p1.addIngrediente(p);
        p1.addIngrediente(l);
        p1.addIngrediente(cer);
        System.out.println(p1.toString());

        System.out.println(p1.getProteinasTotais());

        PratoVegetariano p2 = new PratoVegetariano("Prato Vegetariano");
        pratos[0] = p2;
        p2.addIngrediente(l);
        p2.addIngrediente(cer);
        System.out.println(p2.toString());

        System.out.println(p2.getProteinasTotais());

        UtilCompare.sortArray(pratos);
        for(Prato o : pratos) {
            System.out.println(o.nome);
        }
    }
}
