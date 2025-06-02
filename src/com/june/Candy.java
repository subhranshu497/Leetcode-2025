package com.june;

import java.util.Arrays;
import java.util.Map;

public class Candy {
    public static void main(String[] args) {
        int [] ratings = {1,2,87,87,87,2,1};
        int totalCandies = candy(ratings);
        System.out.println(totalCandies);
    }

    private static int candy(int[] ratings) {
        int n = ratings.length;
        int [] leftToRight = new int[n];
        Arrays.fill(leftToRight,1);
        int [] rightToLeft = new int[n];
        Arrays.fill(rightToLeft, 1);
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1])
                leftToRight[i] = leftToRight[i-1]+1;
        }
        System.out.println("Left to Right");
        for(int num:leftToRight)
            System.out.print(num+", ");
        System.out.println();
        System.out.println("Right to Left");
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                rightToLeft[i] = rightToLeft[i+1]+1;
        }
        //print
        for(int num:rightToLeft)
            System.out.print(num+", ");
        //calculate the total candies
        int [] candies = new int[n];
        int totalCandies =0;
        for(int i=0;i<n;i++){
            candies[i] = Math.max(leftToRight[i], rightToLeft[i]);
        }
        for(int i=0;i<n;i++){
            totalCandies +=candies[i];
        }
        return totalCandies;
    }
}
