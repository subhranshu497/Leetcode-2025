package com.march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels(s);
        System.out.println(res);
    }

    private static List<Integer> partitionLabels(String s) {
        Map<Character,Integer> pos = new HashMap<>();
        for(int i=0;i<s.length();i++){
            pos.put(s.charAt(i), i);
        }
        System.out.println(pos);
        List<Integer> res = new ArrayList<>();
        int i=0;
        while(i <s.length()){
            char ch = s.charAt(i);
            int end = pos.get(ch); //8
            int j = i;
            while(j <end && j < s.length()){
                end = Math.max(end, pos.get(s.charAt(j)));
                j++;
            }
            int val = j-i+1;
            res.add(val);
            i = j+1;
        }

        return res;
    }
}
