package com.july;

public class FindtheMaximumLengthofValidSubsequenceI {
    public static void main(String[] args) {
        int [] nums = {1,3};
        int count = maximumLength(nums);
        System.out.println(count);
    }

    private static int maximumLength(int[] nums) {
        int n = nums.length;
        int oddCount =0;
        int evenCount =0;
        int altPairty =0;
        for(int num:nums){
            if(num % 2 == 0)
                evenCount++;
            else oddCount++;
        }
        //pick alt pairty
        int pairtyFlag = nums[0]%2;
        altPairty +=1;
        for(int i=1;i<n;i++){
            if(nums[i] % 2 !=pairtyFlag){
                altPairty +=1;
                pairtyFlag = nums[i]%2;
            }
        }
        return Math.max(oddCount, Math.max(evenCount, altPairty));
    }
}
