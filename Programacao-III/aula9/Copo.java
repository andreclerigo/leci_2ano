package aula9;

public class Copo extends GeladoDecorator {
    public Copo(Gelado g) {
        super(g);
    }
    
    @Override
    public void base(int n) {
        g.base(n);
        System.out.print(" em copo");
    }
}
