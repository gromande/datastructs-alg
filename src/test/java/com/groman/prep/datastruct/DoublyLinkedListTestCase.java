package com.groman.prep.datastruct;

import static org.junit.Assert.*;
import static com.groman.prep.datastruct.TestData.*;

import org.junit.Test;

import com.groman.prep.datastruct.lists.DoublyLinkedList;

public class DoublyLinkedListTestCase {

    @Test
    public void test() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
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
        
        assertEquals(FRANCE, list.removeLast());
        assertEquals(list.size(), 1);
        assertEquals(SPAIN, list.first());
        assertEquals(SPAIN, list.last());
        
        assertEquals(SPAIN, list.removeLast());
        assertTrue(list.isEmpty());
        assertNull(list.first());
        assertNull(list.last());
    }

}
