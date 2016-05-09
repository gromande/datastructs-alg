package com.groman.prep.datastruct.lists;

public class DoublyLinkedList<E> {

    private int size = 0;
    private Node<E> header;
    private Node<E> tail;
    
    public DoublyLinkedList() {
        //Initialize sentinels
        header = new Node<E>(null, null, null);
        tail = new Node<E>(null, header, null);
        header.setNext(tail);
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }
    
    public E last() {
        if (isEmpty()) return null;
        return tail.getPrev().getElement();
    }
    
    public void addFirst(E element) {        
        addBetween(element, header, header.getNext());
    }
    
    public void addLast(E element) {
        addBetween(element, tail.getPrev(), tail);
    }
    
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }
    
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(tail.getPrev());
    }
    
    private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
        predecessor.setNext(new Node<E>(element, predecessor, successor));
        successor.setPrev(predecessor.getNext());
        size++;
    }
    
    private E remove(Node<E> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        return node.getElement();
   }
    
    /* Nested Node class */
    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;
        
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
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

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

}
