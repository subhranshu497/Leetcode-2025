package com.june;

import java.util.*;

public class FindAllKDistantIndicesinanArray {
    public static void main(String[] args) {
        int [] nums = {2,2,2,2,2};
        int k = 2;
        int key = 2;
        List<Integer> res = findKDistantIndices(nums, k, key);
        System.out.println(res);
    }

    private static List<Integer> findKDistantIndices(int[] nums, int k, int key) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int i =0;
        int j = i;
        while (j<n && i<n){
            int diff = Math.abs(i-j);
            if(diff <=k){
                if(nums[j]==key){
                    res.add(i);
                    i++;
                }else {
                    j++;
                }
            }else if(i<j) i++;
            else if(i>=j) j++;
        }
        return res;
    }
}
