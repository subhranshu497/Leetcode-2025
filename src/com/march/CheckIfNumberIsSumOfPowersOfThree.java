package com.march;

public class CheckIfNumberIsSumOfPowersOfThree {
    public static void main(String[] args) {
        int n =12;
        System.out.println(checkPowersOfThree(n));
    }

    private static boolean checkPowersOfThree(int n) {
        while(n >0){
            if(n % 3==2)
                return false;
            n /=3;
        }
        return true;
    }
}
