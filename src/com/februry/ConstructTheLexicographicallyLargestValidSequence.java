package com.februry;

import java.util.Arrays;

public class ConstructTheLexicographicallyLargestValidSequence {
    public static void main(String[] args) {
        int n =3;
        int [] result = constructDistancedSequence(n);
        for(int num:result)
            System.out.print(num+", ");
    }

    private static int[] constructDistancedSequence(int n) {
        int[] result = new int[(2*n)-1];
        Arrays.fill(result,-1);
        boolean[] visited = new boolean[n+1];
        boolean flag = constructDistancedSequenceBacktracking(0, result, visited,n);
        return result;
    }

    private static boolean constructDistancedSequenceBacktracking(int i, int[] result, boolean[] visited, int n) {
        // Base condition: If all positions are filled, return true
        if (i >= result.length) {
            return true;
        }

        // If the current position is already filled, move to the next position
        if (result[i] != -1) {
            return constructDistancedSequenceBacktracking(i + 1, result, visited, n);
        }

        // Try placing numbers from n to 1 (to ensure lexicographically largest sequence)
        for (int idx = n; idx >= 1; idx--) {
            if (visited[idx]) {
                continue; // Skip if the number is already used
            }

            // Check if the number can be placed at the current position
            if (idx == 1) {
                // Place 1 at the current position
                result[i] = idx;
                visited[idx] = true;

                // Recur for the next position
                if (constructDistancedSequenceBacktracking(i + 1, result, visited, n)) {
                    return true;
                }

                // Backtrack
                result[i] = -1;
                visited[idx] = false;
            } else {
                // For numbers greater than 1, check if the second position is available
                int secondPos = i + idx;
                if (secondPos < result.length && result[secondPos] == -1) {
                    // Place the number at the current position and the second position
                    result[i] = idx;
                    result[secondPos] = idx;
                    visited[idx] = true;

                    // Recur for the next position
                    if (constructDistancedSequenceBacktracking(i + 1, result, visited, n)) {
                        return true;
                    }

                    // Backtrack
                    result[i] = -1;
                    result[secondPos] = -1;
                    visited[idx] = false;
                }
            }
        }

        // If no number can be placed at the current position, return false
        return false;
    }
}
