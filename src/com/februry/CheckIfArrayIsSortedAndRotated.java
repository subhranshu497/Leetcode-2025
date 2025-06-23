package com.februry;

import java.io.*;
import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int [] nums = {2,1,3,4};
        boolean flag = check(nums);
        System.out.println(flag);
    }

    private static boolean check(int[] nums) {
        int n = nums.length;
        int x =-1;
        for(int i=1;i<n;i++){
            if (nums[i] >nums[i-1]){
                continue;
            }else if(nums[i]< nums[i-1]){
                x = i;
                break;
            }
        }
        if(x == -1) return true;
        int [] b = new int[n];
        for(int i=0;i<n;i++){
            b[i] = nums[(i+x)%n];
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i] !=b[i])
                return false;
        }
        return true;
    }
}
