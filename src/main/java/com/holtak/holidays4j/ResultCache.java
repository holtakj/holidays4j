package com.holtak.holidays4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ResultCache<K, V> {

    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void get(K key) {
        cache.get(key);
    }

    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return cache.computeIfAbsent(key, mappingFunction);
    }

}
