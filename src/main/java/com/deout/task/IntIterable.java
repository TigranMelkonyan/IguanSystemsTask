package com.deout.task;

import java.util.Iterator;

public class IntIterable implements Iterable<Integer> {
    private int[] backed;
    private int index = 0;

    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {
        public boolean hasNext() {
            assertNotNull();
            return index < backed.length;
        }

        public Integer next() {
            assertNotNull();
            assertIndexNotOutOfRange();
            return backed[index++];
        }

        public void remove() {
            int[] arr = new int[backed.length - 1];
            assertNotNull();
            assertIndexNotOutOfRange();
            for (int i = 0; i < backed.length; i++) {
                if (index - 1 == i) {
                    for (int j = i; j < backed.length - 1; j++) {
                        arr[j] = backed[j + 1];
                    }
                    break;
                }
                arr[i] = backed[i];
            }
            backed = arr;
        }
    }

    private void assertNotNull() {
        if (backed == null) {
            throw new NullPointerException("Array cant be null");
        }
    }

    private void assertIndexNotOutOfRange() {
        if (index < 0 || index >= backed.length) {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}