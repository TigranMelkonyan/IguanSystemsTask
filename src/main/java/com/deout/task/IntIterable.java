package com.deout.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IntIterable implements Iterable<Integer> {

    private final List<Integer> backed;

    public IntIterable(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        this.backed = new ArrayList<>();
        for (int val : array) {
            backed.add(val);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < backed.size();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements to iterate");
            }
            return backed.get(++currentIndex);
        }

        @Override
        public void remove() {
            if (currentIndex < 0 || currentIndex >= backed.size()) {
                throw new IllegalStateException("Remove operation not valid");
            }
            backed.remove(currentIndex);
            currentIndex--;
        }
    }
}