package com.may;

public class MinimumEqualSumofTwoArraysAfterReplacingZeros {
    public static void main(String[] args) {
        int [] nums1 = {3,2,0,1,0};
        int [] nums2 = {6,5,0};
        long sum = minSum(nums1, nums2);
        System.out.println(sum);
    }

    private static long minSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        long sum1 =0;
        long sum2 =0;
        int zeroCount1 =0;
        int zeroCount2 =0;
        for(int i=0;i<n1;i++){
            sum1 += nums1[i];
            if(nums1[i]==0)zeroCount1++;
        }
        for(int i=0;i<n2;i++){
            sum2 +=nums2[i];
            if(nums2[i]==0)zeroCount2++;
        }
        long min1 = sum1+zeroCount1;
        long min2 = sum2+zeroCount2;
        //if there is no zeros
        if(zeroCount1==0 && zeroCount2==0)
            return sum1==sum2?sum1:-1;
        else if(zeroCount1==0)
            return sum2+zeroCount2 <=sum1?sum1:-1;
        else if(zeroCount2==0)
            return sum1+zeroCount1 <=sum2?sum2:-1;

        return Math.max(min1, min2);
    }

}
