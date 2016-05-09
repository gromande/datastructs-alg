package com.groman.prep.datastruct.queues;

import com.groman.prep.datastruct.Entry;

public interface PriorityQueue<K, V> {
    
    int size();
    boolean isEmpty();
    Entry<K,V> insert (K key, V valye);
    Entry<K,V> min();
    Entry<K,V> removeMin();

}
