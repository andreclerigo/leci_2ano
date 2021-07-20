package aula1;

public class Circulo {
    private double raio;
    private Ponto centro;

    public Circulo(double x, double y, double raio){
        this.raio = raio;
        this.centro = new Ponto(x,y);
    }

    public Circulo(Ponto centro, double raio){
        this.raio = raio;
        this.centro = centro;
    }

    public double raio(){
        return raio;
    }

    public Ponto centro(){
        return centro;
    }

    public double perimeterCircle() {
		return 2 * Math.PI * raio;
    }
    
    public boolean equalCircles(Circulo circulo2){
        boolean equalX,equalY,equalRaio,equal = false;
        equalX =  centro.x() == circulo2.centro.x();
        equalY = centro.y() == circulo2.centro.y();
        equalRaio = raio == circulo2.raio;

        if(equalX && equalY && equalRaio){
            equal = true;
        }

        return equal;
    }

    public boolean sameDimension(Circulo circulo2){
        return raio == circulo2.raio();
    }

    public boolean intersectCircles(Circulo circulo2){
        double x1 = centro.x() - circulo2.centro.x();
        double x2 = centro.y() - circulo2.centro.y();

        return Math.sqrt(Math.pow(x1,2) + Math.pow(x2,2)) < raio() + circulo2.raio();
    }

    @Override
	public String toString() {
		return "Circulo(" + "raio=" + raio + ", centro=" + centro +')';
	}

}
