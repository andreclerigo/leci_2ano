package aula3;

public class Quadrado extends Rectangulo {
    Ponto bottomLeft, topRight;
    double side;
    
    public Quadrado() {
        this.center = new Ponto();
        this.bottomLeft = new Ponto();
        this.topRight = new Ponto();
        this.side = 0;
    }

    public Quadrado(Rectangulo r) {
        this.center = r.center;
        this.bottomLeft = r.getbottomLeft();
        this.topRight = r.getTopRight();
        this.side = Math.round(r.area());
    }

    /**
     * 
     * @param bottomLeft
     * @param topRight
     */
    public Quadrado(Ponto bottomLeft, Ponto topRight) {
        Ponto temp = new Ponto(bottomLeft.getX(), topRight.getY());

        assert bottomLeft.distanceTo(temp) == topRight.distanceTo(temp);

        this.center = bottomLeft.halfWayTo(topRight);
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.side = bottomLeft.distanceTo(temp);
    }

    /**
     * 
     * @param side
     */
    public Quadrado(double side){
        this.center = new Ponto();
        this.side = side;
    }
    
    /**
     * 
     * @param p1
     * @param p2
     * @param side
     */
    public Quadrado(double p1, double p2, double side){
        this.center = new Ponto(p1,p2);
        this.side = side;
        this.bottomLeft = new Ponto(p1-side/2, p2-side/2);
        this.topRight = new Ponto(p1+side/2, p2+side/2);
    }

    /**
     * 
     * @param q2
     */
    public Quadrado(Quadrado q2){
        this.center = q2.center;
        this.side = q2.side;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Quadrado) {
            Quadrado temp = (Quadrado)obj;
            return this.center.equals(temp.center) && side == temp.side;
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public String toString() {
        return String.format("Quadrado = { center : %s, bottomLeft : %s, topRight : %s, side : %.2f, area : %.2f, perimeter : %.2f }",
            center, bottomLeft, topRight, side, area(), perimeter()
        );
    }
}
