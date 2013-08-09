package net.aomlab.sample.guava.base;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */
public class RangesTest {

    @Test
    public void closedTest() {
        Range<Integer> range = Range.closed(0, 100);
        assertEquals(false, range.contains(-1));
        assertEquals(true, range.contains(0));
        assertEquals(true, range.contains(100));
        assertEquals(false, range.contains(101));

        assertEquals(true, range.hasLowerBound());
        assertEquals(true, range.hasUpperBound());

        assertEquals(BoundType.CLOSED, range.lowerBoundType());
        assertEquals(BoundType.CLOSED, range.upperBoundType());

        assertEquals(Integer.valueOf(0), range.lowerEndpoint());
        assertEquals(Integer.valueOf(100), range.upperEndpoint());
    }

    @Test
    public void openTest() {
        Range<Integer> range = Range.open(0, 100);
        assertEquals(false, range.contains(0));
        assertEquals(true, range.contains(1));
        assertEquals(true, range.contains(99));
        assertEquals(false, range.contains(100));

        assertEquals(true, range.hasLowerBound());
        assertEquals(true, range.hasUpperBound());

        assertEquals(BoundType.OPEN, range.lowerBoundType());
        assertEquals(BoundType.OPEN, range.upperBoundType());

        assertEquals(Integer.valueOf(0), range.lowerEndpoint());
        assertEquals(Integer.valueOf(100), range.upperEndpoint());
    }
}