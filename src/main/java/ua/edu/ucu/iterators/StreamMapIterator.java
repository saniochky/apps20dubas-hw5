package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class StreamMapIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private final IntUnaryOperator unaryOperator;

    public StreamMapIterator(Iterator<Integer> iterator,
                             IntUnaryOperator unaryOperator) {
        this.iterator = iterator;
        this.unaryOperator = unaryOperator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        int next = iterator.next();
        return unaryOperator.apply(next);
    }
}
