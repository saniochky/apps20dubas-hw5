package ua.edu.ucu.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StreamIterator implements Iterator<Integer> {
    private final int[] values;
    private int index;

    public StreamIterator(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
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
        int now = index;
        index += 1;
        return values[now];
    }
}
