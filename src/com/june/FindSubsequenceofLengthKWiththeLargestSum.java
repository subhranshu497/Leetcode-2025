package com.june;

import com.sun.source.tree.UsesTree;

import java.util.*;

public class FindSubsequenceofLengthKWiththeLargestSum {
    public static void main(String[] args) {
        int [] nums = {50,-75};
        int k = 2;
        int [] arr =maxSubsequence(nums, k);
        for(int a:arr)
            System.out.print(a+", ");
    }

    private static int[] maxSubsequence(int[] nums, int k) {
        //int [] - of size 2 where oth index is value and first index is indices
        //minheap based on the value
        PriorityQueue<int[]> maxHeap =new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int [] res = new int[k];

        for(int i=0;i<nums.length;i++){
            maxHeap.offer(new int[]{nums[i],i});
        }
        System.out.println(maxHeap.size());
//poll from max heap
        int [][] arr = new int[k][2];
        int j =0;
        while(k>0){
            int [] a = maxHeap.poll();
            arr[j] = a;
            j++;
            k--;
        }
        // now sort the arr based on the second value
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        for(int i=0;i<2;i++){
            System.out.println(arr[i][0]+", "+arr[i][1]);
        }
        int l=0;
        for(int[] numArr:arr){
            res[l]=numArr[0];
            l++;
        }
        return res;
    }

    // brute force - TLE

//    private static int[] maxSubsequence(int[] nums, int k) {
//        //generate all the sebsequences of length k
//        Set<List<Integer>> subseq = new HashSet<>();
//        generatesubseq(nums, k,subseq, new ArrayList<>(), 0);
//        System.out.println(subseq);
//        //calculate sum
//        int sum =Integer.MIN_VALUE;
//        List<Integer> resList = new ArrayList<>();
//        for(List<Integer> l:subseq){
//            int tempSum =0;
//            for(int num:l){
//                tempSum +=num;
//            }
//            if(tempSum>sum){
//                resList =l;
//                sum = tempSum;
//            }
//        }
//        int [] res = new int[k];
//        int j=0;
//        for(int i:resList){
//            res[j]=i;
//            j++;
//        }
//
//
//        return res;
//    }

    private static void generatesubseq(int[] nums, int k, Set<List<Integer>> subseq, List<Integer> list, int i) {
        //base condition
        if(list.size()==k){
            subseq.add(new ArrayList<>(list));
            return;
        }
        if(i>= nums.length) return;
        //do the operation
        list.add(nums[i]);
        generatesubseq(nums,k,subseq,list,i+1);
        //backtrack
        list.remove(list.size()-1);
        generatesubseq(nums,k,subseq,list,i+1);
    }
}
