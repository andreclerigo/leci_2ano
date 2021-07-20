package aula4;

import aula3.Circulo;
import aula3.Forma;
import aula3.Ponto;
import aula3.Quadrado;
import aula3.Rectangulo;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Circulo c1 = new Circulo(2);
        Circulo c2 = new Circulo(1, 3, 2);
        Quadrado q1 = new Quadrado(2);
        Quadrado q2 = new Quadrado(3, 4, 2);
        Rectangulo r1 = new Rectangulo(2, 3);
        Rectangulo r2 = new Rectangulo(3, 4, 2, 3);

        ColecaoFiguras col = new ColecaoFiguras(42.0); // MaxArea

        System.out.println(col.addFigura(c2)); // true
        System.out.println(col.addFigura(r1)); // true
        System.out.println(col.addFigura(r1)); // false
        System.out.println(col.addFigura(r2)); // true
        System.out.println(col.addFigura(c1)); // true
        System.out.println(col.addFigura(q2)); // true
        System.out.println(col.addFigura(q1)); // true
        System.out.println(col.delFigura(r1)); // true
        System.out.println(col.addFigura(q1)); // false

        System.out.println("\nÁrea Total da Lista de Figuras: " + col.areaTotal());
        System.out.println("\nLista de Figuras:");

        for (Forma f : col.getFiguras())
            System.out.println(f);

        System.out.println("\n\nCirculos na Lista de Figuras:");

        for (Forma f : col.getFiguras())
            if (f instanceof Circulo)
                System.out.println(f);

        System.out.println("\n\nCentro das Figuras:");

        for (Ponto p : col.getCentros())
            System.out.println(p);
    }
}
