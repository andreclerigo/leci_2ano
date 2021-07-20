package aula3;

public class Test2 {
     public static void main(String[] args)  {
        Circulo c1 = new Circulo (2);
        new Circulo(1, 3, 2);
        Circulo c3 = new Circulo (c1);
        System.out.println(c1 + "tem area: " + c1.area() + " e perimetro: " + c1.perimeter());
        System.out.println(c3 + "tem area: " + c3.area() + " e perimetro: " + c3.perimeter());
        System.out.println("c1 equals to c3? -> " + c1.equals(c3));
        // True
        Quadrado q1 = new Quadrado(2);
        Quadrado q2 = new Quadrado(3,4,2);
        Quadrado q3 = new Quadrado(q2);
        System.out.println(q1 + "tem area: " + q1.area() + " e perimetro: " + q1.perimeter());
        System.out.println(q3 + "tem area: " + q3.area() + " e perimetro: " + q3.perimeter());
        System.out.println("q1 equals to q3? -> " + q1.equals(q3));
        // False
        Rectangulo r1 = new Rectangulo(2,3);
        Rectangulo r2 = new Rectangulo(3,4,2,3);
        Rectangulo r3 = new Rectangulo(r2); 
        System.out.println(r1 + "tem area: " + r1.area() + " e perimetro: " + r1.perimeter());
        System.out.println(r3 + "tem area: " + r3.area() + " e perimetro: " + r3.perimeter());
        System.out.println("r2 equals to r3? -> " + r2.equals(r3));// True}} 
    } 

}
