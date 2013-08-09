package net.aomlab.sample.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.junit.Test;

import java.security.Key;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/06
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
public class CacheBuilderTest {

    @Test
    public void test1() {

        Cache cache = CacheBuilder.newBuilder().build(
                new CacheLoader() {

                    @Override
                    public Object load(Object key) throws Exception {
                        return getContents(key);
                    }

                    private Object getContents(Object key) {
                        return "hoge" + key;
                    }
                }

        );
    }
}
