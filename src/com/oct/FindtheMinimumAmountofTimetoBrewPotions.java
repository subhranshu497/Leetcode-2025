package com.oct;

public class FindtheMinimumAmountofTimetoBrewPotions {
    public static void main(String[] args) {
        int [] skill = {1,5,2,4};
        int []mana = {5,1,4,2};
        long ans = minTime1(skill, mana);
        System.out.println(ans);
    }

    private static long minTime1(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long [] finishTime = new long[n];

        for (int j = 0; j < m; ++j) {
            finishTime[0] += (long) mana[j] * skill[0];

            for (int i = 1; i < n; ++i) {
                finishTime[i] = Math.max(finishTime[i], finishTime[i - 1]) + (long) mana[j] * skill[i];
            }

            for (int i = n - 1; i > 0; --i) {
                finishTime[i - 1] = finishTime[i] - (long) mana[j] * skill[i];
            }
        }
        return finishTime[n - 1];
    }
}
