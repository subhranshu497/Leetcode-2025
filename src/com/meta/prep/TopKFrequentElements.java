package com.meta.prep;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k =2;
        int [] res = topKFrequent(nums, k);
        for(int num:res)
            System.out.print(num+", ");
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums)
            map.put(num, map.getOrDefault(num,0)+1);
        //take a maxheap
        Comparator<int[]> maxComparator = (a,b)->b[1]-a[1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,maxComparator);
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            pq.add(new int[]{e.getKey(), e.getValue()});
        }
        System.out.println(pq.size());
        int [] res = new int[k];
        int i=0;
        while(!pq.isEmpty() && i<k){
            int [] arr = pq.poll();
            res[i] = arr[0];
            i++;
        }
        return res;
    }
}
