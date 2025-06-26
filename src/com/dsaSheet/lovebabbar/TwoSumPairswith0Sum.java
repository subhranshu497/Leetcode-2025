package com.dsaSheet.lovebabbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSumPairswith0Sum {
    public static void main(String[] args) {
        int [] arr ={0,0,0};
        ArrayList<ArrayList<Integer>> pairs = getPairs(arr);
        System.out.println(pairs);
    }

    private static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                map.put(arr[i], i);
            }
        }
        System.out.println(map);
        //iterate the arr and search for pairs
        //check for only -ve numbers
        for(int i=0;i< arr.length;i++){
            if(arr[i]<=0){
                int num = Math.abs(arr[i]);
                if(map.containsKey(num)&& i !=map.get(num)){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(arr[i]);
                    pair.add(num);
                    pairs.add(pair);
                    map.remove(num);
                }
            }
        }
        //sort the pairs
        Collections.sort(pairs, (a,b)->Integer.compare(a.get(0),b.get(0)));
        return pairs;
    }
}
