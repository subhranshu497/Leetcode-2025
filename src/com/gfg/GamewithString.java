package com.gfg;

import java.util.*;
import java.util.stream.Collectors;

public class GamewithString {
    public static void main(String[] args) {
        String s = "ccbcbd";
        int k = 3;
        int min = minValueI(s,k);
        System.out.println(min);
    }

    private static int minValueI(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        // get all the values
        List<Integer> valueList = map.values()
                        .stream()
                                .sorted(Collections.reverseOrder())
                                        .collect(Collectors.toList());

        System.out.println(valueList);
        int sum =0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(valueList);
        //poll from maxHeap iterate and add back in
        while(k>0 && !maxHeap.isEmpty()){
            int curr = maxHeap.poll();
            curr--;
            k--;
            maxHeap.add(curr);
        }
        System.out.println(maxHeap);
        //poll from pq and calculate sum
        while(!maxHeap.isEmpty()){
            sum +=Math.pow(maxHeap.poll(), 2);
        }
        return sum;
    }
}
