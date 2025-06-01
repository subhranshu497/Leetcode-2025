package com.june;

public class DistributeCandiesAmongChildrenII {
    public static void main(String[] args) {
        int n = 5 ,limit = 2;
        long ways = distributeCandies(n,limit);
        System.out.println(ways);
    }

    private static long distributeCandies(int n, int limit) {
        long ways = 0;
        //calculate the min and max for child 1
        //child 1 will have min candies when ch2 and ch3 would get max candies , which is limit
        //n = 3 , l =3, so in this case max (0, n - 2*limit)
        int minch1 = Math.max(0, n - (2*limit));
        int maxCh1 = Math.min(n, limit);
        //calculate for ch2 and ch3
        for(int i=minch1;i<=maxCh1;i++){
            int remainingCandies = n-i;
            int minCh2 = Math.max(0, remainingCandies-limit); // max is required to avoid negative int
            int maxCh2 = Math.min(remainingCandies, limit);

            ways +=maxCh2-minCh2+1;
        }
        return ways;
    }
}
