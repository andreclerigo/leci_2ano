package aula1;

public class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double x(){
        return x;
    }

    public double y(){
        return y;
    }

    @Override
    public String toString() {
        return "Ponto(" + x + ", " + y + ')';
    }
}
