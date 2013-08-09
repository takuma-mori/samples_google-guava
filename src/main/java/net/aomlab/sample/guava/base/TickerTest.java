package net.aomlab.sample.guava.base;

import com.google.common.base.Ticker;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class TickerTest {

    @Test
    public void readTest() {
        System.out.println(Ticker.systemTicker().read());
    }
}
