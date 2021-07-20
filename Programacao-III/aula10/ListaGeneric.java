package aula10;

import java.util.*;

public class ListaGeneric<T> {
    private LinkedList<T> lista = new LinkedList<>();

    public boolean addElem(T elem) {
        if(this.lista.add(elem)) 
            return true;
        else 
            return false;
    }

    public boolean removeElem(T elem) {
        if(this.lista.remove(elem)) 
            return true;
        else 
            return false;
    }

    public int totalElem() {
        return lista.size();
    }

    Iterator<T> iterator() {
        return new VectorIterator();
    }

    private class VectorIterator implements Iterator<T> {
        int n = 0;
        
        @Override
        public boolean hasNext() {
            return n < lista.size();
        }
        
        @Override
        public T next() {
            return lista.get(n++);
        }
    }
}