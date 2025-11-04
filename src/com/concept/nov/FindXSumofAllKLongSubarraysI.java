package com.concept.nov;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindXSumofAllKLongSubarraysI {
    public static void main(String[] args) {
        int [] nums = {1,1,2,2,3,4,2,3};
        int k = 6, x = 2;
        int [] res = findXSum(nums, k, x);
        for(int num:res){
            System.out.print(num+", ");
        }
    }

    private static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int [] res = new int[n-k+1];
        int windowSize =0;
        int j =0;
        int left =0;
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            windowSize++;
            if(i-left+1 >=k){
                PriorityQueue<int[]> pq = new PriorityQueue<>(new customComaparator());
                for(Map.Entry<Integer, Integer> e:map.entrySet()){
                    pq.offer(new int []{e.getKey(), e.getValue()});
                }
                int count =x;
                int sum = 0;
                while(count>0 && !pq.isEmpty()){
                    int [] arr = pq.poll();
                    sum +=arr[0]*arr[1];
                    count--;
                }
                res[j++] = sum;
                map.put(nums[left], map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
        }
        return res;
    }
}
class customComaparator implements Comparator<int[]>{

    @Override
    public int compare(int[] a, int[] b) {
        if(a[1] !=b[1]) return Integer.compare(b[1], a[1]);
        else return Integer.compare(b[0], a[0]);
    }
}
