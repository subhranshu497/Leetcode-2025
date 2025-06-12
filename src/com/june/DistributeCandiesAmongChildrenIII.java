package com.june;

public class DistributeCandiesAmongChildrenIII {
    public static void main(String[] args) {
        int n = 3, limit =3;
        long ways = distributeCandiesIII(n, limit);
        System.out.println(ways);
    }

    private static long distributeCandiesIII(int n, int limit) {
        if(n > (3*limit)) return 0;
        long ways = 0;
        //first calculate min and max number of candies for child 1
        int maxCh1 = Math.min(n,limit); // because sometime n is less but limit could be greater value
        //when we will assign max candies to ch2 and ch3 , then remaining candies will be min for child 1
        int minCh1 = Math.max(n-(2*limit),0);
        //now calculate the min and max for other child
        //when we will get the upper and lower bounds then total number = max-min+1
        //e.g there are 10 numbers from 1 to 10. how will we calculate it
        // max =10 , min =1 , total number of numners are = 10-1+1=10

        for(int i=minCh1;i<=maxCh1;i++){
            // calculate the remaining candies after ch1
            int N = n-i;
            int maxCh2 = Math.min(N,limit);
            int minCh2 = Math.max(0, N-limit);

            ways +=maxCh2-minCh2+1;
        }
        return ways;
    }
}
