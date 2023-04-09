package Guava;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GuavaTest {

    @Test
    public void whenCacheMiss_thenValueIsComputed() {

        CacheLoader<String, String> loader;
        //定义loader实现
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };

        //定义cache实现
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder().build(loader);

        assertEquals(0, cache.size());

        assertEquals("HELLO", cache.getUnchecked("hello"));

        assertEquals(1, cache.size());
    }
}