package net.aomlab.sample.guava.base;

import com.google.common.base.Stopwatch;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
public class StopWatchTest {

    @Test
    public void Test() {
        Stopwatch stopwatch = new Stopwatch().start();
        doSomething();
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }

    public void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}