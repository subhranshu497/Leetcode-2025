package com.april;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLargestGroup {
    public static void main(String[] args) {
        int n = 13;
        int count = countLargestGroup(n);
        System.out.println(count);
    }

    private static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        int maxi =0;
        for(int i=1;i<=n;i++){
            int sum = calculateSumOfDigits(i);
            map.put(sum, map.getOrDefault(sum,0)+1);
            maxi = Math.max(maxi, map.get(sum));
        }
        for(int val : map.values()){
            if(val == maxi) count++;
        }
        return count;
    }

    private static int calculateSumOfDigits(int num) {
        int sum =0;
        while (num != 0){
            sum +=num % 10;
            num /=10;
        }
        return sum;
    }
}
