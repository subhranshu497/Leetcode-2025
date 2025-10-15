package com.oct;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AdjacentIncreasingSubarraysDetectionII {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,4,4,4,5,6,7);
        int k = maxIncreasingSubarrays(nums);
        System.out.println(k);
    }

    private static int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int currentRun = 1;
        int k =0;
        int prevRun =0;
        for(int i=1;i<n;i++){
            if(nums.get(i-1) < nums.get(i)){
                currentRun +=1;
            }else {
                prevRun = currentRun;
                currentRun =1;
            }
            k = Math.max(k, currentRun/2);
            k = Math.max(k, Math.min(prevRun, currentRun));
        }
        return k;
    }
}
