package com.groman.prep.datastruct.trees;

import com.groman.prep.datastruct.Position;

public interface BinaryTree<E> extends Tree<E> {
    
    Position<E> left(Position<E> position);
    
    Position<E> right(Position<E> position);
    
    Position<E> sibling(Position<E> position);
}
