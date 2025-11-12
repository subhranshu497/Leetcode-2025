package com.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumNumberofOperationstoMakeAllArrayElementsEqualto1 {
    public static void main(String[] args) {
        int [] nums = {935839,59074,1,1,1,539890,135036,248163,519664,794201,915143,353146,764742,1,1,1,33204,661690,1,1,414294,1,778895,1,1,357151,1,645007,707404,599671,1,120017,220478,69724,1,1,1,604942,543935,1,1};
        int ops = minOperationsII(nums);
        System.out.println(ops);
    }

    private static int minOperationsII(int[] nums) {
        int n = nums.length;
        int ops =0;
        int i=0;
        int countOnes = 0;
        for(int num:nums){
            if(num==1){
                i++;
                countOnes++;
            }
        }
        if(i==n) return 0;
        else if(countOnes !=0){
            return n-countOnes;
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while(list.size() !=1){
            boolean flag = false;
            List<Integer> gcdList = new ArrayList<>();
            for(int j=0;j<list.size()-1;j++){
                int gcd = calculateGcd(list.get(j), list.get(j+1));
                gcdList.add(gcd);
                if(gcd==1){
                    flag = true;
                    break;
                }
            }
            list = gcdList;
            ops +=1;
            if(flag){
                ops +=n-1;
                break;
            }
        }
        if(list.size()==1 && list.get(0) != 1)return -1;
        return ops;
    }

    private static int calculateGcd(int a, int b) {
        if(b==0)return a;
        return calculateGcd(b,a%b);
    }
}
