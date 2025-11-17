package com.nov;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        int [] nums = {-1,1,-1,-1};
        int target = -1;
        int count = threeSumSmaller(nums, target);
        System.out.println(count);
    }

    private static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count =0;
        for(int i=0;i<n-2;i++){
           int x = nums[i];
           int j=i+1;
           int k=n-1;
           while(j<k){
               int sum = x+nums[j]+nums[k];
               if(sum<target){
                   count +=k-j;
                   j++;
               }else k--;
           }
        }
        return count;
    }
}
