package aula9;

public class GeladoSimples implements Gelado{
    String sabor;

    public GeladoSimples(String s) {
        this.sabor = s;
    }

    @Override
    public void base(int n) {
        System.out.print("\n" + n + " bolas de gelado de " + sabor);
    }
}
