package com.june;

import java.util.Arrays;
import java.util.Map;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition {
    public static void main(String[] args) {
        int [] nums = {3,5,6,7};
        int target = 9;
        int number = numSubseq(nums, target);
        System.out.println(number);
    }

    private static int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        int n = nums.length;
        int [] power = new int[n];
        Arrays.sort(nums);
        power[0] = 1;
        for(int idx=1;idx<n;idx++){
            power[idx] = (power[idx-1]*2)%mod;
        }
        int i = 0;
        int j = n-1;
        int result=0;
        while(i<=j){
            int sum = (nums[i]+nums[j]);
            if(sum>target){
                j--;
            }
            else {
                result = (result + power[j - i]) %mod;
                i++;
            };
        }
        return result;
    }
}
