package aula9;

import java.util.*;

public class ListaPessoas {
    LinkedList<Pessoa> pessoas = new LinkedList<>();

    public boolean addPessoa(Pessoa p) {
        if(this.pessoas.add(p)) 
            return true;
        else 
            return false;
    }

    public boolean removePessoa(Pessoa p) {
        if(this.pessoas.remove(p)) 
            return true;
        else 
            return false;
    }

    public int totalPessoas() {
        return pessoas.size();
    }

    Iterator<Pessoa> iterator() {
        return new VectorIterator();
    }

    BFIterator<Pessoa> bfiterator() {
        return new VectorPessoaBFIterator();
    }


    private class VectorIterator implements Iterator<Pessoa> {
        int i = 0;
        
        @Override
        public boolean hasNext() {
            return i < pessoas.size();
        }

        @Override
        public Pessoa next() {
            return pessoas.get(i++);
        }
    }


    private class VectorPessoaBFIterator implements BFIterator<Pessoa> {
        int i = 0;

        @Override
        public boolean hasPrevious() {
            return i > 0;
        }

        @Override
        public Pessoa previous() {
            return pessoas.get(--i);
        }

        @Override
        public boolean hasNext() {
            return i < pessoas.size();
        }

        @Override
        public Pessoa next() {
            return pessoas.get(i++);
        }
    }
}