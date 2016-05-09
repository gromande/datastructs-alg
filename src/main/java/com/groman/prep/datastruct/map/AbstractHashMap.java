package com.groman.prep.datastruct.map;

import java.util.ArrayList;
import java.util.Random;

import com.groman.prep.datastruct.Entry;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    
    protected int n = 0; //Number of entries in the dictionary
    protected int capacity;
    private int prime;
    private long scale, shift;

    public AbstractHashMap(int capacity, int prime) {
        this.prime = prime;
        this.capacity = capacity;
        Random rand = new Random(System.currentTimeMillis());
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }
    
    public AbstractHashMap(int capacity) {
        this(capacity, 109345121);
    }
    
    public AbstractHashMap() {
        this(17);
    }

    protected abstract void createTable();
    protected abstract V bucketGet(int hash, K key);
    protected abstract V bucketPut(int hash, K key, V value);
    protected abstract V bucketRemove(int hash, K key);

    public int size() {
        return n;
    }
    
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    public V put(K key, V value) {
        V result =  bucketPut(hashValue(key), key, value);
        if (n > capacity/2) {
            resize(2*capacity - 1);
        }
        return result;
    }

    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }
    
    private void resize(int newCap) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<Entry<K,V>>(n);
        for (Entry<K,V> entry : entrySet()) {
            buffer.add(entry);
        }
        capacity = newCap;
        createTable();
        n=0;
        for (Entry<K,V> entry : buffer) {
            put(entry.getKey(), entry.getValue());
        }
    }
    
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
    }
    
    
}
