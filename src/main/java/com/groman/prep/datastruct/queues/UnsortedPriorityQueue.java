package com.groman.prep.datastruct.queues;

import java.util.Comparator;

import com.groman.prep.datastruct.Entry;
import com.groman.prep.datastruct.Position;
import com.groman.prep.datastruct.lists.LinkedPositionalList;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<Entry<K,V>>();
    
    public UnsortedPriorityQueue() {
        super();
    }

    public UnsortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    public int size() {
        return list.size();
    }
    
    private Position<Entry<K, V>> findMin() {
        Position<Entry<K, V>> small = list.first();
        for (Position<Entry<K,V>> walk : list.positions()) {
            if (compare(walk.getElement(), small.getElement()) < 0) {
                small = walk;
            }
        }
        return small;
    }

    public Entry<K, V> insert(K key, V value) {
        checkKey(key);
        Entry<K, V> entry = new PQEntry<K, V>(key, value);
        list.addLast(entry);
        return entry;
    }

    public Entry<K, V> min() {
        return findMin().getElement();
    }

    public Entry<K, V> removeMin() {
        return list.remove(findMin());
    }

}
