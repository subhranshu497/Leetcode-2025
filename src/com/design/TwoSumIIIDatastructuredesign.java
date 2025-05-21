package com.design;

import java.util.*;

public class TwoSumIIIDatastructuredesign {
    private Map<Integer, Integer> map ;
    private List<Integer> list;

    TwoSumIIIDatastructuredesign(){
        map = new HashMap<>();
        list = new LinkedList<>();
    }
    public void add(int number) {
        if(!map.containsKey(number)){
            map.put(number,1);
            list.add(number);
        }else {
            map.put(number,map.get(number)+1);
        }
    }

    public boolean find(int value) {
        for(Integer key:map.keySet()){
            int inv = value-key;
            if(inv != key && map.containsKey(inv)) return true;
            else if(inv == key && map.get(key)>=2) return true;
        }
        return false;
    }
}
