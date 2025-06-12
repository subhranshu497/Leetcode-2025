//package com.design;
//
//import java.util.*;
//
//public class LFUCache {
//    private int capacity;
//    private Map<Integer, Integer> cache;
//    private PriorityQueue<int[]> freqCount;
//    //the element at the back of queue is the most recently used
//    // the elment at the front of queue is the least recently used
//    //in case of the tie in the freq count , then poll the elment from the front of the queue
//    private Queue<Integer> mostRecentTracker;
//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//        cache = new HashMap<>();
//        freqCount = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
//    }
//
//    public int get(int key) {
//        if()
//    }
//
//    public void put(int key, int value) {
//        int cacheSize = cache.size();
//        if(cacheSize <capacity){
//            cache.put(key, value);
//            if(cache.containsKey(key)){
//                int [] currentCount = freqCount.
//            }
//            freqCount.offer(new int[]{key, value});
//            mostRecentTracker.offer(key);
//        }
//    }
//}
