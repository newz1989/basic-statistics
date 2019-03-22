package ua.com.dzlobenets.stat.lib;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MeasureOfCentralTendencyTest {

    @Test
    public void testMode() {
        final Integer mode = MeasureOfCentralTendency.mode(Arrays.asList(-5, 1, 5, 4, 5));
        final Integer expected = 5;
        assertEquals(mode, expected);
    }

    @Test
    public void testMode1() {
        Integer mode = MeasureOfCentralTendency.mode(Collections.singletonList(15));
        Integer expected = 15;
        assertEquals(mode, expected);
    }

    @Test
    public void testMedian() {
        final List<Integer> data = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final Double median = MeasureOfCentralTendency.median(data);
        final Double expected = 5d;
        assertEquals(median, expected);

        final List<Double> dataDoubles = Arrays.asList(0d, 1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d, 10d);
        final Double medianDoubles = MeasureOfCentralTendency.median(dataDoubles);
        final Double expectedDoubles = 5d;
        assertEquals(medianDoubles, expectedDoubles);
    }


    @Test
    public void testMedian1() {
        final Double median = MeasureOfCentralTendency.median(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        final Double expected = (5 + 6) / 2d;
        assertEquals(median, expected);

        final List<Double> dataDoubles = Arrays.asList(0d, 1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d, 10d);
        final Double medianDoubles = MeasureOfCentralTendency.median(dataDoubles);
        final Double expectedDoubles = 5d;
        assertEquals(medianDoubles, expectedDoubles);

    }

}