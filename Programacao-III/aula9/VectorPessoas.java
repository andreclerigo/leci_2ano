package aula9;

import java.util.*;

public class VectorPessoas {
    private Pessoa[] listaPessoas;
    private int nPessoas;
    private final int ALLOC = 50;
    private int dimClasse = ALLOC;

    public VectorPessoas() {
        listaPessoas = new Pessoa[ALLOC];
        nPessoas = 0;
    }

    public boolean addPessoa(Pessoa est) {
        if (est == null)
            return false;

        if (nPessoas > dimClasse) {
            dimClasse += ALLOC;
            Pessoa[] newArray = new Pessoa[dimClasse];
            System.arraycopy(listaPessoas, 0, newArray, 0, nPessoas);
            listaPessoas = newArray;
        }

        listaPessoas[nPessoas++] = est;
        return true;
    }

    public boolean removePessoa(Pessoa p) {
        for (int i = 0; i < nPessoas; i++) {
            if (listaPessoas[i] == p) {
                nPessoas--;
                for (int j = i; j < nPessoas; j++) 
                    listaPessoas[j] = listaPessoas[j + 1];
                return true; 
            }
        }
        return false;
    }

    public int totalPessoas() {
        return nPessoas;
    }

    public Pessoa getPessoa(int i) {
        return listaPessoas[i];
    }

    Iterator<Pessoa> iterator() {
        return (this).new VectorIterator();
    }

    BFIterator<Pessoa> bfiterator() {
        return (this).new VectorPessoaBFIterator();
    }


    public class VectorIterator implements Iterator<Pessoa>{ 
        private int indice;
    
        VectorIterator() {  indice = 0; }
    
        @Override
        public boolean hasNext() {  return (indice < nPessoas); }
    
        @Override
        public Pessoa next() {
            if (hasNext()) {
                Pessoa r = listaPessoas[indice];
                indice++;
                return r;
            }
            throw new IndexOutOfBoundsException("only " + nPessoas + " elements");
        }
    
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operação não suportada!");
        }
    }


    private class VectorPessoaBFIterator implements BFIterator<Pessoa> {
        private int indice;
    
        VectorPessoaBFIterator() {  indice = 0; }

        @Override
        public boolean hasPrevious() {
            return indice > 0;
        }

        @Override
        public Pessoa previous() {
            return listaPessoas[--indice];
        }

        @Override
        public boolean hasNext() {
            return indice < nPessoas;
        }

        @Override
        public Pessoa next() {
            return listaPessoas[indice++];
        }
    }
}