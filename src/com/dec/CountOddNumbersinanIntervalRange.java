package com.dec;

public class CountOddNumbersinanIntervalRange {
    public static void main(String[] args) {
        int high = 10;
        int low = 8;
        int count = countOdds(low,high);
        System.out.println(count);
    }

    private static int countOdds(int low, int high) {
        return (high+1)/2-(low+1)/2+ ((low % 2 != 0 )?1:0);
    }
}
