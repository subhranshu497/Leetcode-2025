package com.concept.recursion;

public class DavisStaircase {
    public static void main(String[] args) {
        int n =5;
        int ways = stairsCase(n);
        System.out.println(ways);
    }

    private static int stairsCase(int n) {

        //base condition
        if(n==0){
            return 1;
        }
        int ways =0;
        //Davis took 1 step
        ways +=stairsCase(n-1);
        ways +=stairsCase(n-2);
        ways +=stairsCase(n-3);

        return ways;
    }
}
