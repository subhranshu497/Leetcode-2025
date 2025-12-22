package com.string;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {
    public static void main(String[] args) {
        int [] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> res = kidsWithCandies(candies, extraCandies);
        System.out.println(res);
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int candy: candies){
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> res = new ArrayList<>();
        for(int candy:candies){
            if(candy+extraCandies >= maxCandies)
                res.add(true);
            else res.add(false);
        }
        return res;
    }
}
