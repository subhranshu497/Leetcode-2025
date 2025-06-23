package com.dsaSheet.lovebabbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int []  arr = {4, 3, 6, 2, 1, 1};
        ArrayList<Integer> res = findTwoElement(arr);
        System.out.println(res);
    }

    private static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        boolean [] visited = new boolean[n+1];
        //find repeating
        for(int i=0;i<n;i++){
            if(!visited[arr[i]])
                visited[arr[i]] = true;
            else res.add(arr[i]);
        }
        //find missing
        for(int i =1;i<=n;i++){
            if(!visited[i]){
                res.add(i);
                break;
            }
        }
        return res;
    }
}
