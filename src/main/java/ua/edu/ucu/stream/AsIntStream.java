package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterators.StreamFilterIterator;
import ua.edu.ucu.iterators.StreamFlatMapIterator;
import ua.edu.ucu.iterators.StreamIterator;
import ua.edu.ucu.iterators.StreamMapIterator;

import java.util.Iterator;

public class AsIntStream implements IntStream {
    private final Iterator<Integer> integerStream;

    private AsIntStream(Iterator<Integer> iterator) {
        this.integerStream = iterator;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new StreamIterator(values));
    }

    @Override
    public Double average() {
        if (count() != 0) {
            return (double) sum() / count();
        }

        throw new IllegalArgumentException("The stream is empty");
    }

    @Override
    public Integer max() {
        if (count() != 0) {
            Integer max = null;

            while (integerStream.hasNext()) {
                Integer next = integerStream.next();

                if (max == null || max < next) {
                    max = next;
                }
            }

            return max;
        }

        throw new IllegalArgumentException("The stream is empty");
    }

    @Override
    public Integer min() {
        if (count() != 0) {
            Integer min = null;

            while (integerStream.hasNext()) {
                Integer next = integerStream.next();

                if (min == null || min > next) {
                    min = next;
                }
            }

            return min;
        }

        throw new IllegalArgumentException("The stream is empty");
    }

    @Override
    public long count() {
        long length = 0;

        while (integerStream.hasNext()) {
            length += 1;
            integerStream.next();
        }

        return length;
    }

    @Override
    public Integer sum() {
        if (count() != 0) {
            Integer sum = 0;

            while (integerStream.hasNext()) {
                sum += integerStream.next();
            }

            return sum;
        }

        throw new IllegalArgumentException("The stream is empty");
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new
                StreamFilterIterator(integerStream, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        Iterable<Integer> iterable = () -> integerStream;

        for (Integer integer: iterable) {
            action.accept(integer);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new StreamMapIterator(integerStream, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new StreamFlatMapIterator(integerStream, func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        while (integerStream.hasNext()) {
            identity = op.apply(identity, integerStream.next());
        }

        return identity;
    }

    @Override
    public int[] toArray() {
        int[] intArray = new int[(int) count()];
        int index = 0;

        while (integerStream.hasNext()) {
            intArray[index] = integerStream.next();
            index += 1;
        }

        return intArray;
    }

    public Iterator<Integer> getIntegerStream() {
        return integerStream;
    }
}
