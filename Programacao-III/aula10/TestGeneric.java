package aula10;

import aula9.Pessoa;
import aula9.Data;
import aula3.Forma;  
import aula3.Circulo;
import aula3.Rectangulo; //Atualizado
import aula3.Quadrado;   //Atualizado
import java.util.Iterator;

public abstract class TestGeneric {
    public static void main(String[] args) {
        // Ficheiro dado pelos professores
        VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>();
        for(int i = 0; i < 10; i++) {
            vp.addElem(new Pessoa("Bebé no Vector " + i, 1000 + i, Data.today()));
        }
        
        Iterator<Pessoa> vec = vp.iterator();
        printSet(vp.iterator());
        
        ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>();
        while( vec.hasNext() )
            lp.addElem( vec.next() );

        Iterator<Pessoa> lista = lp.iterator();
        while( lista.hasNext() )
            System.out.println( lista.next() );


        // Formas
        ListaGeneric<Forma> figList = new ListaGeneric<Forma>();
        figList.addElem(new Circulo (1,3, 1));
        figList.addElem(new Quadrado(3, 4, 2));
        figList.addElem(new Rectangulo(1,2, 2,5));
        printSet(figList.iterator());
        System.out.println("Soma da Area de Lista de Figuras: "+ sumArea(figList));

        // Partindo do principio que Quadrado extends Rectangulo: 
        ListaGeneric<Rectangulo> quadList = new ListaGeneric<Rectangulo>();
        quadList.addElem(new Quadrado(3,4, 2));
        quadList.addElem(new Rectangulo(1,2, 2,5));
        System.out.println("Soma da Area de Lista de Quadrados: "+ sumArea(quadList));
    }

    private static double sumArea(ListaGeneric<? extends Forma> f) {
        double area = 0;

        Iterator<? extends Forma> i = f.iterator();
        while(i.hasNext()) {
            area += i.next().area();
        }

        return area;
    }

    private static <T> void printSet(Iterator<T> i) {
        while(i.hasNext()) 
            System.out.println(i.next().toString());
    }
}