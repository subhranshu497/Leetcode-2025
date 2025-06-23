package com.dsaSheet.lovebabbar;

public class PalindromicArray {
    public static void main(String[] args) {
        int [] arr = {121, 131, 20};
        boolean flag = isPalinArray(arr);
        System.out.println(flag);
    }

    private static boolean isPalinArray(int[] arr) {
        boolean flag = false;
        for(int a:arr){
            flag = checkPallindrome(a);
            if(!flag) return false;
        }
        return true;
    }

    private static boolean checkPallindrome(int a) {
        if(a<10) return true;
        int num = a;
        int rev = 0;
        while(a>0){
            int digit = a%10;
            rev = (rev*10)+digit;
            a /=10;
        }
        return num==rev;
    }
}
