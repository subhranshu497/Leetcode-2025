package com.concept.binarysearch;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 5;
        int res = firstBadVersion(n);
        System.out.println(res);
    }

    private static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int firstBad =-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                firstBad = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return firstBad;
    }

    private static boolean isBadVersion(int bad) {

        if(bad==5) return true;
        return false;
    }
}
