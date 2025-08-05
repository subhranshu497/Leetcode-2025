package com.august;

public class FruitsIntoBasketsII {
    public static void main(String[] args) {
        int [] fruits = {3,6,1};
        int [] baskets = {6,4,7};
        int unmatched = numOfUnplacedFruits(fruits, baskets);
        System.out.println(unmatched);
    }

    private static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        boolean [] used = new boolean[n];
        //i - fruit
        //j - basket
        int i=0;
        while(i<n){
            boolean placed = false;
            int j =0;
            while (j<n){
                if(!used[j] && fruits[i]<=baskets[j]){
                    used[j] =true;
                    placed = true;
                    break;
                }
                j++;
            }
            if(!placed) count++;
            i++;
        }
        return count;
    }
}
