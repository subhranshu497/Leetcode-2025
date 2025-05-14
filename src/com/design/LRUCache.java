package com.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;
    private Queue<Integer> cachedElement;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cachedElement = new LinkedList<>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        cachedElement.remove(key);
        cachedElement.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {

        if(cache.containsKey(key)){
            cachedElement.remove(key);
            cachedElement.offer(key);
            cache.put(key, value);
        }
        else{
            if(cachedElement.size()< capacity){
                cachedElement.add(key);
            }else {
                int evictedItem = cachedElement.poll();
                cache.remove(evictedItem);
                cachedElement.add(key);
            }
            cache.put(key, value);
        }
    }
}
