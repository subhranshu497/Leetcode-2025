package com.april;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int [] nums = {1,3,5,2,7,5};
        int minK =1;
        int maxK =5;
        long count = countSubarrays(nums, minK, maxK);
        System.out.println(count);
    }

    private static long countSubarrays(int[] nums, int minK, int maxK) {
        long count =0;
        int n = nums.length;
        int minPos =-1;
        int maxPos =-1;
        int pi =-1;
        for(int i=0;i<n;i++){
            if(nums[i] < minK || nums[i] > maxK)
                pi =i;
            if(nums[i]==minK){
                minPos =i;
            }
            if(nums[i]==maxK){
                maxPos = i;
            }
            int smaller = Math.min(maxPos, minPos);
            int temp  = smaller - pi;
            count +=temp<0?0:temp;
        }
        return count ;
    }
}
