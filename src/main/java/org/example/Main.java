package org.example;

public class Main {

    public static void main(String[] args) {
        Cache cache = new Cache();

        cache.put("myCache", "1", "1");
        cache.put("myCache", "2", "2");

        Object result = cache.get("myCache", "1");
        if (result != null) {
            System.out.println("Value retrieved: " + result);
        } else {
            System.out.println("Value not found in cache.");
        }

        cache.clear("myCache");
        boolean cacheExists = cache.isCacheExist("myCache");
        System.out.println("Cache exists: " + cacheExists);
    }

}
