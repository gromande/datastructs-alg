package com.groman.prep.datastruct.lists;

public class SinglyLinkedList<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public SinglyLinkedList() {
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }
    
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }
    
    public void addFirst(E element) {
        head = new Node<E>(element, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }
    
    public void addLast(E element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            Node<E> oldTail = tail;
            tail = new Node<E>(element, null);
            oldTail.setNext(tail);
            size++;
        }
    }
    
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> oldHead = head;
        if (size == 1) {
            tail = null; 
            head = null;
        } else {
            head = oldHead.getNext();
        }
        size--;
        return oldHead.getElement();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof SinglyLinkedList)) return false;
        SinglyLinkedList that = (SinglyLinkedList) o;
        Node walkThis = head;
        Node walkThat = that.head;
        while (walkThis != null) {
            if (!walkThis.element.equals(walkThat.element)) return false;
            walkThis = walkThis.getNext();
            walkThat = walkThat.getNext();
        }
        return true;
    }

    /* Nested Node class */
    private static class Node<E> {
        private E element;
        private Node<E> next;
        
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
