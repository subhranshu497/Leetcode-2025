package com.sep;

public class DivideArrayIntoIncreasingSequences {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,3,4,4};
        int k =3;
        boolean flag = canDivideIntoSubsequences(nums,k);
        System.out.println(flag);
    }

    private static boolean canDivideIntoSubsequences(int[] nums, int k) {
        int n = nums.length;
        if(n<k) return false;
        int i =0;
        int j =0;
        int max =0;
        while (i<n){
            j=i;
            while (j<n && nums[j]==nums[i]){
                ++j;
                max=Math.max(max, j-i);
                i=j;
            }
        }
        if(nums.length/max>=k)
            return true;
        return false;
    }
}
