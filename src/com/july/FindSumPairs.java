package com.july;

import java.util.*;
import java.util.stream.Collectors;

public class FindSumPairs {
    int [] n1, n2;
    private  Map<Integer,Integer> map1;
    private Map<Integer,Integer> map2;
    public FindSumPairs(int [] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        for(int num:n1){
            map1.put(num, map1.getOrDefault(num, 0)+1);
        }
        for(int num:n2){
            map2.put(num, map2.getOrDefault(num, 0)+1);
        }
    }

    public void add(int index, int val) {
        map2.put(n2[index], map2.getOrDefault(n2[index],0)-1);
        n2[index] +=val;
        map2.put(n2[index], map2.getOrDefault(n2[index],0)+1);
    }

    public int count(int tot) {
        //iterate though any one array
        int res =0;
        for(Map.Entry<Integer, Integer>e:map1.entrySet()){
            int num = e.getKey();
            int rem = tot-num;
            if(map2.containsKey(rem)){
                int c1  = map1.get(num);
                int c2 = map2.get(rem);
                int prod = c1*c2;
                res +=prod;
            }
        }
        return res;
    }
}
