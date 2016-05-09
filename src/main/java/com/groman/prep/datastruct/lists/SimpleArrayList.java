package com.groman.prep.datastruct.lists;

public class SimpleArrayList<E> implements List<E> {

    private static final int CAPACITY = 16;
    
    protected E[] data;
    protected int size = 0;
    
    public SimpleArrayList() {
        this(CAPACITY);
    }
    
    public SimpleArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }

    public E set(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E oldElement = data[index];
        data[index] = element;
        return oldElement;
    }

    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        if (size == data.length) throw new IllegalStateException("Array is full");
        //Shift elements to the right
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
        
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E oldElement = data[index];
        //Shift elements to the left
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;
        return oldElement;
    }
    
    protected void checkIndex(int index, int size) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Invalid index " + index + ". Current size " + size);
    }

}
