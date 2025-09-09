package com.sep;

import java.util.Arrays;

public class NumberofPeopleAwareofaSecret {
    private static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        int n = 6, delay = 2, forget = 4;
        int people = peopleAwareOfSecret(n,delay, forget);
        System.out.println(people);
    }

    private static int peopleAwareOfSecret(int n, int delay, int forget) {
        int [] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int total = 0;
        // only count people who still remember on day n
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                total = (total + solve(day, delay, forget, memo)) % MOD;
            }
        }

        return total;
    }
    private static int solve(int day, int delay, int forget, int [] memo) {
        if (day == 1) return 1;
        if (day <= 0) return 0;

        if (memo[day] != -1) return memo[day];

        long result = 0;
        // people who can share today are those who learned in [day - forget + 1, day - delay]
        for (int prev = day - forget + 1; prev <= day - delay; prev++) {
            if (prev > 0) {
                result = (result + solve(prev, delay, forget, memo)) % MOD;
            }
        }

        return memo[day] = (int) result;
    }
}
