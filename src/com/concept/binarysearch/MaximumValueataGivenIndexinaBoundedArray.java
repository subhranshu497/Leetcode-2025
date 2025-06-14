package com.concept.binarysearch;

public class MaximumValueataGivenIndexinaBoundedArray {
    public static void main(String[] args) {
        int n = 8;
        int index =7;
        int maxSum =14;
        int result = maxValueI(n,maxSum,index);
        System.out.println(result);
    }
    //brute force
    private static int maxValueI(int n, int maxSum, int index) {
        //construct an array of n
        // start placing val = maxsum
        //calculate maxsum , if it is > maxsum
        //keep on decreasing the the val by 1
        int [] arr = new int[n];
        int temp =maxSum;
        int res = 0;
        int sum = maxSum+1;
        while(sum >maxSum){
            formTheArray(n,index, arr,temp);
            int leftSum = calculateSumI(arr,0,index);
            int rightSum = calculateSumI(arr,index+1,n);
            sum = leftSum+arr[index]+rightSum;
            res = temp;
            temp -=1;
        }
        return res;
    }

    private static void formTheArray(int n, int index, int[] arr, int maxSum) {
        int i =0;
        arr[index] = maxSum;
        int diff = index;
        int j = 1;
        while(i<n && j<n){
            if(i <index){
                arr[i]=maxSum -diff+i;
            }
            else if(i>index) {
                arr[i] = maxSum-j;
                j++;
            }
            arr[i] = arr[i]<1?1:arr[i];
            i++;
        }
    }

    private static int calculateSumI(int[] arr, int start, int end) {

        int sum =0;
        for(int i=start;i<end;i++){
            sum +=arr[i];
        }
        return sum;
    }
}
