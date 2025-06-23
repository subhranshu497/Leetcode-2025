package com.dsaSheet.lovebabbar;

import java.util.HashSet;
import java.util.Set;

public class UnionofArrayswithDuplicates {
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5};
        int [] b = {1,2,3};
        int size = findUnion(a,b);
        System.out.println(size);
    }

    private static int findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for(int element:a)
            set.add(element);
        for(int element:b)
            set.add(element);

        return set.size();
    }
}
