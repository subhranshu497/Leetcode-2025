package com.august;

public class New21Game {
    public static void main(String[] args) {
        int n = 21, k = 17, maxPts = 10;
        double res = new21Game(n, k, maxPts);
        System.out.println(res);
    }

    private static double new21Game(int n, int k, int maxPts) {
        double [] probabilities = new double[n+1];
        probabilities[0] =1;
        double probSum =k>0?1.0:0.0;
        for(int i=1;i<=n;i++){
            probabilities[i] = probSum/maxPts;
            if(i<k){
                probSum +=probabilities[i];
            }
            if((i-maxPts)>=0 && (i-maxPts)<k){
                probSum -=probabilities[i-maxPts];
            }
        }
        //to get result
        double result =0.0;
        for (int i = k; i <= n; i++) {
            result += probabilities[i];
        }
        return result;
    }

    //brute force - TLE
    private static double new21GameBruteForce(int n, int k, int maxPts) {
        double [] probabilities = new double[n+1];
        probabilities[0] =1;
        double res =0.0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxPts;j++){
                //prob of card = 1/maxpts
                //reming prob = p[i-j]
                if((i-j)>=0 && (i-j)<k){
                    probabilities[i] +=probabilities[i-j]/maxPts;
                }
            }
        }
        //to get result
        for(int i=k;i<=n;i++){
            res +=probabilities[i];
        }
        return res;
    }
}
