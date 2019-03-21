package ua.com.dzlobenets.stat.lib;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class MeasureOfCentralTendencyTest {

    @Test
    public void testMode() {
        Integer mode = MeasureOfCentralTendency.mode(Arrays.asList(-5 ,1, 5, 4, 5));
        Integer expected = 5;
        assertEquals(mode, expected);
    }

    @Test
    public void testMode1() {
        Integer mode = MeasureOfCentralTendency.mode(Arrays.asList(15));
        Integer expected = 15;
        assertEquals(mode, expected);
    }


}