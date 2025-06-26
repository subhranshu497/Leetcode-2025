package com.dsaSheet.lovebabbar;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int [] arr = {2, 3, -8, 7, -1, 2, 3};
        int sum = maxSubarraySum(arr);
        System.out.println(sum);
    }

    private static int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int res = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0;i<n;i++){
            sum +=arr[i];
            if(sum<0)
                sum =0;
            res = Math.max(res, sum);
        }
        return res;
    }
}
