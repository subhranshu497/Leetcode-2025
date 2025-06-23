package com.dsaSheet.lovebabbar;

import java.util.ArrayList;
import java.util.List;

public class Valueequaltoindexvalue {
    public static void main(String[] args) {
        List<Integer> nums = List.of(15, 2, 45, 4 , 7);
        List<Integer> list = valueEqualToIndex(nums);
        System.out.println(list);
    }

    private static List<Integer> valueEqualToIndex(List<Integer> nums) {
        int n = nums.size();
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(i+1== nums.get(i))
                res.add(nums.get(i));
        }
        return res;
    }
}
