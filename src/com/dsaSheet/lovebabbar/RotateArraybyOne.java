package com.dsaSheet.lovebabbar;

public class RotateArraybyOne {
    public static void main(String[] args) {
        int [] arr = {9, 8, 7, 6, 4, 2, 1, 3};
        rotateI(arr);
    }

    private static void rotateI(int[] arr) {
        int n = arr.length;
        int temp = -1;
        int temp1 = -1;
        for(int i=0;i<n;i++){
            if(i ==0){
                temp = arr[i];
                arr[i] = arr[n-1];
            }else {
                temp1 = arr[i];
                arr[i] = temp;
                temp = temp1;
            }
        }
        for(int a:arr){
            System.out.print(a+", ");
        }
    }
}
