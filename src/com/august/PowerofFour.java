package com.august;

public class PowerofFour {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(isPowerOfFour(n));
    }

    private static boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        while(n>1){
            int rem = n%4;
            if(rem !=0) return false;
            n /=4;
        }
        return true;
    }
}
