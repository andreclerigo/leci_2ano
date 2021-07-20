package aula3;

public abstract class Forma implements Comparable<Forma>{
    protected Ponto center;

    public Ponto getCenter() { return this.center; }
    public void setCenter(Ponto center) { this.center = center; }

    public abstract double area();
    
    public abstract double perimeter();

    public int compareTo(Forma f) {
        if(f == null)
            throw new NullPointerException("A Forma é nula");
        return (int)(area() - f.area());
    }
}