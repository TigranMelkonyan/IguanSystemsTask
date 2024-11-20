package com.deout.task;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntIteratorTest {

    @Test
    public void testForeach() {
        int[] arr = createArray(10);
        IntIterable intIterable = new IntIterable(arr);
        int i = 0;
        for (Integer el : intIterable) {
            assertEquals("Element at index " + i + " does not match", Integer.valueOf(arr[i]), el);
            i++;
        }
        assertEquals("Did not iterate through the entire array", arr.length, i);
    }

    @Test
    public void testBlankForeach() {
        int[] arr = new int[0];
        for (Integer ignored : new IntIterable(arr)) {
            fail("The loop should not be executed for an empty array");
        }
    }

    public int[] createArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}


