package com.nov;

public class MaximumSubarraySumWithLengthDivisiblebyK {
    public static void main(String[] args) {
        int [] nums = {-1,-2,-3,-4,-5};
        int k = 4;
        long res = maxSubarraySumI(nums, k);
        System.out.println(res);
    }

    private static long maxSubarraySumI(int[] nums, int k) {
        long res = Long.MIN_VALUE;
        int n = nums.length;
        long [] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i=1;i< n;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }

        for(int st = 0;st<k;st++){
            long currSum =0;
            int i = st;
            while (i<n && i+k-1 < n){
                int j = i+k-1;
                long subArrSum = prefixSum[j] - ((i>0)?prefixSum[i-1]:0);
                currSum = Math.max(subArrSum, currSum+subArrSum);
                res = Math.max(currSum, res);
                i +=k;
            }
        }
        return res;
    }
}
