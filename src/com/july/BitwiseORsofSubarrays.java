package com.july;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BitwiseORsofSubarrays {
    public static void main(String[] args) {
        int [] arr= {1,2,4};
        int res = subarrayBitwiseORs(arr);
        System.out.println(res);
    }

    private static int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        for(int num:arr){
            Set<Integer> next = new HashSet<>();
            next.add(num);
            for(int x:curr)
                next.add(x | num);
            curr = next;
            res.addAll(curr);
        }
        return res.size();
    }
}
