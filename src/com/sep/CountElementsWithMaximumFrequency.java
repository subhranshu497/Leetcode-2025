package com.sep;

import java.util.*;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,1,4};
        int freq = maxFrequencyElements(nums);
        System.out.println(freq);
    }

    private static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> values = new ArrayList<>();
        for(Map.Entry<Integer, Integer>e:map.entrySet()){
            int val = e.getValue();
            values.add(val);
        }
        Collections.sort(values, Collections.reverseOrder());
        int res = values.get(0);
        if(values.size()==1) return res;
        for(int i=1;i<values.size();i++){
            if(values.get(i)==values.get(i-1))
                res +=values.get(i);
            else break;
        }
        return res;
    }
}
