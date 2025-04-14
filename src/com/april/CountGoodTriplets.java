package com.april;

public class CountGoodTriplets {
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3};
        int a = 0;
        int b = 0;
        int c = 1;
        int res = countGoodTriplets(arr, a,b,c);
        System.out.println(res);
    }

    private static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count =0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j =i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(Math.abs(arr[i]-arr[j]) <=a && Math.abs(arr[j]-arr[k]) <=b && Math.abs(arr[i]-arr[k]) <= c)count++;
                }
            }
        }
        return count;
    }
}
