package ua.edu.ucu.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StreamIterator implements Iterator<Integer> {
    private Integer[] values;
    private int index;

    public StreamIterator(Integer[] values) {
        this.values = values;
        this.index = 0;
    }

    public StreamIterator(int[] values) {
        this.values = new Integer[values.length];

        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }

        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < values.length) {
            return true;
        }

        index = 0;
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            index += 1;
            return values[index - 1];
        }

        throw new NoSuchElementException();
    }
}
