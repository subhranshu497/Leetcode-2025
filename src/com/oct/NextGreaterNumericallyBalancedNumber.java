package com.oct;

public class NextGreaterNumericallyBalancedNumber {
    public static void main(String[] args) {
        int n = 1;
        int num = nextBeautifulNumber(n);
        System.out.println(num);
    }

    private static int nextBeautifulNumber(int n) {
        while(true){
            ++n; //since res should be strictly greater than n
            //take an array to count the digits present in num
            int [] digitCount = new int[10];
            int num = n;
            //now populate the digit count array
            while(num >0){
                digitCount[num % 10]++;
                num /=10;
            }
            boolean flag = true;
            //here checking for the digit count in num
            for(int i=0;i<10;i++){
                if(digitCount[i] !=0 && digitCount[i] != i){
                    flag = !flag;
                    break;
                }
            }
            if(flag) return n;
        }
    }
}
