package net.aomlab.sample.guava.base;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class OptionalTest {

    @Test
    public void optionalTest() {
        Map<String, Optional<String>> map  = new HashMap<String, Optional<String>>();
        map.put("Ichiro", Optional.of("Sales"));
        map.put("Jiro", Optional.<String>absent());
        map.put("Saburo", Optional.of("Engineer"));

        // Ichiro has job
        Optional<String> job1 = map.get("Ichiro");
        assertEquals(true, job1.isPresent());

        // Jiro hasn't job
        Optional<String> job2 = map.get("Jiro");
        assertEquals(false, job2.isPresent());

        // Shiro is not worker...
        Optional<String> job3 = map.get("Shiro");
        assertEquals(null, job3);
    }
}
