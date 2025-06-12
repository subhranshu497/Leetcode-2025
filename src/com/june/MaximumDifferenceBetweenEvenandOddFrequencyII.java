package com.june;

import java.util.Arrays;

public class MaximumDifferenceBetweenEvenandOddFrequencyII {
    public static void main(String[] args) {
        String s = "12233";
        int k = 4;
        int res = maxDifferenceII(s, k);
        System.out.println(res);
    }
    public static int getState(int count_a, int count_b) {
        int parity_a = count_a % 2; // odd: parity will be 1, even: parity will be 0
        int parity_b = count_b % 2;

        if (parity_a == 0 && parity_b == 0) return 0; // even even (00)
        if (parity_a == 0 && parity_b == 1) return 1; // even odd (01)
        if (parity_a == 1 && parity_b == 0) return 2; // odd even (10)

        return 3; // odd odd (11)
    }

    /**
     * Calculates the maximum difference between counts of character 'a' and 'b'
     * within subarrays meeting certain conditions.
     */
    public static int maxDifferenceII(String s, int k) {
        int n = s.length();

        int result = Integer.MIN_VALUE; // Equivalent to INT_MIN in C++

        // Step-1 Try all possible pairs a and b from ('0' to '4') where a != b
        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) {
                    continue;
                }

                // stateMinPrev_a_b[state] = stores the smallest value of count of a - count of b
                // Initialize with Integer.MAX_VALUE
                int[] stateMinPrev_a_b = new int[4];
                Arrays.fill(stateMinPrev_a_b, Integer.MAX_VALUE);

                // Count of a and count of b till index r
                int count_a = 0;
                int count_b = 0;

                // Count of a and count of b till prev index l (before l is incremented)
                int prev_a = 0;
                int prev_b = 0;

                // Let's start the sliding window
                int l = -1; // Represents the index *before* the start of the current window segment
                int r = 0;

                while (r < n) {
                    count_a += (s.charAt(r) == a) ? 1 : 0;
                    count_b += (s.charAt(r) == b) ? 1 : 0;

                    // Now try to shrink from l (expand the left boundary of the "left" subarray)
                    // The condition r - l >= k implies the current window (from l+1 to r) has length at least k
                    // The conditions `count_b - prev_b >= 2 && count_a - prev_a >= 1`
                    // refer to the counts within the *current* window from (l+1) to r.
                    // This implies the window is being checked for validity before shrinking.
                    // If the left window is valid, store its difference.
                    while (r - l >= k && (count_b - prev_b) >= 2 && (count_a - prev_a) >= 1) {
                        int leftState = getState(prev_a, prev_b);
                        stateMinPrev_a_b[leftState] = Math.min(stateMinPrev_a_b[leftState], prev_a - prev_b);

                        l++; // Move the left pointer
                        // Update prev_a and prev_b to reflect the counts *after* l has moved
                        // and effectively includes s[l] in the "previous" part.
                        prev_a += (s.charAt(l) == a) ? 1 : 0;
                        prev_b += (s.charAt(l) == b) ? 1 : 0;
                    }

                    int rightState = getState(count_a, count_b);
                    // The bestLeftState is calculated by XORing with 2.
                    // This effectively flips the parity of `parity_a` while keeping `parity_b` the same.
                    // If rightState is (pa, pb), bestLeftState is (pa ^ 1, pb).
                    // This seems to be a specific logic for the problem's requirements about parity.
                    int bestLeftState = rightState ^ 2; // Equivalent to rightState ^ 0b10

                    int bestMinDiffValueLeft = stateMinPrev_a_b[bestLeftState];

                    if (bestMinDiffValueLeft != Integer.MAX_VALUE) {
                        result = Math.max(result, (count_a - count_b) - bestMinDiffValueLeft);
                    }

                    r++; // Move the right pointer
                }
            }
        }
        return result;
    }
}
