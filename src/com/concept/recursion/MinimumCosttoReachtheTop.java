package com.concept.recursion;

import java.util.Arrays;

public class MinimumCosttoReachtheTop {
    public static void main(String[] args) {
        int [] costs = {10, 15, 20};
        int min = minCost(costs);
        System.out.println(min);
    }

    private static int minCost(int[] costs) {
        int n = costs.length;
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int mincost = Math.min(minCostRecursion(costs, n,0, memo),minCostRecursion(costs, n,1, memo));
        return mincost;
    }

    private static int minCostRecursion(int[] costs, int n, int i, int [] memo) {
        //either i can walk 1 step or 2 steps
        //base condition
        if(i>=n){
            return 0;
        }
        if(memo[i] != -1) return memo[i];
        //walk one step
        return memo[i]= costs[i]+Math.min(minCostRecursion(costs,n,i+1, memo),minCostRecursion(costs,n,i+2, memo));

    }
}
