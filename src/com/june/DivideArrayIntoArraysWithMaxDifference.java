package com.june;

import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        int [] nums = {4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};
        int k = 14;
        int [][] result = divideArray(nums, k);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+", ");
            }
            System.out.println();
        }
    }

    private static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n/3][3];
        Arrays.sort(nums);
        int j=0;
        for(int i=2;i<n;i+=3){
            if(Math.abs(nums[i]-nums[i-1])<=k && Math.abs(nums[i]-nums[i-2])<=k && Math.abs(nums[i-2]-nums[i-1]) <=k){
                res[j][0]=nums[i-2];
                res[j][1]=nums[i-1];
                res[j][2]=nums[i];
                j++;
            }
        }
        if(j*3 !=n) return new int[][]{};
        return res;
    }
}
