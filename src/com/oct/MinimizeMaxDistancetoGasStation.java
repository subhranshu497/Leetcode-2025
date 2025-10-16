package com.oct;

public class MinimizeMaxDistancetoGasStation {
    public static void main(String[] args) {
        int [] stations = {1,2,3,4,5,6,7,8,9,10};
        int k = 9;
        double res = minmaxGasDist(stations, k);
        System.out.println(res);
    }

    private static double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double l = 0;
        double ans = 0;
        double r = stations[n-1]-stations[0];
        while(l<=r){
            double mid = l+(r-l)/2;
            if(checkI(stations, k, mid,n)){
                ans = mid;
                r = mid-0.000001;
            }else l = mid+0.000001;
        }
        return ans;
    }

    private static boolean checkI(int[] stations, int k, double mid, int n) {
        int count =0;
        for(int i=1;i<n;i++){
            int diff = stations[i]-stations[i-1];
            if(diff > mid){
                count +=diff/mid;
            }
        }
        return count>k?false:true;
    }
}
