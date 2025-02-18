package com.februry;

import java.util.ArrayList;
import java.util.List;

public class MRUQueue {
    private int [] arr;
    private int [] arr1;
    private int n;

    public MRUQueue(int n) {
        this.n = n;
        arr = new int[n];
        arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
    }

    public int fetch(int k) {
        for(int i=0;i<n;i++){
            if(i<(k-1)){
                arr1[i] = arr[i];
            }else if(i==(k-1)){
                arr1[n-1] = arr[i];
            }else if((i>=k)&&(i<n)){
                arr1[i-1] = arr[i];
            }
        }
        int ans = arr1[arr1.length-1];
        arr = arr1;
        arr1 = new int[n];
        return ans;
    }
}
class Solution{
    public static void main(String[] args) {
        MRUQueue mru = new MRUQueue(8);
        int ans = mru.fetch(5);
        System.out.println(ans);
    }
}
