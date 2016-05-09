package com.groman.prep.datastruct.lists;

import com.groman.prep.datastruct.Position;

public interface PositionalList<E> {
    
    int size();
    boolean isEmpty();
    Position<E> first();
    Position<E> last();
    Position<E> before(Position<E> position);
    Position<E> after(Position<E> position);
    Position<E> addFirst(E element);
    Position<E> addLast(E element);
    Position<E> addBefore(Position<E> position, E element);
    Position<E> addAfter(Position<E> position, E element);
    E set(Position<E> position, E element);
    E remove(Position<E> position);

}
