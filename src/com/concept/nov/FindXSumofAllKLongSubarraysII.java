package com.concept.nov;

import java.util.*;

public class FindXSumofAllKLongSubarraysII {
    private static TreeSet<int[]> mainSet;
    private static TreeSet<int[]> secSet;
    private static long sum;
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6, x = 2;
        long[] res = findXSumI(nums, k, x);
        for (long num : res) {
            System.out.print(num + ", ");
        }
    }

    public static long[] findXSumI(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long[] res = new long[n - k + 1];
        //assending order sorting
        // first compare freq , if both r same then compare ele
        Comparator<int[]> comp = (a,b)->{
            if(a[0] != b[0]) return Long.compare(a[0], b[0]);
            else return Long.compare(a[1], b[1]);
        };
        //arr[0] = freq , arr[1]= element
        mainSet= new TreeSet<>(comp);
        secSet = new TreeSet<>(comp );
        int j = 0;
        int left = 0;
        int right =0;
        while(right<n){
            int num = nums[right];
            if(map.getOrDefault(num, 0)>0)
                removeFromSet(new int[]{map.get(num), num},x);
            map.put(num, map.getOrDefault(num,0)+1);
            insertInSet(new int[]{map.get(num), num},x);
            if(right-left+1 == k){
                res[j++] = sum;
                int outFromNum = nums[left];
                removeFromSet(new int[]{map.get(outFromNum),outFromNum},x);
                map.put(outFromNum, map.getOrDefault(outFromNum,0)-1);
                if(map.get(outFromNum)==0) map.remove(outFromNum);
                else insertInSet(new int[]{map.get(outFromNum), outFromNum},x);
                left++;
            }
            right++;
        }

        return res;
    }

    private static void removeFromSet(int [] arr, int x) {
        if(mainSet.contains(arr)){
            sum -= 1L * arr[0]*arr[1];
            mainSet.remove(arr);
            if(!secSet.isEmpty()){
                int [] largest = secSet.getLast();
                secSet.remove(largest);
                mainSet.add(largest);

                sum += 1L * largest[0] * largest[1];
            }
        }else secSet.remove(arr);
    }

    private static void insertInSet(int[] arr, int x) {
        if(mainSet.size() < x || comparePairs(arr, mainSet.first())>0){
            mainSet.add(arr);
            sum += 1L * arr[0] * arr[1];
            if(mainSet.size() >x){
                int [] smallest = mainSet.first();
                sum -=1L * smallest[0] * smallest[1];
                mainSet.remove(smallest);
                secSet.add(smallest);
            }
        }else secSet.add(arr);
    }

    private static int comparePairs(int[] a, int[] b) {
        if(a[0] != b[0]) return Long.compare(a[0], b[0]);
        else return Long.compare(a[1], b[1]);
    }
}

