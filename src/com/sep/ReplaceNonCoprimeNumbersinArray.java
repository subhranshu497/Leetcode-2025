package com.sep;

import java.util.ArrayList;
import java.util.List;

public class ReplaceNonCoprimeNumbersinArray {
    public static void main(String[] args) {
        int [] nums = {6,4,3,2,7,6,2};
        List<Integer> res = replaceNonCoprimes(nums);
        System.out.println(res);
    }

    private static List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            while (!res.isEmpty()) {
                int prev = res.get(res.size() - 1);
                int g = findGcd(prev, num);
                if (g == 1) {
                    break;
                }
                res.removeLast();
                long lcm = (long) prev / g * num;
                num = (int) lcm;
            }
            res.add(num);
            if(n==1)return res;
        }
        return res;
    }

    private static int findGcd(Integer a, int b) {
        while (b !=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
