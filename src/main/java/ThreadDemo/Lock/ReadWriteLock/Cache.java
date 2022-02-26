package ThreadDemo.Lock.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private static final Map<String, Object> map = new HashMap<String, Object>();

    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock r   = rwl.readLock();
    private static final Lock w   = rwl.writeLock();

    public static Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) {

        Cache.put("test", "hello");

        //hashMap init with literal
        Cache.put("test 111", new HashMap<String, String>() {
            {
                put("key", "val");
            }
        });

        System.out.println(Cache.get("test 111"));
    }
}
