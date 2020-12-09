package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;

public class StreamFilterIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntPredicate predicate;
    private Integer curInteger;

    public StreamFilterIterator(Iterator<Integer> iterator, IntPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            curInteger = iterator.next();

            if (predicate.test(curInteger)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Integer next() {
        return curInteger;
    }
}
