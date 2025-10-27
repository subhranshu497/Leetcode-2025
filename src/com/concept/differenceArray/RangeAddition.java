package com.concept.differenceArray;

public class RangeAddition {
    public static void main(String[] args) {
        int [][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int length = 5;
        int [] res = getModifiedArray(updates, length);
        for(int r:res)
            System.out.println(r+", ");
    }

    private static int[] getModifiedArray(int[][] updates, int length) {
        int [] res = new int[length];
        //solve using diff array technique
        //take the update item,
        //add the value in the left index of res
        //then subtract the value from the right+1 index of res
        //at the end take the cumulative sum of the array
        for(int [] update:updates){
            int left = update[0];
            int right = update[1];
            int val = update[2];
            res[left] +=val;
            if(right+1 < length)
                res[right+1] -=val;
        }
        //take cumsum
        for(int i=1;i<length;i++){
            res[i] +=res[i-1];
        }
        return res;
    }
}
