package com.groman.prep.datastruct.stack;

public class ArrayStack<E> implements Stack<E> {
    
    private static final int CAPACITY = 1000;
    
    private E[] data;
    private int top = -1;

    private int size;
    
    public ArrayStack() {
        this(CAPACITY);
    }
    
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    public int size() {
        return (top + 1);
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public void push(E element) {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++top] = element;
    }
    
    public E top() {
        if (isEmpty()) return null;
        return data[top];
    }
    
    public E pop() {
        if (isEmpty()) return null;
        E element = data[top];
        data[top--] = null;
        return element;
    }

}
