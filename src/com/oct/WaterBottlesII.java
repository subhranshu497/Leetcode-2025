package com.oct;

public class WaterBottlesII {
    public static void main(String[] args) {
        int numBottles = 13, numExchange = 6;
        int res = maxBottlesDrunk(numBottles, numExchange);
        System.out.println(res);
    }

    private static int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles >= numExchange){
            numBottles -=numExchange;
            numBottles +=1;
            numExchange +=1;
            res +=1;
        }
        return res;
    }
}
