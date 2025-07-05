package com.july;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerinanArray {
    public static void main(String[] args) {
        int [] arr= {2,2,3,4};
        int val = findLucky(arr);
        System.out.println(val);
    }
    private static int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int res=-1;
        for(int a:arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        //iterate the map
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int val = e.getValue();
            int key = e.getKey();
            if(key==val){
                res = Math.max(res, key);
            };
        }
        return res !=-1?res:-1;
    }
}
