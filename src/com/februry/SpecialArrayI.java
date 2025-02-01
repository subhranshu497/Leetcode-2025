package com.februry;

public class SpecialArrayI {
    public static void main(String[] args) {
        int [] nums = {2,1,4};
        System.out.println(isArraySpecial(nums));
    }

    private static boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]%2==nums[i-1]%2) return false;
        }
        return true;
    }
}
