package com.dec;

public class LongestSubarrayof1sAfterDeletingOneElement {

    public static void main(String[] args) {
        int [] nums = {0,1,1,1,0,1,1,0,1};
        int res = longestSubarrayII(nums);
        System.out.println(res);
    }

    private static int longestSubarrayII(int[] nums) {
        int n = nums.length;
        int i=0;
        int j =0;
        int count =0;
        int res = 0;
        int zeroCount =0;
        while (j<n){
            if(nums[j]==0)
                zeroCount +=1;
            if(zeroCount==2){
                res = Math.max(res, j-i+1);
                i=j;
            }
            j++;
        }
        return res;
    }
}
