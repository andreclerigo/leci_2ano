package aula10;

import java.util.*;

public class VectorGeneric<T> {
    private int n;
    private Object[] objects = new Object[1];
    
    public VectorGeneric() {
        objects[0] = null;
        n = 0;
    }

    public boolean addElem(T elem) {
        if(n != 0) {
            Object[] newObjects = new Object[n+1];
            System.arraycopy(objects, 0, newObjects, 0, n);
            newObjects[n] = elem;
            objects = newObjects;
        } else {
            objects[0] = elem;
        }
        
        n++;
        return true;
    }

    public boolean removeElem(T elem) {
        for(int i = 0; i < n; i++) {
            if (objects[i] == elem) {
                n--;
                for (int j = i; j < n; j++)
                    objects[j] = objects[j+1];
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return n;
    }

    Iterator<T> iterator() {
        return new VectorIterator();
    }

    private class VectorIterator implements Iterator<T> {
        private int indice;
    
        VectorIterator() {  indice = 0; }
    
        @Override
        public boolean hasNext() {  return (indice < n); }
    
        @Override
        public T next() {
            if (hasNext()) {
                @SuppressWarnings("unchecked")
                T r = (T) objects[indice];
                indice++;
                return r;
            }
            throw new IndexOutOfBoundsException("only " + n + " elements");
        }
    
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operação não suportada!");
        }
    }
}