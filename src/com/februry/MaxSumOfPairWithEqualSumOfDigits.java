package com.februry;

import java.util.*;

public class MaxSumOfPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        int [] nums = {10,12,19,14};
        int maxSum = maximumSum(nums);
        System.out.println(maxSum);
    }

    private static int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int tempSum = calculateDigitSum(nums[i]);
            if(!map.containsKey(tempSum)){
                map.put(tempSum, new ArrayList<>());
            }
            map.get(tempSum).add(nums[i]);
        }
        for(Map.Entry<Integer,List<Integer>> e:map.entrySet()){
            int key = e.getKey();
            int tempSum = 0;
            List<Integer> digitSum = e.getValue();
            if(digitSum.size() >2){
                Collections.sort(digitSum);
                tempSum = digitSum.get(digitSum.size()-1)+digitSum.get(digitSum.size()-2);
                res = Math.max(res, tempSum);
            }
            else if(digitSum.size()==2){
                tempSum = digitSum.get(0)+digitSum.get(1);
                res = Math.max(res, tempSum);
            }
            else if(digitSum.size()==1){
                tempSum =-1;
                res = Math.max(res, tempSum);
            }
        }
        return res;
    }

    private static int calculateDigitSum(int num) {
        int sum = 0;
        while(num >0){
            int rem = num % 10;
            sum +=rem;
            num /= 10;
        }
        return sum;
    }
}
