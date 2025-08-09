package com.august;

public class PowerofTwo {
    public static void main(String[] args) {
        int n = 3;
        boolean flag = isPowerOfTwoI(n);
        System.out.println(flag);
    }

    private static boolean isPowerOfTwoI(int n) {
        if(n==1) return true;
        if(n<=0) return false;
        while(n > 1){
            int rem = n%2;
            if(rem !=0) return false;
            n /=2;
        }
        return true;
    }
}
