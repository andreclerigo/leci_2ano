package aula11;

import java.util.*;

public class ArrayListGeneric<T> {
    private List<T> array = new ArrayList<>();
    
    public boolean addElem(T elem) {
        if(this.array.add(elem)) 
            return true;
        else 
            return false;
    }

    public boolean removeElem(T elem) {
        if(this.array.remove(elem)) 
            return true;
        else 
            return false;
    }

    public int totalElem() {
        return this.array.size();
    }

    Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        int n = 0;
        
        @Override
        public boolean hasNext() {
            return n < array.size();
        }
        
        @Override
        public T next() {
            return array.get(n++);
        }
    }
}