package com.august;

import java.net.CookieHandler;
import java.util.*;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int [] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        int res = totalFruit(fruits);
        System.out.println(res);
    }

    private static int totalFruit(int[] fruits) {
            int n = fruits.length;
            int res= Integer.MIN_VALUE;
            Map<Integer, Integer> fruitFreq = new HashMap<>();
            int r =0;
            int l=0;
            while (r<n){
                fruitFreq.put(fruits[r], fruitFreq.getOrDefault(fruits[r], 0)+1);
                while(fruitFreq.size()>2){
                    fruitFreq.put(fruits[l], fruitFreq.get(fruits[l])-1);
                    if(fruitFreq.get(fruits[l])==0)
                        fruitFreq.remove(fruits[l]);
                    l++;
                }
                res = Math.max(res, r-l+1);
                r++;
            }
            return res;
    }
}
