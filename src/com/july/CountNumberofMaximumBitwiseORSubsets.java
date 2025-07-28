package com.july;

import java.util.ArrayList;
import java.util.List;

public class CountNumberofMaximumBitwiseORSubsets {
    public static void main(String[] args) {
        int [] nums = {3,1};
        int count = countMaxOrSubsets(nums);
        System.out.println(count);
    }

    private static int countMaxOrSubsets(int[] nums) {
        //first calculate the max xor of the array
        int maxOr = 0;
        int n = nums.length;
        for(int num:nums)
            maxOr |=num;
        //form subset and check if its or is equal to maxOr
        int count = formSubsetAndCheck(nums, maxOr, 0,0, new ArrayList<>(),n);
        return count;
    }

    private static int formSubsetAndCheck(int[] nums, int maxOr,int or, int i, List<Integer> l, int n) {
        //base condition
        if(i>=n){
            if(or==maxOr)
                return 1;
            else return 0;
        }
        int count =0;
        //take the element
        l.add(nums[i]);
        int take =count+formSubsetAndCheck(nums,maxOr, or|nums[i], i+1,l,n);
        l.remove(l.size()-1);
        int skip =count+formSubsetAndCheck(nums,maxOr, or,i+1,l,n);

        return take+skip;
    }
}
