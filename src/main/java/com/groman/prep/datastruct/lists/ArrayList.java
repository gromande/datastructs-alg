package com.groman.prep.datastruct.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends SimpleArrayList<E> implements Iterable<E> {

    private class ArrayIterator implements Iterator<E> {
        
        private int j = 0;
        private boolean removable = false;

        public boolean hasNext() {
            return j < size;
        }

        public E next() {
            if (j == size) throw new NoSuchElementException("No next element");
            removable = true;
            return data[j++];
        }
        
        public void remove() {
            if (!removable) throw new IllegalStateException("Nothing to remove");
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }
        
    }
    public ArrayList() {
        super();
    }

    public ArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index, size + 1);
        if (size == data.length) {
            resize(2*data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }
    
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

}
