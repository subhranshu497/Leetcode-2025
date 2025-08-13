package com.august;

public class PowerofThree {
    public static void main(String[] args) {
        int num =27;
        boolean flag = isPowerOfThree(num);
        System.out.println(flag);
    }

    private static boolean isPowerOfThree(int num) {
        while(num>1){
            int rem = num%3;
            if(rem !=0) return false;
            num /=3;
        }
        return true;
    }
}
