package com.groman.prep.datastruct.stack;

import com.groman.prep.datastruct.lists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
    
    SinglyLinkedList<E> list = new SinglyLinkedList<E>();

    public LinkedStack() {
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.addFirst(element);
    }

    public E top() {
        return list.first();
    }

    public E pop() {
        return list.removeFirst();
    }

}
