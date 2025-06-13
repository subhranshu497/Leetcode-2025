package com.june;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceofPairs {
    public static void main(String[] args) {
        int [] nums = {4,2,1,2};
        int p =1;
        int op = minimizeMax(nums, p);
        System.out.println(op);
    }

    private static int minimizeMax(int[] nums, int p) {
        int  n = nums.length;
        //sort the aaray
        Arrays.sort(nums);
        //apply binary search
        int left = 0;
        int right = nums[n-1]-nums[0];
        int result =0;
        while(left <=right){
            int mid= left+(right-left)/2;
            //now search all pairs whose difference is less than or equal to mid
            //save them into a var count
            int count =0;
            int i =0;
            while(i<n-1){
                int diff = Math.abs(nums[i]-nums[i+1]);
                if(diff <=mid){
                    count +=1;
                    i +=2;
                }else{
                    i +=1;
                }
            }
            //now collect the result
            if(count >= p){
                result = mid;
                //try to shrink it
                right = mid-1;
            }else left = mid+1;
        }
        return result;
    }
}
