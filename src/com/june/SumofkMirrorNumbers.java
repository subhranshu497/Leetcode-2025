package com.june;

public class SumofkMirrorNumbers {
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        long res = kMirror(n,k);
        System.out.println(res);
    }

    private static long kMirror(int n, int k) {
        long sum = 0;
        //keep on generating all the pallindrome
        int length =1;
        //to generate pallindrome - check length . calculate halflength
        //minnum = 10^(halflength-1) , maxNum = (10^halflength)-1
        while(n>0){
            int halflength = (length+1)/2;
            long minimumNumber = (long) Math.pow(10,halflength-1);
            long maximumNumber = (long) Math.pow(10,halflength)-1;
            //now iterate over this range and generate all pallindrome
            for(long num =minimumNumber;num<=maximumNumber;num++){
                String str1 = Long.toString(num);
                String str2 = new StringBuilder(str1).reverse().toString();
                String res ="";
                //check for even or odd length
                if(length%2 !=0){
                    res =str1+str2.substring(1);
                }else res = str1+str2;
                //now calculate its k-mirror num
                String kMirrorNum = generateKMirrorNumber(Long.parseLong(res),k);
                if(checkPallindromeI(kMirrorNum)){
                    sum +=Long.parseLong(res);
                    n--;
                }
                if(n==0)return sum;
            }
            length++;
        }
        return sum;
    }

    private static boolean checkPallindromeI(String str) {
        int i=0;
        int n = str.length();
        int j = n-1;
        while (i<=j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }

    private static String generateKMirrorNumber(long num, int k) {
        if(num==0) return "0";
        StringBuilder res = new StringBuilder();
        while(num >0){
            res.append(num%k);
            num /=k;
        }
     return res.toString();
    }

}
