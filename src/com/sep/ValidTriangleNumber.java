package com.sep;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 4};
        int count = triangleNumber(nums);
        System.out.println(count);
    }

    private static int triangleNumber(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return 0;
            }
            Arrays.sort(nums);

            int count = 0;
            for (int i = n - 1; i >= 2; i--) {
                int left = 0;
                int right = i - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > nums[i]) {
                        count += (right - left);
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return count;
        }
}
