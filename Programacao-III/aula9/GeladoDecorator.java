package aula9;

public class GeladoDecorator implements Gelado {
    protected Gelado g;

    public GeladoDecorator(Gelado g) {
        this.g = g;
    }

    @Override
    public void base(int n) {
        g.base(n);
    }
}
