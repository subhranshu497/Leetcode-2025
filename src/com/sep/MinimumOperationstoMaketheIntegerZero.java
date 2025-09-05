package com.sep;

public class MinimumOperationstoMaketheIntegerZero {
    public static void main(String[] args) {
        int num1 = 3, num2 = -2;
        int res = makeTheIntegerZero(num1, num2);
        System.out.println(res);
    }

    private static int makeTheIntegerZero(int num1, int num2) {
        //eq num1-(t*num2) = 2^0+2^1......+2^t

        int t = 0;
        while (true) {
            long val = (long) num1 - (long) t * num2;
            if (val < 0) return -1;
            int setBits = Long.bitCount(val);
            if (setBits <= t && t <= val) return t;
            t++;
        }
    }
}
