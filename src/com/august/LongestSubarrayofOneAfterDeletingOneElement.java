package com.august;

public class LongestSubarrayofOneAfterDeletingOneElement {
    public static void main(String[] args) {
        int [] nums = {0,1,1,1,0,1,1,0,1};
        int res = longestSubarrayI(nums);
        System.out.println(res);
    }

    private static int longestSubarrayI(int[] nums) {
        int maxlen = 0;
        int i = 0;
        int j =0;
        int n = nums.length;
        for(int num:nums){
            if(num==1) i++;
            else{
                maxlen = Math.max(maxlen, i+j);
                j = i;
                i =0;
            }
        }
        maxlen = Math.max(maxlen, i+j);
        return maxlen==n?maxlen-1:maxlen;
    }
}
