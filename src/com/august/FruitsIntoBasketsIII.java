package com.august;

import java.util.concurrent.RunnableScheduledFuture;

public class FruitsIntoBasketsIII {
    public static void main(String[] args) {
        int [] fruits = {4,2,5};
        int [] basket = {3,5,4};
        int unplaced = numOfUnplacedFruitsIII(fruits, basket);
        System.out.println(unplaced);
    }

    private static int numOfUnplacedFruitsIII(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unplacedCount =0;
        int [] segmentTree = new int[4*n];
        //build the segment tree
        buildSegmentTree(0,0,n-1, baskets, segmentTree);
        //query segment tree
        for(int fruit:fruits){
            if(!querySegmentTree(0,0,n-1, baskets, segmentTree,fruit)){
                unplacedCount++;
            }
        }
        return unplacedCount;
    }

    private static boolean querySegmentTree(int i, int l, int r, int[] baskets, int[] segmentTree, int val) {
        if(segmentTree[i]<val) return false;
        if(l==r){
            segmentTree[i] = -1;
            return true;
        }
        int mid = (r+l)/2;
        boolean placed;
        if(segmentTree[(2*i)+1]>=val){
            placed= querySegmentTree((2*i)+1,l,mid,baskets,segmentTree,val);
        }else placed= querySegmentTree((2*i)+2,mid+1,r,baskets,segmentTree,val);
        segmentTree[i] = Math.max(segmentTree[(2*i)+1], segmentTree[(2*i)+2]);
        return placed;
    }

    private static void buildSegmentTree(int i, int l, int r, int[] baskets, int[] segmentTree) {
        if(l==r){
            segmentTree[i] = baskets[l];
            return;
        }
        int mid = (r+l)/2;
        buildSegmentTree((2*i)+1,l,mid,baskets,segmentTree );
        buildSegmentTree((2*i)+2,mid+1,r,baskets,segmentTree );

        segmentTree[i] = Math.max(segmentTree[(2*i)+1], segmentTree[(2*i)+2]);
    }
}
