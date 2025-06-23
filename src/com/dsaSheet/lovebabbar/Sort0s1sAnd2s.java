package com.dsaSheet.lovebabbar;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sort0s1sAnd2s {

    public static void main(String[] args) {
        int [] arr = {0, 1, 2, 0, 1, 2};
        System.out.println(arr);
        sort0121(arr);
        System.out.println(arr);
        for(int a:arr)
            System.out.print(a+", ");
    }

    private static void sort012(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int a:arr)
            map.put(a, map.getOrDefault(a,0)+1);

        int i=0;
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            int val = e.getValue();
            int key = e.getKey();
            while(val !=0){
                arr[i] = key;
                val--;
                i++;
            }
        }
    }

    //using freq arr
    private static void sort0121(int[] arr) {
        int [] freq = new int[3];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        for(int i=0;i<arr.length;i++){
            if(freq[0] != 0){
                arr[i] = 0;
                freq[0]--;
            }else if(freq[1] != 0){
                arr[i] = 1;
                freq[1]--;
            }else if(freq[2] != 0){
                arr[i] = 2;
                freq[2]--;
            }
        }
    }
}
