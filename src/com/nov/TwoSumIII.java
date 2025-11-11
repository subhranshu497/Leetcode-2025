package com.nov;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
    Map<Integer,Integer> map;
    public TwoSumIII(){
        map = new HashMap<>();
    }
    public void add(int number){
        map.put(number, map.getOrDefault(number,0)+1);
    }
    public boolean find(int value){
        for(Integer key:map.keySet()){
            int inv = value-key;
            if(inv !=key && map.containsKey(inv))return true;
            if(inv == key && map.get(key)>=2) return true;
        }
        return false;
    }
}
class runnerClass{
    public static void main(String[] args) {
        TwoSumIII ts = new TwoSumIII();
        ts.add(0);
        boolean flag= ts.find(0);
        System.out.println(flag);
    }
}
