package com.oct;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakingMaximumEnergyFromtheMysticDungeon {
    public static void main(String[] args) {
        int [] energy = {5,2,-10,-5,1};
        int k = 3;
        int ene = maximumEnergy(energy, k);
        System.out.println(ene);
    }

    private static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans =Integer.MIN_VALUE;
        int [] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=energy[i]+((i+k)<n?dp[i+k]:0);
            ans = Math.max(dp[i], ans);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
