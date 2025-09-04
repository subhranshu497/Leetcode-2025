package com.sep;

public class FindClosestPerson {
    public static void main(String[] args) {
        int x = 2, y = 7, z = 4;
        int res = findClosest(x,y,z);
        System.out.println(res);
    }

    private static int findClosest(int x, int y, int z) {
        int first = Math.abs(x-z);
        int second = Math.abs(y-z);

        if(first==second) return 0;
        else return first>second?2:1;
    }
}
