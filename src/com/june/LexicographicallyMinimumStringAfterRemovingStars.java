package com.june;

import java.util.*;

public class LexicographicallyMinimumStringAfterRemovingStars {
    public static void main(String[] args) {
        String s = "abc";
        String res = clearStars(s);
        System.out.println(res);
    }

    private static String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        char [] arr = new char[n];
        int i=0;
        while(i<n){
            if(s.charAt(i) !='*'){
                pq.add(s.charAt(i));
                map.computeIfAbsent(s.charAt(i), k-> new LinkedList<>()).add(i);
                arr[i] = s.charAt(i);
            }else{
                char top = pq.poll();
                LinkedList<Integer> set = map.get(top);
                map.remove(top);
                int index = set.get(set.size()-1);
                //find the index
                arr[i] = '\0';
                arr[index]= '\0';
                set.remove(set.size()-1);
                if(!set.isEmpty())
                    map.put(top, set);
            }
            i++;
        }
        StringBuilder res = new StringBuilder();
        for(char ch:arr){
            if(ch !='\0')
                res.append(ch);
        }
        return res.toString();
    }
}
