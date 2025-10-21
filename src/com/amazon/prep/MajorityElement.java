package com.amazon.prep;

public class MajorityElement {
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        int major = majorityElement(nums);
        System.out.println(major);
    }

    private static int majorityElement(int[] nums) {
        int majority = nums[0], count =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majority)
                count++;
            else {
                count--;
                if(count==0){
                    majority = nums[i];
                    count =1;
                }
            }
        }
        return majority;
    }
}
