package ua.edu.ucu;

import org.junit.Test;
import static org.junit.Assert.*;
import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.stream.IntStream;

public class AsIntStreamTest {
    @Test
    public void testAverageMethod() {
        int[] intArr = {-1, 0, 1, 2, 3};
        IntStream intStream = AsIntStream.of(intArr);
        Double expectedResult = 1.0;

        assertEquals(expectedResult, intStream.average());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageMethodOfEmptyStream() {
        int[] intArr = {};
        IntStream intStream = AsIntStream.of(intArr);
        intStream.average();
    }

    @Test
    public void testMaxMethod() {
        int[] intArr = {-1, 0, 1, 2, 3};
        IntStream intStream = AsIntStream.of(intArr);
        Integer expectedResult = 3;

        assertEquals(expectedResult, intStream.max());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxMethodOfEmptyStream() {
        int[] intArr = {};
        IntStream intStream = AsIntStream.of(intArr);
        intStream.max();
    }

    @Test
    public void testMinMethod() {
        int[] intArr = {-1, 0, 1, 2, 3};
        IntStream intStream = AsIntStream.of(intArr);
        Integer expectedResult = -1;

        assertEquals(expectedResult, intStream.min());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinMethodOfEmptyStream() {
        int[] intArr = {};
        IntStream intStream = AsIntStream.of(intArr);
        intStream.min();
    }

    @Test
    public void testCountMethod() {
        int[] intArr = {-1, 0, 1, 2, 3};
        IntStream intStream = AsIntStream.of(intArr);
        int expectedResult = 5;

        assertEquals(expectedResult, intStream.count());
    }

    @Test
    public void testSumMethod() {
        int[] intArr = {-1, 0, 1, 2, 3};
        IntStream intStream = AsIntStream.of(intArr);
        Integer expectedResult = 5;

        assertEquals(expectedResult, intStream.sum());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumMethodOfEmptyStream() {
        int[] intArr = {};
        IntStream intStream = AsIntStream.of(intArr);
        intStream.sum();
    }


}
