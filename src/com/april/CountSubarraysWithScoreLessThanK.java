package com.april;

public class CountSubarraysWithScoreLessThanK {
    public static void main(String[] args) {
        int [] nums = {2,1,4,3,5};
        int k =10;
        long count = countSubarrays2(nums, k);
        System.out.println(count);
    }

    private static long countSubarrays2(int[] nums, int k) {
        long count =0;
        int i =0, j=0;
        int n = nums.length;
        long sum =0;
        while(j<n){
            sum +=nums[j];
            while ((i<=j) && sum*(j-i+1) >=k){
                sum -=nums[i];
                i++;
            }
            count +=(j-i+1);
            j++;
        }
        return count;
    }
}
