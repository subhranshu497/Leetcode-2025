package com.string;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int [] nums = {20,100,10,12,5,13};
        boolean flag = increasingTriplet(nums);
        System.out.println(flag);
    }

    private static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]<=num1)
                num1=nums[i];
            else if(nums[i]<=num2)
                num2 = nums[i];
            else return true;
        }
        return false;
    }

}
