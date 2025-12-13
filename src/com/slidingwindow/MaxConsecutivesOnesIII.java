package com.slidingwindow;

public class MaxConsecutivesOnesIII {
    public static void main(String[] args) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int res = longestOnes(nums,k);
        System.out.println(res);
    }

    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int zeroCount =0;
        int left =0, right =0;
        while(right < n){
            if(nums[right]==0){
                zeroCount +=1;
            }
            while(zeroCount > k){
                if(nums[left]==0)zeroCount -=1;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
