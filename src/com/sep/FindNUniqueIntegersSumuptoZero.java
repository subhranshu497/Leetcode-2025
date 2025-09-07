package com.sep;

public class FindNUniqueIntegersSumuptoZero {
    public static void main(String[] args) {
        int n = 5;
        int [] res = sumZero(n);
        System.out.println(res);
    }

    private static int[] sumZero(int n) {
        int[] result = new int[n];

        int start = 1;
        int i = 0;
        while (i + 1 < n) {
            result[i] = start;
            result[i + 1] = -start;

            i += 2;
            start++;
        }
        return result;
    }
}
