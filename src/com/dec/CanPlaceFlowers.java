package com.dec;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int [] flowerBed = {1,0,1,0,1,0,1};
        int n =1;
        boolean flag = canPlaceFlowers(flowerBed,n);
        System.out.println(flag);
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i =1;
        while(i<flowerbed.length-1 && n>0){
            if(i-1 ==0){
                if(flowerbed[i-1]==0 && flowerbed[i]==0){
                    n--;
                    flowerbed[i-1]=1;
                }
            }else if(flowerbed[i] ==0){
                if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    n--;
                    flowerbed[i] =1;
                }
            }
            i++;
        }
        return n==0;
    }
}
