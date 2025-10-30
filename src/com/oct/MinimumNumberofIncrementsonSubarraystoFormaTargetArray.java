package com.oct;

public class MinimumNumberofIncrementsonSubarraystoFormaTargetArray {
    public static void main(String[] args) {
        int [] target = {1,1,2};
        int ops = minNumberOperations(target);
        System.out.println(ops);
    }

    private static int minNumberOperations(int[] target) {
        int n = target.length;
        int ops =0;
        int prev = 0;
        int i =0;
        while(i < n){
            int curr = target[i];
            //increment case
            if(Math.abs(curr)>Math.abs(prev)){
                ops +=(curr-prev);
            }
            prev = curr;
            i++;
        }
        return ops;
    }
}
