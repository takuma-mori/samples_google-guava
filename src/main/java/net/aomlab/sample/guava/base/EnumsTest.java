package net.aomlab.sample.guava.base;

import com.google.common.base.Enums;
import com.google.common.base.Function;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
public class EnumsTest {
    public enum Job {
        CEO, CEVELOPER, DESIGNER
    }

    private Function<String, Job> valueOfFunction = Enums.valueOfFunction(Job.class);

    @Test(expected = NullPointerException.class)
    public void nullTest() {
        valueOfFunction.apply(null);
    }

    @Test
    public void okTest() {
    assertEquals(valueOfFunction.apply("CEO"), Job.CEO);
}

    @Test
    public void illegalTest() {
        assertEquals(valueOfFunction.apply("UNKNOWN"), null);
    }

    @Test
    public void getFieldTest() {
        Field field = Enums.getField(Job.CEVELOPER);
    }
}
