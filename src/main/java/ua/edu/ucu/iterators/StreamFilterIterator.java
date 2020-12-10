package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StreamFilterIterator implements Iterator<Integer> {
    private final IntPredicate intPredicate;
    private final Iterator<Integer> iterator;
    private int current;

    public StreamFilterIterator(Iterator<Integer> iterator,
                          IntPredicate intPredicate) {
        this.iterator = iterator;
        this.intPredicate = intPredicate;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            current = iterator.next();
            if (intPredicate.test(current)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        return current;
    }
}