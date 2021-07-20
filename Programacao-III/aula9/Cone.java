package aula9;

public class Cone extends GeladoDecorator {
    public Cone(Gelado g) {
        super(g);
    }
    
    public void base(int n) {
        g.base(n);
        System.out.print(" em cone");
    }
}
