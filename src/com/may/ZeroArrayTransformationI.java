package com.may;

import java.util.*;

public class ZeroArrayTransformationI {
    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        int [][] queries = {{1,3},{0,2}};
        boolean flag = isZeroArray(nums, queries);
        System.out.println(flag);
    }

    private static boolean isZeroArray(int[] nums, int[][] queries) {
                int n = nums.length;
                int overlap[] = new int[n+1];

                for (int i = 0; i < queries.length; i++) {
                    overlap[queries[i][0]]++;
                    overlap[queries[i][1]+1]--;
                }
                int count = 0;
                for (int i = 0; i < n; i++) {
                    count += overlap[i];
                    if (count < nums[i]) return false;
                }
                return true;
    }
}
