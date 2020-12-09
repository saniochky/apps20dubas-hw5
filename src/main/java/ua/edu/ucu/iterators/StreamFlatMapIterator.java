package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.AsIntStream;

import java.util.Iterator;

public class StreamFlatMapIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntToIntStreamFunction streamFunction;
    private StreamIterator insideIterator;

    public StreamFlatMapIterator(Iterator<Integer> iterator, IntToIntStreamFunction streamFunction) {
        this.iterator = iterator;
        this.streamFunction = streamFunction;
        int[] arr = {};
        this.insideIterator = new StreamIterator(arr);
    }

    @Override
    public boolean hasNext() {
        if (insideIterator.hasNext()) {
            return true;
        } else if (iterator.hasNext()) {
            AsIntStream newStream = (AsIntStream) streamFunction.applyAsIntStream(iterator.next());
            insideIterator = new StreamIterator(newStream.toArray());
            return true;
        }

        return false;
    }

    @Override
    public Integer next() {
        return insideIterator.next();
    }
}
