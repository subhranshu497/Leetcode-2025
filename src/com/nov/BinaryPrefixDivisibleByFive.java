package com.nov;

import java.lang.foreign.SymbolLookup;
import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleByFive {
    public static void main(String[] args) {
        int [] nums = {0,1,1};
        List<Boolean> res = prefixesDivBy5(nums);
        System.out.println(res);
    }

    private static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int prefix = 0;
        for(int num:nums){
            prefix = ((prefix*2)+num)%5;
            boolean flag = prefix==0?true:false;
            res.add(flag);
        }
        return res;
    }
}
