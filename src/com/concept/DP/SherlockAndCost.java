package com.concept.DP;

import java.util.List;
import java.util.Map;

public class SherlockAndCost {
    public static void main(String[] args) {
        List<Integer> b = List.of(3,15,4,12,10);
        int maxCost = cost(b);
        System.out.println(maxCost);
    }

    private static int cost(List<Integer> b) {
        int n = b.size();
        int sum = 0;
        for(int i=1; i<n;i++){
            int maxVal = Math.max(b.get(i),b.get(i-1));
            sum += Math.abs(maxVal-1);
        }
        return sum;
    }
}
