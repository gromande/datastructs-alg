package com.groman.prep.datastruct.trees;

import com.groman.prep.datastruct.Position;

public abstract class AbstractTree<E> implements Tree<E> {

    public boolean isInternal(Position<E> position) {
        return numChildren(position) != 0;
    }

    public boolean isExternal(Position<E> position) {
        return numChildren(position) == 0;
    }

    public boolean isRoot(Position<E> position) {
        return position == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
