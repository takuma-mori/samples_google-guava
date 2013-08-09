package net.aomlab.sample.guava.primitives;

import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 12:07
 * To change this template use File | Settings | File Templates.
 * refer : http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/primitives/package-summary.html
 */
public class IntsTest {

    /**
     * max returns greatest value
     */
    @Test
    public void maxTest() {
        int[] array = new int[]{1, 2, 3};
        assertEquals(Ints.max(array), 3);
    }

    /**
     * min returns least value
     */
    @Test
    public void minTest() {
        int[] array = new int[]{1, 2, 3};
        assertEquals(Ints.min(array), 1);
    }

    /**
     * compare(x,y) compares two value of int
     */
    @Test
    public void compareTest() {
        int x = 1;
        int y = 2;
        // expected -1 when left value is less than right value
        assertEquals(-1, Ints.compare(x, y));

        // expected 1 when left is more than right
        assertEquals(1, Ints.compare(y, x));
    }

    /**
     * checkedCast Returns the int value that is equal to value, if possible
     */
    @Test
    public void checkedCastTest() {
        // integer range
        assertEquals(100000, Ints.checkedCast(100000L));

        // out of int range
        try {
            Ints.checkedCast(3000000000L);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    /**
     * saturatedCast returns the int value.
     * when values is out of range (more than Integer.MAX_VALUE or less than Integer.MIN_VALUE), cast to same value;
     */
    @Test
    public void saturatedCast() {
        // less than Integer.MAX_VALUE or more than Integer.MIN_VALUE
        assertEquals(100000, Ints.saturatedCast(100000L));

        // out of int range
        assertEquals(Integer.MAX_VALUE, Ints.saturatedCast(3000000000L));
        assertEquals(Integer.MIN_VALUE, Ints.saturatedCast(-3000000000L));
    }

    /**
     * join returns a string value separated by separator
     */
    @Test
    public void joinTest() {
        int[] array1 = new int[]{1, 2, 3};
        assertEquals("1,2,3", Ints.join(",", array1));

        // if contains empty value
        int[] array2 = new int[4];
        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;
        assertEquals("1,2,3,0", Ints.join(",", array2));
    }

    /**
     * get Comparator<int[]> instance lexicographically
     */
    @Test
    public void lexicographicalComparator() {
        int[] x1 = new int[]{1};
        int[] y1 = new int[]{2};

        int[] x2 = new int[]{10};
        int[] y2 = new int[]{10};

        Comparator<int[]> comparator = Ints.lexicographicalComparator();

        assertEquals(-1, comparator.compare(x1, y1));
        assertEquals(1, comparator.compare(y1, x1));
        assertEquals(0, comparator.compare(y2, x2));
    }


}