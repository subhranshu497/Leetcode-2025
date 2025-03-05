package com.march;

public class CountTotalNumberOfColoredCells {
    public static void main(String[] args) {
        int n = 1;
        long res = coloredCells(n);
        System.out.println(res);
    }

    private static long coloredCells(int n) {
        long res = 1;
        for(int i=2;i<=n;i++){
            res +=(i-1)*4;
        }
        return res;
    }
}
