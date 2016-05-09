package com.groman.prep.datastruct;

import static org.junit.Assert.*;
import static com.groman.prep.datastruct.TestData.*;

import org.junit.Test;

import com.groman.prep.datastruct.lists.SinglyLinkedList;

public class SinglyLinkedListTestCase {

    @Test
    public void test() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        
        assertTrue(list.isEmpty());
        
        list.addFirst(SPAIN);
        assertEquals(list.size(), 1);
        assertEquals(SPAIN, list.first());
        assertEquals(SPAIN, list.last());
        
        list.addLast(FRANCE);
        assertEquals(list.size(), 2);
        assertEquals(SPAIN, list.first());
        assertEquals(FRANCE, list.last());
        
        list.addFirst(ITALY);
        assertEquals(list.size(), 3);
        assertEquals(ITALY, list.first());
        assertEquals(FRANCE, list.last());
        
        assertEquals(ITALY, list.removeFirst());
        assertEquals(list.size(), 2);
        assertEquals(SPAIN, list.first());
        assertEquals(FRANCE, list.last());
        
        assertEquals(SPAIN, list.removeFirst());
        assertEquals(list.size(), 1);
        assertEquals(FRANCE, list.first());
        assertEquals(FRANCE, list.last());
        
        assertEquals(FRANCE, list.removeFirst());
        assertTrue(list.isEmpty());
        assertNull(list.first());
        assertNull(list.last());
        
    }

}
