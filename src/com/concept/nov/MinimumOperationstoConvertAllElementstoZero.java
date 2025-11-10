package com.concept.nov;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumOperationstoConvertAllElementstoZero {
    public static void main(String[] args) {
        int [] nums = {3,1,2,1};
        int ops = minOperationsI(nums);
        System.out.println(ops);
    }

    private static int minOperationsI(int[] nums) {
        int n = nums.length;
        int ops = 0;
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]<st.peek()){
                st.pop();
            }
            if(nums[i] >0 && (st.isEmpty() || nums[i]>st.peek())){
                st.push(nums[i]);
                ops++;
            }
        }
        return ops;
    }
}
