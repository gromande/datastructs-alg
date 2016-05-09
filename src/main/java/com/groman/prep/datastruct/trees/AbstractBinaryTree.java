package com.groman.prep.datastruct.trees;

import java.util.List;

import com.groman.prep.datastruct.Position;

import java.util.ArrayList;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> 
                                            implements BinaryTree<E> {
    
    public Iterable<Position<E>> children(Position<E> position) {
        List<Position<E>> children = new ArrayList<Position<E>>(2);
        if (left(position) != null) children.add(left(position));
        if (right(position) != null) children.add(right(position));
        return children;
    }

    public int numChildren(Position<E> position) {
        int count = 0;
        if (left(position) != null) count++;
        if (right(position) != null) count++;
        return count;
    }

    public Position<E> sibling(Position<E> position) {
        Position<E> parent = parent(position);
        if (parent == null) return null; //p must be root
        if (position == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

}
