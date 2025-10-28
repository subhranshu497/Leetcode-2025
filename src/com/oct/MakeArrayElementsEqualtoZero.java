package com.oct;

import java.util.Map;

public class MakeArrayElementsEqualtoZero {
    public static void main(String[] args) {
        int [] nums = {2,3,4,0,4,1,0};
        int valid = countValidSelections(nums);
        System.out.println(valid);
    }

    private static int countValidSelections(int[] nums) {
        int n = nums.length;
        int sum =0;
        int res =0;
        for(int num:nums){
            sum +=num;
        }
        int currentSum =0;
        int rightSum =0;
        for(int i=0;i<n;i++){
            currentSum +=nums[i];
            rightSum =sum - currentSum;
            if(nums[i]==0){
                if(rightSum == currentSum)res +=2;
                else if(Math.abs(currentSum-rightSum)==1) res +=1;
            }
        }
        return res;
    }
}
