package com.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountEqualAndDivisiblePairsInAnArray {
    public static void main(String[] args) {
        int [] nums= {1,2,3,4};
        int k = 1;
        int pairs = countPairs(nums, k);
        System.out.println(pairs);
    }

    private static int countPairs(int[] nums, int k) {
        int pairs =0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer> l = map.get(nums[i]);
                l.add(i);
                map.put(nums[i],l);
            }
            else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i],l);
            }
        }
        System.out.println(map);
        //iterate map
        for(Map.Entry<Integer, List<Integer>> e:map.entrySet()){
            int key = e.getKey();
            List<Integer> listVal = e.getValue();
            if(listVal.size() >=2){
                int i=0;
                while(i<listVal.size()){
                    int iVal = listVal.get(i);
                    int j=i+1;
                    while(j<listVal.size()){
                        int jVal = listVal.get(j);
                        if((iVal*jVal)%k==0)pairs++;
                        j++;
                    }
                    i++;
                }
            }
        }
        return pairs;
    }
}
