package com.dsaSheet.lovebabbar;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ArraySubset {
    public static void main(String[] args) {
        int [] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int [] b = {11, 3, 7, 1, 7};
        boolean flag = isSubset(a,b);
        System.out.println(flag);
    }

    private static boolean isSubset(int[] a, int[] b) {
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        for(int i:a)
            mapA.put(i, mapA.getOrDefault(i, 0)+1);
        for(int i:b)
            mapB.put(i, mapB.getOrDefault(i, 0)+1);
        for(Map.Entry<Integer, Integer> e:mapB.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(!mapA.containsKey(key)) return false;
            int valA = mapA.get(key);
            if(valA < val) return false;
        }
        return true;
    }
}
