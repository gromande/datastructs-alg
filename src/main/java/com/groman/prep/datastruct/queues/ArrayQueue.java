package com.groman.prep.datastruct.queues;

public class ArrayQueue<E> implements Queue<E> {
    
    private static final int CAPACITY = 1000;
    
    private int front = 0;
    private int size = 0;
    private E[] data;

    public ArrayQueue() {
        this(CAPACITY);
    }
    
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        data[(front + size) % data.length] = e;
        size++;
    }

    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }

}
