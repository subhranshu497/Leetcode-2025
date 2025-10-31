package com.oct;

import java.util.HashSet;
import java.util.Set;

public class TheTwoSneakyNumbersofDigitville {
    public static void main(String[] args) {
        int [] nums = {0,1,1,0};
        int [] res = getSneakyNumbers(nums);
        System.out.println(res[0]+", "+res[1]);
    }

    private static int[] getSneakyNumbers(int[] nums) {
        int [] res = new int[2];
        Set<Integer> set = new HashSet<>();
        int i=0;
        for(int num:nums){
            if(!set.contains(num)) set.add(num);
            else{
                res[i] = num;
                i++;
            }
            if(i==2)break;
        }
        return res;
    }
}
