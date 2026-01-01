package com.oct;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class TakingMaximumEnergyFromtheMysticDungeon {
    public static void main(String[] args) {
        int [] energy = {5,2,-10,-5,1};
        int k = 3;
        int ene = maximumEnergyRecursion(energy, k);
        System.out.println(ene);
    }

    private static int maximumEnergyRecursion(int[] energy, int k) {
        int maxEnergy = Integer.MIN_VALUE;
        int [] t = new int[energy.length];
        Arrays.fill(t, -1);
        for(int i=0;i<energy.length;i++){
            maxEnergy = Math.max(maxEnergy, energy[i]+solveRecursion(energy, i+k,k,t));
        }
        return maxEnergy;
    }

    private static int solveRecursion(int[] energy, int i, int k, int [] t) {
        //base condition
        if(i>=energy.length) return 0;
        if(t[i] !=-1)return t[i];
        int ene = energy[i]+solveRecursion(energy, i+k, k, t);
        return t[i]=ene;
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
