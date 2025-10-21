package com.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinPath {
    public static void main(String[] args) {
        int [] coins = {1,2,4,-1,2};
        int maxJump =2;
        List<Integer> res = cheapestJump(coins, maxJump);
        System.out.println(res);
    }

    private static List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        int[] dp = new int[n];
        List<Integer>[] paths = new List[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        if (coins[0] == -1 || coins[n - 1] == -1) return new ArrayList<>();

        dp[0] = coins[0];
        paths[0] = new ArrayList<>();
        paths[0].add(1); // 1-based indexing

        for (int i = 0; i < n; i++) {
            if (coins[i] == -1 || dp[i] == Integer.MAX_VALUE) continue;

            for (int j = i + 1; j <= i + maxJump && j < n; j++) {
                if (coins[j] == -1) continue;

                int cost = dp[i] + coins[j];
                if (cost < dp[j]) {
                    dp[j] = cost;
                    paths[j] = new ArrayList<>(paths[i]);
                    paths[j].add(j + 1); // 1-based indexing
                } else if (cost == dp[j]) {
                    List<Integer> newPath = new ArrayList<>(paths[i]);
                    newPath.add(j + 1);
                    if (compare(newPath, paths[j]) < 0) {
                        paths[j] = newPath;
                    }
                }
            }
        }

        return paths[n - 1] == null ? new ArrayList<>() : paths[n - 1];
    }
    private static int compare(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) - b.get(i);
            }
        }
        return a.size() - b.size();
    }
}
