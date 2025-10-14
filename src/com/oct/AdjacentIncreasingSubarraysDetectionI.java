package com.oct;

import java.util.List;
import java.util.Map;

public class AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        List<Integer> nums = List.of(-15, 3, 16,0);
        int k =2;
        System.out.println(hasIncreasingSubarrays(nums, k));
    }

    private static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int currentRun = 1;
        int prevRun =0;
        for(int i=1;i<n;i++){
            if(nums.get(i-1)<nums.get(i)){
                currentRun +=1;
            }else {
                prevRun = currentRun;
                currentRun =1;
            }
            if(currentRun >= 2*k || Math.min(currentRun,prevRun)>=k) return true;
        }
        return false;
    }
}
