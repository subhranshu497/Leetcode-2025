package com.may;

import java.util.*;

public class MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        int [] tops = {2,1,2,4,2,2};
        int [] bottoms = {5,2,6,2,3,2};
        int count = minDominoRotations(tops, bottoms);
        System.out.println(count);
    }

    private static int minDominoRotations(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;

        for (int val = 1; val <= 6; val++) {
            int swaps = findSwap(val, tops, bottoms);
            if (swaps != -1) {
                result = Math.min(result, swaps);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int findSwap(int val, int[] tops, int[] bottoms) {
        int swapTop = 0;
        int swapBottom = 0;
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (tops[i] != val) {
                swapTop++; // swap top
            } else if (bottoms[i] != val) {
                swapBottom++; // swap bottom
            }
        }
        return Math.min(swapTop, swapBottom);
    }
}
