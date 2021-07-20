package aula3;

public class Rectangulo extends Forma {
    private Ponto bottomLeft, topRight;
    private double height, width;

    public Rectangulo() {
        this.center = new Ponto();
        this.bottomLeft = new Ponto();
        this.topRight = new Ponto();
        this.height = 0;
        this.width = 0;
    }

    public Rectangulo(Ponto bottomLeft, Ponto topRight) {
        this.center = bottomLeft.halfWayTo(topRight);
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.height = topRight.getY() - bottomLeft.getY();
        this.width = topRight.getX() - bottomLeft.getX();
    }

    public Rectangulo(double lado1, double lado2){
        this.bottomLeft = new Ponto(lado1, 0);
        this.topRight = new Ponto(lado1, lado2);
        this.center = bottomLeft.halfWayTo(topRight);
        this.height = lado2;
        this.width = lado1;
    }

    public Rectangulo(double centerx, double centery, double height, double width){
        this.center = new Ponto(centerx, centery);
        this.height = height;
        this.width = width;
        this.bottomLeft = new Ponto(centerx -width/2, centery - height/2);
        this.topRight = new Ponto(centerx +width/2, centery + height/2);
    }

    public Rectangulo(Rectangulo r2){
        this.bottomLeft = r2.bottomLeft;
        this.topRight = r2.topRight;
        this.center = r2.center;
        this.width = r2.width;
        this.height = r2.height;
    }

    public Ponto getbottomLeft() {
        return bottomLeft;
    }

    public Ponto getTopRight() {
        return topRight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double area() {
        return height * width;
    }

    @Override
    public double perimeter() {
        return 2*height + 2*width;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangulo) {
            Rectangulo temp = (Rectangulo)obj;
            return this.center.equals(temp.center) 
                && this.topRight.equals(temp.topRight) 
                && this.bottomLeft.equals(temp.bottomLeft);
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public String toString() {
        return String.format("Rectangulo = { center : %s, topRight : %s, bottomLeft : %s, height : %s, wifth : %s, area : %.2f, perimeter : %.2f }",
        center, topRight, bottomLeft, height, width, area(), perimeter());
    }
}
