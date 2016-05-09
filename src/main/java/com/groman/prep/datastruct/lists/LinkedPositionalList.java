package com.groman.prep.datastruct.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.groman.prep.datastruct.Position;

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {
        
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element, Node<E> prev, Node<E> next) {
            super();
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        public E getElement() {
            return element;
        }
        public void setElement(E element) {
            this.element = element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        
    }
    
    private class PositionIterator implements Iterator<Position<E>> {
        
        private Position<E> cursor = first();
        private Position<E> recent = null;

        public boolean hasNext() {
            return cursor != null;
        }

        public Position<E> next() {
            if (cursor == null) throw new NoSuchElementException("Nothing left");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }
        
        public void remove() {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
        
    }
    
    private class PositionIterable implements Iterable<Position<E>> {

        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
        
    }
    
    private class ElementIterator implements Iterator<E> {
        
        Iterator<Position<E>> posIterator = new PositionIterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        }
        
        public void remove() {
            posIterator.remove();
        }
        
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedPositionalList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        size = 0;
    }

    private Node<E> validate(Position<E> position) {
        if (!(position instanceof Node)) 
            throw new IllegalArgumentException("Invalid node");
        Node<E> node = (Node<E>) position;
        if (node.getNext() == null) //Condition for defunt node
            throw new IllegalArgumentException("Node is not in the list");
        return node;
    }
    
    private Position<E> position(Node<E> node) {
        if (node == head || node == tail) {
            return null;
        } else {
            return node;
        }
    }
    
    private Position<E> addBetween(E element, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<E>(element, prev, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
        return position(newNode);
    }
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(head.getNext());
    }

    public Position<E> last() {
        return position(tail.getPrev());
    }

    public Position<E> before(Position<E> position) {
        Node<E> node = validate(position);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> position) {
        Node<E> node = validate(position);
        return position(node.getNext());
    }

    public Position<E> addFirst(E element) {
        return addBetween(element, head, head.getNext());
    }

    public Position<E> addLast(E element) {
        return addBetween(element, tail.getPrev(), tail);
    }

    public Position<E> addBefore(Position<E> position, E element) {
        Node<E> next = validate(position);
        return addBetween(element, next.getPrev(), next);
    }

    public Position<E> addAfter(Position<E> position, E element) {
        Node<E> prev = validate(position);
        return addBetween(element, prev, prev.getNext());
    }

    public E set(Position<E> position, E element) {
        Node<E> node = validate(position);
        E result = node.getElement();
        node.setElement(element);
        return result;
    }

    public E remove(Position<E> position) {
        Node<E> node = validate(position);
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        E result = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        size--;
        return result;
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }
    
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

}
