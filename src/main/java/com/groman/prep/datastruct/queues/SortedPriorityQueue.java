package com.groman.prep.datastruct.queues;

import java.util.Comparator;

import com.groman.prep.datastruct.Entry;
import com.groman.prep.datastruct.Position;
import com.groman.prep.datastruct.lists.LinkedPositionalList;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    
    private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<Entry<K,V>>();

    public SortedPriorityQueue() {
    }

    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    public int size() {
        return list.size();
    }


    public Entry<K, V> insert(K key, V value) {
        checkKey(key);
        Entry<K,V> entry = new PQEntry<K,V>(key, value);
        for (Position<Entry<K,V>> walk : list.positions()) {
            if (compare(entry, walk.getElement()) <= 0) {
                list.addBefore(walk, entry);
            }
        }
        return entry;
    }

    public Entry<K, V> min() {
        if (list.isEmpty()) return null;
        return list.first().getElement();
    }

    public Entry<K, V> removeMin() {
        if (list.isEmpty()) return null;
        return list.remove(list.first());
    }

}
