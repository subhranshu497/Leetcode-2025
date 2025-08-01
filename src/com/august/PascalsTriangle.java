package com.august;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res = generateI(n);
        System.out.println(res);
    }
    public static List<List<Integer>> generateI(int numRows) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>currList = new ArrayList<>();
        currList.add(1);
        res.add(new ArrayList<>(currList));
        if(numRows==1) return res;
        currList.add(1,1);
        res.add(new ArrayList<>(currList));
        if(numRows==2) return res;
        for(int i=3;i<=numRows;i++){
            currList = new ArrayList<>();
            List<Integer> prevList = res.get(res.size()-1);
            currList.add(1);
            for(int j=1;j<prevList.size();j++){
                int element = prevList.get(j)+prevList.get(j-1);
                currList.add(element);
            }
            currList.add(1);
            res.add(new ArrayList<>(currList));
        }
        return res;
    }
}
