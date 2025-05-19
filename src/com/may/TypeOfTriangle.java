package com.may;

import java.util.HashSet;
import java.util.Set;

public class TypeOfTriangle {
    public static void main(String[] args) {
        int [] nums = {3,3,3};
        String s = triangleType(nums);
        System.out.println(s);
    }

    private static String triangleType(int[] nums) {
        //first check if triangle formation is possible
        if(!((nums[0]+nums[1] > nums[2])&&(nums[0]+nums[2] > nums[1])&&(nums[2]+nums[1] > nums[0])))
            return "none";
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        set.add(nums[1]);
        set.add(nums[2]);
        if(set.size()==1) return "equilateral";
        else if(set.size()==2) return "isosceles";
        else return "scalene";
    }
}
