package com.april;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RabbitsInForest {
    public static void main(String[] args) {
        int[] answers = {1,0,1,0,0};
        int rabbits = numRabbits(answers);
        System.out.println(rabbits);
    }

    private static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : answers) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();

            int groupSize = x + 1;
            int groups = (int) Math.ceil((double) count / groupSize);

            total += groups * groupSize;
        }
        return total;
    }
}
