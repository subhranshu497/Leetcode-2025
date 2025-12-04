package com.dec;

import java.util.Stack;

public class CountCollisionsonaRoad {
    public static void main(String[] args) {
        String directions = "RLRSLL";
        int collisions = countCollisions(directions);
        System.out.println(collisions);
    }

    private static int countCollisions(String directions) {
        int n = directions.length();
        int collisions =0;
        int left =0;
        int right = n-1;
        while(left < right && directions.charAt(left)=='L')left++;
        while(left < right && directions.charAt(right)=='R')right--;
        if(left>=right) return 0;
        for(;left<=right;left++){
            collisions +=directions.charAt(left) !='S'?1:0;
        }
        return collisions;
    }
}
