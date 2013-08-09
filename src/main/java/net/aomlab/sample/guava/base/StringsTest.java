package net.aomlab.sample.guava.base;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 * refer : http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/base/Strings.html#emptyToNull%28java.lang.String%29
 */
public class StringsTest {

    @Test
    public void isNullOrEmptyTest() {
        String str1 = "hoge";
        assertEquals(false, Strings.isNullOrEmpty(str1));

        String str2 = "";
        assertEquals(true, Strings.isNullOrEmpty(str2));

        String str3 = null;
        assertEquals(true, Strings.isNullOrEmpty(str3));
    }

    @Test
    public void emptyToNullTest() {
        String str = "";
        assertEquals(null, Strings.emptyToNull(str));
    }

    @Test
    public void nullToEmptyTest() {
        String str = null;
        assertEquals("", Strings.nullToEmpty(str));
    }

    @Test
    public void padStartTest() {
        String str = "3";
        int minLength = 5;
        char padChar = 'x';
        assertEquals("xxxx3", Strings.padStart(str, minLength, padChar));
    }

    @Test
    public void padEndTest() {
        String str = "4.";
        int minLength = 4;
        char padChar = '0';
       assertEquals("4.00", Strings.padEnd(str, minLength, padChar));
    }

    @Test
    public void repeatTest() {
        String str = "HEY!";
        int count = 3;
        assertEquals("HEY!HEY!HEY!", Strings.repeat(str, count));

        // if count is negative
        int negativeCount = -3;
        try {
            Strings.repeat(str, negativeCount);

        }catch (Exception e) {
            assertEquals(true, e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void commonPrefixTest() {
        CharSequence x = "acid black cherry";
        CharSequence y = "acidman";
        assertEquals("acid", Strings.commonPrefix(x, y));
    }

    @Test
    public void commonSuffixTest() {
        CharSequence x = "isam";
        CharSequence y = "myisam";
        assertEquals("isam", Strings.commonSuffix(x, y));
    }
}