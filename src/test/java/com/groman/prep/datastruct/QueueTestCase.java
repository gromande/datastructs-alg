package com.groman.prep.datastruct;

import static org.junit.Assert.*;
import static com.groman.prep.datastruct.TestData.*;

import org.junit.Test;

import com.groman.prep.datastruct.queues.ArrayQueue;
import com.groman.prep.datastruct.queues.LinkedQueue;
import com.groman.prep.datastruct.queues.Queue;

public class QueueTestCase {
    
    @Test
    public void testArrayQueue() {
        testGenericStack(new ArrayQueue<String>());
    }
    
    @Test
    public void testLinkedQueue() {
        testGenericStack(new LinkedQueue<String>());
    }

    public void testGenericStack(Queue<String> queue) {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        
        queue.enqueue(SPAIN);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        
        assertEquals(SPAIN, queue.first());
        assertEquals(SPAIN, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        
        queue.enqueue(SPAIN);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        
        queue.enqueue(FRANCE);
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        
        queue.enqueue(ITALY);
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
        
        assertEquals(SPAIN, queue.first());
        assertEquals(SPAIN, queue.dequeue());
        assertEquals(2, queue.size());
        
        assertEquals(FRANCE, queue.first());
        assertEquals(FRANCE, queue.dequeue());
        assertEquals(1, queue.size());
        
        assertEquals(ITALY, queue.first());
        assertEquals(ITALY, queue.dequeue());
        assertEquals(0, queue.size());
        
        assertNull(queue.dequeue());
        assertNull(queue.first());
        
    }

}
