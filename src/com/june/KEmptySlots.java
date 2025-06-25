package com.june;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class KEmptySlots {
    public static void main(String[] args) {
        int [] bulbs = {1,3,2};
        int k = 1;
        int day = kEmptySlots(bulbs, k);
        System.out.println(day);
    }

    private static int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> onset = new TreeSet<>();
        int day =1;

        for(int bulb:bulbs){
            onset.add(bulb);
            Integer lowerBound = onset.lower(bulb);
            Integer higherBound = onset.higher(bulb);

            if(lowerBound !=null && bulb-lowerBound-1==k) return day;
            else if (higherBound !=null && higherBound-bulb-1==k) return day;
            day++;
        }
        return -1;
    }
}
