package com.april;

import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        int [][] questions = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        long res = mostPoints(questions);
        System.out.println(res);
    }

    private static long mostPoints1(int[][] questions) {
        int n = questions.length;
        long [] memo = new long[n+1];
        Arrays.fill(memo, -1);
        return mostPointMemo(questions, n, 0, memo);
    }

    private static long mostPointMemo(int[][] questions, int n, int i, long [] memo) {
        //base condition
        if(i >=n) return 0;
        if(memo[i] !=-1) return memo[i];

        long take = questions[i][0]+mostPointMemo(questions,n, i+questions[i][1]+1, memo);
        long skip = mostPointMemo(questions, n, i+1, memo);

        return memo[i] = Math.max(take, skip);
    }
    //bottom up approach
    //traverse from right to left
    private static long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[100001];
        for(int i=n-1;i>=0;i--){
            long take = questions[i][0]+dp[i+questions[i][1]+1];
            long skip = dp[i+1];
            dp[i] = Math.max(take, skip);
        }
        return dp[0];
    }
}
