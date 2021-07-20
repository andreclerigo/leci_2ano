package aula3;

public class Circulo extends Forma {
    private double radius;

    public Circulo() {
        this.center = new Ponto();
        this.radius = 0;
    }

    public Circulo(double x, double y, double r) {
        this.center = new Ponto(x, y);
        this.radius = r;
    }

    public Circulo(Ponto c, double r) {
        this.center = c;
        this.radius = r;
    }

    public Circulo(double raio){
        this.radius = raio;
        this.center = new Ponto();
    }

    public Circulo(Circulo circulo2){
        this.radius = circulo2.radius;
        this.center = circulo2.getCenter();
    }

    public Ponto getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Ponto center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2*Math.PI * radius;
    }

    public boolean intercept(Circulo circle) {
        return center.distanceTo(circle.center) <= (this.radius + circle.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circulo) {
            Circulo temp = (Circulo)obj;
            return this.center.equals(temp.center) && this.radius == temp.radius;
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public String toString() {
        return String.format("Circulo = { center : %s, radius : %.2f, area : %.2f, perimeter : %.2f }",
            center, radius, area(), perimeter()
        );
    }
}
