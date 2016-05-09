package com.groman.prep.datastruct;

import static org.junit.Assert.*;
import static com.groman.prep.datastruct.TestData.*;

import org.junit.Test;

import com.groman.prep.datastruct.stack.ArrayStack;
import com.groman.prep.datastruct.stack.LinkedStack;
import com.groman.prep.datastruct.stack.Stack;

public class StackTestCase {
    
    @Test
    public void testArrayStack() {
        testGenericStack(new ArrayStack<String>());
    }
    
    @Test
    public void testLinkedStack() {
        testGenericStack(new LinkedStack<String>());
    }

    public void testGenericStack(Stack<String> stack) {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        
        stack.push(SPAIN);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        
        assertEquals(SPAIN, stack.top());
        assertEquals(SPAIN, stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        
        stack.push(SPAIN);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        
        stack.push(FRANCE);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        
        stack.push(ITALY);
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        
        assertEquals(ITALY, stack.top());
        assertEquals(ITALY, stack.pop());
        assertEquals(2, stack.size());
        
        assertEquals(FRANCE, stack.top());
        assertEquals(FRANCE, stack.pop());
        assertEquals(1, stack.size());
        
        assertEquals(SPAIN, stack.top());
        assertEquals(SPAIN, stack.pop());
        assertEquals(0, stack.size());
        
        assertNull(stack.pop());
        assertNull(stack.top());
        
    }

}
