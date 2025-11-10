package com.concept.nov;

import java.util.Arrays;

public class MaximizetheMinimumPoweredCity {
    public static void main(String[] args) {
        int [] stations = {1,2,4,5,0};
        int r =1;
        int k=2;
        long res = maxPower(stations, r, k);
        System.out.println(res);
    }

    private static long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long [] diffArr = new long[n];
        //build the diff array
        for(int i=0;i<n;i++){
            int l = Math.max(0, i-r);
            int rt = i+r+1;
            diffArr[l] +=stations[i];
            if(rt < n)
                diffArr[rt] -=stations[i];
        }
        //binary search
        long left =Arrays.stream(stations).min().getAsInt();
        long right = Arrays.stream(stations).asLongStream().sum()+k;
        long res = 0;
        while (left <=right){
            long mid = left +(right-left)/2;
            if(checkPower(mid, k, diffArr, r, n)){
                res = mid;
                left =mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }

    private static boolean checkPower(long mid, int k, long[] diffArr, int r, int n) {
        long [] tempDiffArr = Arrays.copyOf(diffArr,n);
        long sum =0;
        for(int i=0;i<n;i++){
            sum +=tempDiffArr[i];
            if(sum <mid){
                long need = mid - sum;
                if(need > k) return false;
                k -=need;
                sum +=need;
                if(i+2*r+1 <n)
                    tempDiffArr[i+2*r+1] -=need;
            }
        }
        return true;
    }
}
