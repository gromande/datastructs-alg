package com.groman.prep.datastruct.trees;

import java.util.Iterator;

import com.groman.prep.datastruct.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    protected static class Node<E> implements Position<E> {
        
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        
        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            super();
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        public E getElement() {
            return element;
        }
        public void setElement(E element) {
            this.element = element;
        }
        public Node<E> getParent() {
            return parent;
        }
        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
        public Node<E> getLeft() {
            return left;
        }
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        public Node<E> getRight() {
            return right;
        }
        public void setRight(Node<E> right) {
            this.right = right;
        }
        
    }
    
    protected Node<E> createNode(E element, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(element, parent, left, right);
    }
    
    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }
    
    protected Node<E> validates(Position<E> position) {
        if (!(position instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");
        Node<E> node = (Node<E>) position;
        if (node.getParent() == node)
            throw new IllegalArgumentException("Position is no longer in the tree");
        return node;
    }

    public Position<E> left(Position<E> position) {
        Node<E> node = validates(position);
        return node.getLeft();
    }

    public Position<E> right(Position<E> position) {
        Node<E> node = validates(position);
        return node.getRight();
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> position) {
        Node<E> node = validates(position);
        return node.getParent();
    }

    public int size() {
        return size;
    }

    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public Iterable<Position<E>> positions() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public Position<E> addRoot(E element) {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        this.root = createNode(element, null, null, null);
        size++;
        return root();
    }
    
    public Position<E> addLeft(Position<E> position, E element) {
        Node<E> node = validates(position);
        if (node.getLeft() != null) throw new IllegalArgumentException("Node already has a left child");
        Node<E> left = createNode(element, node, null, null);
        node.setLeft(left);
        size++;
        return left;
    }
    
    public Position<E> addRight(Position<E> position, E element) {
        Node<E> node = validates(position);
        if (node.getRight() != null) throw new IllegalArgumentException("Node already has a right child");
        Node<E> right = createNode(element, node, null, null);
        node.setLeft(right);
        size++;
        return right;
    }
    
    public E set(Position<E> position, E element) {
        Node<E> node = validates(position);
        E result = node.getElement();
        node.setElement(element);
        return result;
    }
    
    public void attach(Position<E> position, LinkedBinaryTree<E> left, LinkedBinaryTree<E> right) {
        Node<E> node = validates(position);
        if (isInternal(position)) throw new IllegalArgumentException("Position must be a leaf");
        size += left.size() + right.size();
        if (!left.isEmpty()) {
            left.root.setParent(node);
            node.setLeft(left.root);
            left.root = null;
            left.size = 0;
        }
        if (!right.isEmpty()) {
            right.root.setParent(node);
            node.setRight(right.root);
            right.root = null;
            right.size = 0;
        }
    }

    public E remove(Position<E> position) {
        Node<E> node = validates(position);
        if (numChildren(position) > 1) 
            throw new IllegalArgumentException("Position has two children");
        Node<E> child = node.getLeft() != null ? node.getLeft() : node.getRight();
        child.setParent(node.getParent());
        if (node == root) {
            root = child;
        } else if (node.getParent().getLeft() == node) {
            node.getParent().setLeft(child);
        } else {
            node.getParent().setRight(child);
        }
        size--;
        E result = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return result;
    }
}
