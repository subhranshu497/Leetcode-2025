package com.slidingwindow;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        int [] nums = {0,1,1,1,0,1,1,0,1};
        int len = longestSubarrayIII(nums);
        System.out.println(len);
    }

    private static int longestSubarrayIII(int[] nums) {
        int zeroCount = 0;
        int n = nums.length;
        int maxLen = Integer.MIN_VALUE;
        int j =0, i=0;
        while (j<n){
            if(nums[j]==1){
                maxLen = Math.max(maxLen, j-i);
            }else zeroCount +=1;
            while (zeroCount >1){
                if(nums[i]==0)
                    zeroCount -=1;
                i++;
            }
            maxLen = Math.max(maxLen, j-i);
            j++;
        }
        return maxLen;
    }
}
