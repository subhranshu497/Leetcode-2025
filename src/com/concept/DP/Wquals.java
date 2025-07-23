package com.concept.DP;

import java.util.Arrays;
import java.util.Set;

public class Wquals {
    public static void main(String[] args) {
        int [] arr = {1,1,5};
        int round = equalsSolve(arr);
        System.out.println(round);
    }

    private static int equalsSolve(int[] arr) {
        Set<Integer> countSet = Set.of(1,2,5);
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int roundCount=0;
        for(int i=1;i<n;i++){
            int diff=0;
            if(arr[i] != arr[i-1]){
                max = Math.max(arr[i], arr[i-1]);
                min = Math.min(arr[i], arr[i-1]);
                diff = max-min;
            }

        }
        //yet to be completed
        return 0;
    }
}
