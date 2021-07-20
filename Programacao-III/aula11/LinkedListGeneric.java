package aula11;

import java.util.*;

public class LinkedListGeneric<T> {
    private List<T> list = new LinkedList<>();

    public boolean addElem(T elem) {
        if(this.list.add(elem)) 
            return true;
        else 
            return false;
    }

    public boolean removeElem(T elem) {
        if(this.list.remove(elem)) 
            return true;
        else 
            return false;
    }

    public int totalElem() {
        return this.list.size();
    }

    Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        int n = 0;
        
        @Override
        public boolean hasNext() {
            return n < list.size();
        }
        
        @Override
        public T next() {
            return ((LinkedList<T>) list).get(n++);
        }
    }
}