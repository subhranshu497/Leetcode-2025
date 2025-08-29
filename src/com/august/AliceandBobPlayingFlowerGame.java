package com.august;

public class AliceandBobPlayingFlowerGame {
    public static void main(String[] args) {
        int n=1;
        int m=1;
        long res = flowerGame(n,m);
        System.out.println(res);
    }

    private static long flowerGame(int n, int m) {
        if(m==1 && n==1) return 0;
        long count1 = Math.ceilDiv(m,2);
        long count2 = Math.floorDiv(n,2);
        long count3 = Math.ceilDiv(n,2);
        long count4 = Math.floorDiv(m,2);

        return (count1*count2)+(count3*count4);
    }
}
