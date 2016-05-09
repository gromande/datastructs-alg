package com.groman.prep.datastruct.map;

import java.util.Iterator;

import com.groman.prep.datastruct.Entry;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    
    protected static class MapEntry<K,V> implements Entry<K,V> {

        private K key;
        private V value;
        
        public MapEntry(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        
        protected void setKey(K key) {
            this.key = key;
        }
        
        protected V setValue(V value) {
            V old = value;
            this.value = value;
            return old;
        }
        
    }
    
    private class KeyIterator implements Iterator<K> {

        private Iterator<Entry<K,V>> entriesItr = entrySet().iterator();
        
        public boolean hasNext() {
            return entriesItr.hasNext();
        }

        public K next() {
            return entriesItr.next().getKey();
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
    }
    
    private class ValueIterator implements Iterator<V> {

        private Iterator<Entry<K,V>> entriesItr = entrySet().iterator();
        
        public boolean hasNext() {
            return entriesItr.hasNext();
        }

        public V next() {
            return entriesItr.next().getValue();
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
    }
    
    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }
    
    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<K> keySet() {
        return keySet();
    }

    public Iterable<V> values() {
        return new ValueIterable();
    }


}
