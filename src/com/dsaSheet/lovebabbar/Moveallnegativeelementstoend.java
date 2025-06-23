package com.dsaSheet.lovebabbar;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class Moveallnegativeelementstoend {
    public static void main(String[] args) {
        int [] arr = {-5, 7, -3, -4, 9, 10, -1, 11};
        segregateElements(arr);
    }

    private static void segregateElements(int[] arr) {
        int n = arr.length;
        int [] res = new int[n];
        int j =0;
        for(int k=0;k<n;k++){
            if(arr[k]>0){
                res[j]= arr[k];
                j++;
            }
        }
        //traverse for -ve
        for(int k=0;k<n;k++){
            if(arr[k]<0){
                res[j]= arr[k];
                j++;
            }
        }
        for(int k=0;k<n;k++){
            arr[k] = res[k];
        }
        //print
        for(int r:arr)
            System.out.print(r+", ");
    }
}
