package aula9;

import java.util.*;

public abstract class TesteIterador {
    public static void main(String[] args) {
        VectorPessoas vp = new VectorPessoas();
        for(int i = 0; i < 10; i++)
            vp.addPessoa(new Pessoa("Bebé no Vector "+ i, 1000 + i, Data.today()));

        Iterator<Pessoa> vec = vp.iterator();
        while( vec.hasNext() )
            System.out.println( vec.next() );

        ListaPessoas lp = new ListaPessoas();
        for (int i = 0; i < 10; i++)
            lp.addPessoa(new Pessoa("Bebé na Lista "+ i, 2000 + i, Data.today()));
        
        Iterator<Pessoa> lista = lp.iterator();
        while( lista.hasNext() )
            System.out.println( lista.next() );
    }
}