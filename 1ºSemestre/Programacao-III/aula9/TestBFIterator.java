package aula9;

public abstract class TestBFIterator {
    public static void main(String[] args) {
        VectorPessoas vp = new VectorPessoas();
        for(int i = 0; i < 10; i++)
            vp.addPessoa(new Pessoa("Bebé no Vector " + i, 1000 + i, Data.today()));

        BFIterator<Pessoa> vec = vp.bfiterator();
        System.out.println("Do primeiro ao ultimo usando array.");
        while( vec.hasNext() )
            System.out.println( vec.next() );

        System.out.println("Do ultimo ao primeiro usando array.");
        while( vec.hasPrevious() )
            System.out.println( vec.previous() );
        
        // Usando LinkedList
        ListaPessoas lp = new ListaPessoas();
        for (int i = 0; i < 10; i++)
            lp.addPessoa(new Pessoa("Bebé na Lista " + i, 2000 + i, Data.today()));
        
        BFIterator<Pessoa> lista = lp.bfiterator();
        System.out.println("Do primeiro ao ultimo usando LinkedList.");
        while( lista.hasNext() )
            System.out.println( lista.next() );

        System.out.println("Do ultimo ao primeiro usando LinkedList.");
        while( lista.hasPrevious() )
            System.out.println( lista.previous() );
    }
}
