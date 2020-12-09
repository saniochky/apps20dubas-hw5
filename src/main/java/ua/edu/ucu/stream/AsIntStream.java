package ua.edu.ucu.stream;

import com.sun.javafx.fxml.expression.LiteralExpression;
import ua.edu.ucu.function.*;
import ua.edu.ucu.iterators.StreamFilterIterator;
import ua.edu.ucu.iterators.StreamFlatMapIterator;
import ua.edu.ucu.iterators.StreamIterator;
import ua.edu.ucu.iterators.StreamMapIterator;

import java.util.Iterator;

public class AsIntStream implements IntStream {
    private static Iterator<Integer> integerStream;

    private AsIntStream(Iterator<Integer> iterator) {
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
        return new AsIntStream(new StreamFilterIterator(integerStream, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        Iterable<Integer> iterable = () -> integerStream;

        for (Integer integer: iterable) {
            action.accept(integer);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator unaryOperator) {
        return new AsIntStream(new StreamMapIterator(integerStream, unaryOperator));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction function) {
        return new AsIntStream(new StreamFlatMapIterator(integerStream, function));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        Iterable<Integer> iterable = () -> integerStream;
        int applied = identity;

        for (Integer integer: iterable) {
            applied = op.apply(applied, integer);
        }

        return applied;
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

}
