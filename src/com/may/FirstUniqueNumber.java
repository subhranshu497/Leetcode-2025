package com.may;

import java.util.*;

public class FirstUniqueNumber {
    private Map<Integer, Integer> map;
    private Queue<Integer> q;
    FirstUniqueNumber(int[] nums) {
        map = new HashMap<>();
        q = new LinkedList<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(!map.containsKey(num)){
                q.add(num);
            }
        }
    }

    int showFirstUnique() {
        while (map.getOrDefault(q.peek(),0)>1){
            q.poll();
        }
        return q.isEmpty() ? -1:q.peek();
    }

    void add(int value) {
        map.put(value, map.getOrDefault(value, 0)+1);
        if(!map.containsKey(value)){
            q.add(value);
        }

    }
}
