package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.AsIntStream;

import java.util.Iterator;

public class StreamFlatMapIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private final IntToIntStreamFunction streamFunction;
    private AsIntStream insideIterator;

    public StreamFlatMapIterator(Iterator<Integer> iterator, IntToIntStreamFunction streamFunction) {
        this.iterator = iterator;
        this.streamFunction = streamFunction;
    }

    @Override
    public boolean hasNext() {
        if (insideIterator == null || !insideIterator.getIntegerStream().hasNext()) {
            insideIterator = null;
            return iterator.hasNext();
        }

        return true;
    }

    @Override
    public Integer next() {
        if (insideIterator == null) {
            insideIterator = (AsIntStream) streamFunction.applyAsIntStream(iterator.next());
        }

        return insideIterator.getIntegerStream().next();
    }
}
