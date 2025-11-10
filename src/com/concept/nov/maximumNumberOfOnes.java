package com.concept.nov;

import java.util.PriorityQueue;

public class maximumNumberOfOnes {
    public static void main(String[] args) {
        int width = 3, height = 3, sideLength = 2, maxOnes = 1;
        int count = maximumNumberOfOnes(width, height, sideLength, maxOnes);
        System.out.println(count);
    }
    public static int maximumNumberOfOnes(int width, int height, int sidelength, int maxOnes) {
        int[][] side = new int[sidelength][sidelength];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                side[i % sidelength][j % sidelength]++;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < sidelength; i++) {
            for (int j = 0; j < sidelength; j++) {
                pq.add(side[i][j]);
            }
        }
        int total = 0;
        for (int i = 0; i < maxOnes; i++) {
            total += pq.poll();
        }

        return total;
    }
}
