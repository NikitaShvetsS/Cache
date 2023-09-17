package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cache {

    private static final Logger logger = Logger.getLogger(Cache.class.getName());
    private Map<String, Map<String, Object>> cache;

    public Cache(){
        this.cache = new HashMap<>();
    }

    public boolean put(String cacheName, String key, Object value) {
        if (!cache.containsKey(cacheName)) {
            cache.put(cacheName, new HashMap<>());
        }
        cache.get(cacheName).put(key, value);
        logger.log(Level.INFO, "Cached {0} in cache {1} with key {2}", new Object[]{value, cacheName, key});
        return true;
    }

    public Object get(String cacheName, String key) {
        if (cache.containsKey(cacheName)) {
            Object value = cache.get(cacheName).get(key);
            if (value != null) {
                logger.log(Level.INFO, "Retrieved {0} from cache {1} with key {2}", new Object[]{value, cacheName, key});
                return value;
            }
        }
        logger.log(Level.INFO, "Cache miss for key {0} in cache {1}", new Object[]{key, cacheName});
        return null;
    }

    public void clear() {
        cache.clear();
        logger.log(Level.INFO, "Cleared all caches");
    }

    public void clear(String cacheName) {
        if (cache.containsKey(cacheName)) {
            cache.get(cacheName).clear();
            logger.log(Level.INFO, "Cleared cache {0}", cacheName);
        }
    }

    public boolean isCacheExist(String cacheName) {
        return cache.containsKey(cacheName);
    }

}
