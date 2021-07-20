package aula9;

public class Topping extends GeladoDecorator {
    String topping;

    public Topping(Gelado g, String topping) {
        super(g);
        this.topping = topping;
    }
    
    public void base(int n) {
        g.base(n);
        System.out.print(" com " + topping);
    }
}
