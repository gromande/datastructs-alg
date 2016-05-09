package com.groman.prep.datastruct.queues;

import java.util.Comparator;

import com.groman.prep.datastruct.Entry;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    
    protected static class PQEntry<K,V> implements Entry<K, V> {

        private K key;
        private V value;
        public PQEntry(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        
    }
    
    protected static class DefaultComparator<K> implements Comparator<K> {

        public int compare(K a, K b) {
            return ((Comparable<K>) a).compareTo(b);
        }
        
    }
    
    protected Comparator<K> comp;

    public AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    public AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }
    
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }
    
    protected boolean checkKey(K key) {
        try {
            return (comp.compare(key, key) == 0); //Make sure can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatoble key");
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
