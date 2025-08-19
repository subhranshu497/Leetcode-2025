package com.august;

public class NumberofZeroFilledSubarrays {
    public static void main(String[] args) {
        int [] nums = {1,3,0,0,2,0,0,4};
        long res = zeroFilledSubarray(nums);
        System.out.println(res);
    }

    private static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int n = nums.length;
        long count =0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count +=1;
                res +=count;
            }
            else count =0;
        }
        return res;
    }
}
