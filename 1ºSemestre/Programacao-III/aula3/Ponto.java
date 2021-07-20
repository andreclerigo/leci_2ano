package aula3;

public class Ponto {
    private double x, y;

    Ponto() {
        this.x = 0; this.y = 0;
    }

    Ponto(double x, double y) {
        this.x = x; this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void add(Ponto point) {
        this.x += point.x;
        this.y += point.y;
    }

    public void subtract(Ponto point) {
        this.x -= point.x;
        this.y -= point.y;
    }

    public Ponto halfWayTo(Ponto point) {
        return new Ponto((this.x + point.x)/2.0,(this.y + point.y)/2.0);
    }

    public double distanceTo(Ponto point) {
        return Math.sqrt(Math.pow(this.x-point.x,2) + Math.pow(this.y-point.y,2));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ponto) {
            Ponto temp = (Ponto)obj;
            return this.x == temp.x && this.y == temp.y;
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
