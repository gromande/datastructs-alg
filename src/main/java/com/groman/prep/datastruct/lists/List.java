package com.groman.prep.datastruct.lists;

public interface List<E> {
    
    public int size();
    
    public boolean isEmpty();
    
    public E get(int index) throws IndexOutOfBoundsException;
    
    public E set(int index, E element) throws IndexOutOfBoundsException;
    
    public void add(int index, E element) throws IndexOutOfBoundsException;
    
    public E remove(int index) throws IndexOutOfBoundsException;

}
