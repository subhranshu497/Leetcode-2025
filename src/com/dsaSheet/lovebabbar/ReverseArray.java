package com.dsaSheet.lovebabbar;

public class ReverseArray {
    public static void main(String[] args) {
        int [] nums = {1, 4, 3, 2, 6};
        int [] res = reverseArray(nums);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] reverseArray(int[] nums) {
        int n = nums.length;
        int i =0;
        int j = n-1;
        while(i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}
