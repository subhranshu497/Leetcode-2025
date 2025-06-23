package com.dsaSheet.lovebabbar;

public class MinimumJumps {
    public static void main(String[] args) {
        int [] arr = {1, 4, 3, 2, 6, 7};
        int jumps = minJumps(arr);
        System.out.println(jumps);
    }

    private static int minJumps(int[] arr) {
        if(arr[0]==0) return -1;
        int totalJump = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int jumps = sloveJump(arr, arr[i],1);
            totalJump = Math.min(jumps, totalJump);
        }
return totalJump;
    }

    private static int sloveJump(int[] arr, int steps, int i) {


        return 0;
    }
}
