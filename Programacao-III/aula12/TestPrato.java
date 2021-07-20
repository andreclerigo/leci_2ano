package aula12;

public class TestPrato {
    public static void main(String[] args) {
        Carne c1 = new Carne(Carne.Tipo.Vaca, 100, 500, 300);
        Peixe p1 = new Peixe(Peixe.Tipo.Fresco, 80, 100, 300);
        Cereal cr1 = new Cereal("Primeiro Cereal", 120, 80, 80);
        Legume l1 = new Legume("Pepino", 20, 20, 250);
        Legume l2 = new Legume("Alface", 10, 10, 30);

        Prato prato1 = new Prato("Tudo");
        prato1.addIngrediente(c1);
        prato1.addIngrediente(p1);
        prato1.addIngrediente(cr1);
        prato1.addIngrediente(l1);
        prato1.addIngrediente(l2);
        System.out.println(prato1.getProteinasTotais());
        System.out.println(prato1.getPesoTotal());
        System.out.println(prato1.getCaloriasTotais());
        
        PratoVegetariano prato2 = new PratoVegetariano("Vegetariano");
        prato2.addIngrediente(c1);
        System.out.println(prato2.toString());
    }
}
