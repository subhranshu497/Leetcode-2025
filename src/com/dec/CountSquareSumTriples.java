package com.dec;

import java.util.HashMap;
import java.util.Map;

public class CountSquareSumTriples {
    public static void main(String[] args) {
        int n = 10;
        int res = countTriples(n);
        System.out.println(res);
    }

    private static int countTriples(int n) {
        Map<Double, Double> map = new HashMap<>();
        for(double i=1;i<=n;i++){
            map.put(i, i*i);
        }
        int count =0;
        for(Map.Entry<Double, Double> e:map.entrySet()){
            double key = e.getKey();
            double val = e.getValue();
            for(double i=1;i<=n;i++){
                if(key==i)continue;
                double val1 = map.get(i);
                double inv = val - val1;
                if(inv <=0)continue;
                double invKey = Math.sqrt(inv);
                count +=map.containsKey(invKey)?1:0;
            }
        }
        return count;
    }
}
