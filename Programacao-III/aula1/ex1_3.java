package aula1;

import java.util.*;

public class ex1_3 {

    public static Scanner sc = new Scanner(System.in);
    

	public static void main(String[] args) {

        int op;
        
        do{
            System.out.println("\nWelcome to the Geometric Figure Creater");
            System.out.println("Choose your option:");
            System.out.println("1--> Compute the perimeter of a parallelogram");
            System.out.println("2--> Compute the perimeter of a circle");
            System.out.println("3--> Check if two circles intersect");
            System.out.println("4--> Quit");
            op = sc.nextInt();
            switch(op){
                case 1:
                        parallelogramPerimeter();
                        break;
                case 2:
                        circlePerimiter();
                        break;
                case 3:
                        circleIntersect();
                        break;
            }

        }while(op!=4);
	}

	private static void parallelogramPerimeter(){
		System.out.println("Insert height:");
		int height = sc.nextInt();

		System.out.println("Insert width:");
		int width = sc.nextInt();

		int perimeter = height*2 + width*2;

		System.out.println("\nThe perimeter of this parallelogram is " + perimeter );
	}

	private static void circlePerimiter(){
		System.out.println("Insert the circle radix: ");
		int radix = sc.nextInt();

        Circulo circulo = new Circulo(1,1,radix);

		System.out.printf("\nThe perimeter of this circle is " + circulo.perimeterCircle());
	}

	private static void circleIntersect(){
		System.out.println("Insert x1:");
		int x1 = sc.nextInt();

		System.out.println("Insert y1:");
		int y1 = sc.nextInt();

		System.out.println("Insert the radix of the first circle:");
		int r1 = sc.nextInt();

		System.out.println("Insert x2:");
		int x2 = sc.nextInt();

		System.out.println("Insert y2:");
		int y2 = sc.nextInt();

		System.out.println("Insert the radix of the second circle:");
		int r2 = sc.nextInt();

		Circulo circulo1 = new Circulo(x1,y1,r1);
		Circulo circulo2 = new Circulo(x2,y2,r2);


        System.out.println("\nEqual: " + circulo1.equalCircles(circulo2) + "\nIntersect: " + circulo1.intersectCircles(circulo2) + 
                "\nSame Dimensions: " + circulo1.sameDimension(circulo2));
				
	}
}