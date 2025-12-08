package com.dec;

public class CountPartitionswithEvenSumDifference {
    public static void main(String[] args) {
        int [] nums = {10,10,3,7,6};
        int res = countPartitions(nums);
        System.out.println(res);
    }

    private static int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i] % 2==0 && (sum-nums[i]) % 2 == 0){
                res +=1;
            }
            else if(nums[i] % 2 !=0){
                if((sum-nums[i]) % 2 == 0)continue;
                else res +=1;
            }
            sum -=nums[i];
        }
        return res;
    }
}
