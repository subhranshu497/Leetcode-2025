package com.june;

import java.util.*;

public class KthSmallestProductofTwoSortedArrays {
    public static void main(String[] args) {
        int [] nums1 = {-2,-1,0,1,2};
        int []nums2 = {-3,-1,2,4,5};
        long k = 3;
        long res = kthSmallestProduct(nums1, nums2, k);
        System.out.println(res);
    }

    private static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        //apply binary search on product
        long high = 10000000000L;
        long low = -10000000000L;
        long res = 0;
        while(low <= high){
            long midProduct = low+(high-low)/2;
            //now apply binary search and find number of product and the product which is less than equal to midproduct
            long countProduct = findProductLessOrEqualToMidProduct(nums1,nums2,midProduct,k);

            if(countProduct >=k){
                res = midProduct;
                high = midProduct-1;
            }else{
                low = midProduct+1;
            }
        }
        return res;
    }

    private static long findProductLessOrEqualToMidProduct(int[] nums1, int[] nums2, long midProduct, long k) {
        int n = nums2.length;
        //iterate through nums1 and apply binary search on nums2
        //calculate the prod less than or equal to midproduct
        long countProducts = 0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]>=0){
                int l = 0;
                int r =n-1;
                int pos = -1;
                while (l<=r){
                    int mid = l+(r-l)/2;
                    long product =(long) nums1[i]*nums2[mid];
                    if(product<=midProduct){
                        pos = mid;
                        l = mid+1;
                    }else {
                        r = mid-1;
                    }
                }
                countProducts +=(pos+1);
            }else{
                int l = 0;
                int r =n-1;
                int pos = n;
                while (l<=r){
                    int mid = l+(r-l)/2;
                    long product =(long) nums1[i]*nums2[mid];
                    if(product<=midProduct){
                        pos = mid;
                        r = mid-1;
                    }else {
                        l = mid+1;
                    }
                }
                countProducts +=(n-pos);
            }
        }
        return countProducts;
    }

    // brute force - tle
//    private static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        List<Long> productList = new ArrayList<>();
//
//        for(int i=0;i<n1;i++){
//            for(int j =0;j<n2;j++){
//                long prod =(long) nums1[i]*nums2[j];
//                productList.add(prod);
//            }
//        }
//        Collections.sort(productList);
//        int sk = (int)k;
//        long res =(long) productList.get(sk-1);
//        return res;
//    }
}
