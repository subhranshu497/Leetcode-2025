package com.design;

import java.util.*;

public class LFUCache {
    private int capaticy;
    private int size;
    private int counter;
    private int minFreq;
    Map<Integer, int[]> cache;
    TreeMap<Integer, Deque<int[]>> freqMap;
    public LFUCache(int capaticy){
        this.capaticy = capaticy;
        this.size =0;
        this.cache = new HashMap<>();
        this.freqMap = new TreeMap<>();
        this.minFreq = 0;
        this.counter = 0;
    }
    public int get(int key){
        if(cache.isEmpty()|| !cache.containsKey(key)) return -1;
        int [] cacheEntry = cache.get(key);
        int val = cacheEntry[1];
        //but before returning value put the entry at the front of the queue , as it is accessed recently
        upadateFrequency(cacheEntry);
        return val;
    }

    private void upadateFrequency(int[] entry) {
        //in this arr , 0th pos - key , 1st pos - val , 2nd pos - freq
        int oldFreq = entry[2];
        int key = entry[0];
        //remove this entry from its back
        Deque<int[]> currFreqDq = freqMap.get(oldFreq);
        currFreqDq.remove(entry);
        if(currFreqDq.isEmpty()){
            freqMap.remove(oldFreq);
            if(oldFreq ==minFreq){
                minFreq = freqMap.isEmpty()?0:freqMap.firstKey();
            }
        }
        entry[2]++;
        freqMap.computeIfAbsent(entry[2],k->new LinkedList<>()).addFirst(entry);
    }

    public void put(int key, int value){
        if(capaticy==0) return;
        if(cache.containsKey(key)){
            int [] entry = cache.get(key);
            entry[1] = value;
            upadateFrequency(entry);
            return;
        }
        //new entry
        if(size==capaticy){
            //cache is full, evict the lfu item
            Deque<int[]> minFreqItem = freqMap.get(minFreq);
            int [] entryToRemove = minFreqItem.removeLast();
            cache.remove(entryToRemove[0]);
            size--;
            if(minFreqItem.isEmpty()){
                freqMap.remove(minFreq);
                if(!freqMap.isEmpty()){
                    minFreq = freqMap.firstKey();
                }else minFreq =0;
            }
        }
        //for the entry
        int [] entry = new int[]{key, value, 1};
        cache.put(key, entry);
        freqMap.computeIfAbsent(1,k->new LinkedList<>()).addFirst(entry);
        size++;
        minFreq =1;
    }
}
