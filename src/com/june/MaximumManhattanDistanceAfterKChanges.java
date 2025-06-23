package com.june;

import java.util.HashMap;
import java.util.Map;

public class MaximumManhattanDistanceAfterKChanges {
    public static void main(String[] args) {
        String s = "NWSE";
        int k = 1;
        int dist = maxDistance(s, k);
        System.out.println(dist);
    }

    private static int maxDistance(String s, int k) {

        int md = 0;
        int north =0, south =0, east=0, west =0;
       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch=='N')north++;
           else if(ch=='S') south++;
           else if(ch=='E') east++;
           else if(ch=='W') west++;
           int currMD = Math.abs(east-west)+ Math.abs(north-south);
           int steps = i + 1;
           int wasted = steps - currMD;

           int extra = Math.min(2 * k, wasted);

           int finalCurrentMD = currMD + extra;

           md = Math.max(md, finalCurrentMD);
       }

        return md;
    }
}
