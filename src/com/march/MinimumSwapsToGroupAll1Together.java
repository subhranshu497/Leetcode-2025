package com.march;

public class MinimumSwapsToGroupAll1Together {
    public static void main(String[] args) {
        int [] data = {1,0,1,0,1,0,0,1,1,0,1}; //6 , ans =3
        int res = minSwaps(data);
        System.out.println(res);
    }

    private static int minSwaps(int[] data) {
        int totalOnes = 0;
        for(int num:data)
            totalOnes +=num;
        int right = 0;
        int left =0;
        int n = data.length;
        int maxOnesInWin = 0;
        int currOnesInWin =0;
        while (right<n){
            if(right < totalOnes){
                currOnesInWin += data[right];
            }
            else{
                int currDataOutFromWin = data[left];
                currOnesInWin -=currDataOutFromWin;
                currOnesInWin +=data[right];
                left++;
            }
            maxOnesInWin = Math.max(maxOnesInWin, currOnesInWin);
            right++;
        }
        return totalOnes-maxOnesInWin;
    }
}
