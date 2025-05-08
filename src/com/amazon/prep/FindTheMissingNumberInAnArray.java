package com.amazon.prep;

public class FindTheMissingNumberInAnArray {
    public static void main(String[] args) {
        int [] arr = {3,7,1,2,8,4,5};
        int missingNum = missingNumber(arr);
        System.out.println(missingNum);
    }

    private static int missingNumber(int[] arr) {
        int n = arr.length;
        int missing = -1;
        boolean [] visited = new boolean[n+1];
        for(int num:arr){
            visited[num-1]= true;
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                missing = i+1;
                break;
            }
        }
        return missing;
    }
}
