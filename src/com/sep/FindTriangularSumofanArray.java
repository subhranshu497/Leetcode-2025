package com.sep;

public class FindTriangularSumofanArray {
    public static void main(String[] args) {
        int [] nums = {5};
        int sum = triangularSum(nums);
        System.out.println(sum);
    }

    private static int triangularSum(int[] nums) {
        int n = nums.length;
        int [] newNums = new int[n-1];
        while (nums.length !=1){
            int j=0;
            for(int i=1;i<nums.length;i++){
                newNums[j++]=(nums[i]+nums[i-1])%10;
            }
            nums = new int[newNums.length-1];
            nums = newNums;
            newNums = new int[nums.length-1];
        }
        return (nums[0])%10;
    }
}
