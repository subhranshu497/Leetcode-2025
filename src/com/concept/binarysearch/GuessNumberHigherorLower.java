package com.concept.binarysearch;

public class GuessNumberHigherorLower {
    public static void main(String[] args) {
        int n = 10;
       int num = guessNumber(n);
        System.out.println(num);
    }

    private static int guessNumber(int n) {
        int left =0;
        int right = n;
        while(left<=right){
            int mid = left+(right-left)/2;
            int val = guess(mid);
            if(val==-1)
                right = mid-1;
            else if(val==1)
                left = mid+1;
            else{
                return mid;
            }
        }
        return -1;
    }

    private static int guess(int mid) {
        int pick = 6;
        if(mid>pick) return -1;
        else if(mid<pick) return 1;
        else return 0;
    }
}
