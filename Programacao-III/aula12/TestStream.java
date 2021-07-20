package aula12;

import java.util.*;
import java.util.stream.Collectors;
import aula3.*;

public class TestStream {
    public static void main(String[] args) {
        List<Forma> figs = new ArrayList<>();
        figs.add(new Quadrado(3)); //area:3*3 //per:12
        figs.add(new Rectangulo(4, 3));  //area:4*3 //per:14
        figs.add(new Circulo(2));  //area:4*pi  //per:4*pi

        System.out.println(maiorFigura(figs));
        System.out.println(maiorFiguraPerimeter(figs));
        System.out.println(areaTotal(figs));
        System.out.println(areaTotalSubtype(figs, "Quadrado"));
        System.out.println(areaTotalSubtype(figs, "Rectangulo"));
        System.out.println(areaTotalSubtype(figs, "Circulo"));
    }

    private static Forma maiorFigura(List<Forma> figs) {
        return figs.stream().max(Comparator.comparing(Forma::area)).get();
    }

    private static Forma maiorFiguraPerimeter(List<Forma> figs) {
        return figs.stream().max(Comparator.comparing(Forma::perimeter)).get();
    }

    private static double areaTotal(List<Forma> figs) {
        return figs.stream().collect(Collectors.summingDouble(Forma::area));
    }

    private static double areaTotalSubtype(List<Forma> figs, String subtype) {
        return figs.stream().
                    filter(f -> f.getClass().getSimpleName().equals(subtype)).
                    collect(Collectors.summingDouble(Forma::area));
    }
}
