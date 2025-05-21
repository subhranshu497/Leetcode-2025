package com.may;

import java.util.*;

public class ZeroArrayTransformationI {
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        int [][] queries = {{0,2}};
        boolean flag = isZeroArray(nums, queries);
        System.out.println(flag);
    }

    private static boolean isZeroArray(int[] nums, int[][] queries) {
                int n = nums.length;
                int [] differenceArray = new int[n+1];
                for(int [] query:queries){
                    int left = query[0];
                    int right = query[1];

                    differenceArray[left] +=1;
                    if(differenceArray[right+1] <n)
                        differenceArray[right+1] -=1;
                }
                //find cumsum
        int sum =0;
                int[] cumsum = new int[n];
                for(int i=0;i<n;i++){
                    sum +=differenceArray[i];
                    cumsum[i] = sum;
                }
                for(int num:cumsum)
                    System.out.print(num+", ");
                for(int i=0;i<n;i++){
                    if (cumsum[i]< nums[i]) return false;
                }
                return true;
    }
}
