package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class StreamMapIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntUnaryOperator unaryOperator;

    public StreamMapIterator(Iterator<Integer> iterator, IntUnaryOperator unaryOperator) {
        this.iterator = iterator;
        this.unaryOperator = unaryOperator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return unaryOperator.apply(iterator.next());
    }
}
