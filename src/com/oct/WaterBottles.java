package com.oct;

public class WaterBottles {
    public static void main(String[] args) {
        int numBottles = 6, numExchange = 5;
        int res = numWaterBottles(numBottles, numExchange);
        System.out.println(res);
    }

    private static int numWaterBottles(int numBottles, int numExchange) {
        int bottles = 0;
        while(numBottles >= numExchange){
            bottles +=numExchange;
            numBottles -=numExchange;

            numBottles++;
        }
        return bottles+numBottles;
    }
}
