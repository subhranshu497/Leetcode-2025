package com.april;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        int [] nums = {12,345,2,6,7896};
        int count = findNumbers(nums);
        System.out.println(count);
    }

    private static int findNumbers(int[] nums) {
        int count =0;
        for(int num:nums){
            String s = String.valueOf(num);
            count+= s.length()%2==0?1:0;
        }
        return count;
    }
}
