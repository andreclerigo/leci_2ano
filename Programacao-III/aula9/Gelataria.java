package aula9;

public class Gelataria {
    public static void main(String[] args) {
        Gelado ice;

        ice = new GeladoSimples("Baunilha");
        ice.base(2);
        new Copo(ice).base(3);
        new Cone(ice).base(1);
        new Topping(ice, "Canela").base(2);
        ice = new Topping(ice, "Nozes");
        ice.base(1);
        ice = new Topping(new Cone(new GeladoSimples("Morango")), "Fruta");
        ice.base(2);
        ice = new Topping(
                new Topping(
                    new Copo(new GeladoSimples("Manga")), "Chocolate"), "Natas");
        ice.base(4);
        ice = new Topping(ice, "Pepitas");
        ice.base(3);
    }
}
