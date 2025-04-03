package com.april;

public class MaximumValueOfAnOrderedTripletII {
    public static void main(String[] args) {
        int [] nums = {1,10,3,4,19};
        long res= maximumTripletValue2(nums);
        System.out.println(res);
    }

    private static long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];
        long res = 0;
        //find left max
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
        }

        for(int i=0;i<n;i++){
            res = Math.max(res, (long)(leftMax[i]-nums[i])*rightMax[i]);
        }
        return res;
    }
}
