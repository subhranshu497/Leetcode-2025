package com.dec;

import java.util.*;

public class CountSpecialTriplets {
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int [] nums = {0,1,0,0};
        int res = specialTriplets(nums);
        System.out.println(res);
    }

    private static int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mapRight = new HashMap<>();
        for(int i=0;i<n;i++){
            mapRight.put(nums[i], mapRight.getOrDefault(nums[i],0)+1);
        }
        int res =0;
        Map<Integer, Integer> mapLeft = new HashMap<>();
        for(int i=0;i<n;i++){
            mapRight.put(nums[i], mapRight.getOrDefault(nums[i],0)-1);
            int twiceKey = 2*nums[i];
            int left = mapLeft.getOrDefault(twiceKey, 0);
            int right = mapRight.getOrDefault(twiceKey, 0);
            long add = (1L*left*right)%MOD;
            res =(int)(res+add)%MOD;

            mapLeft.put(nums[i], mapLeft.getOrDefault(nums[i],0)+1);
        }
        return res;
    }


    //brute force
    private static int specialTripletsBT(int[] nums) {
        int n = nums.length;
        int res =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int mid = nums[j]*2;
                for(int k=j+1;k<n;k++){
                    if(nums[i]==mid && nums[k]==mid)
                        res++;
                }
            }
        }
        return res;
    }
}
