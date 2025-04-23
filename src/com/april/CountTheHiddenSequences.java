package com.april;

public class CountTheHiddenSequences {
    public static void main(String[] args) {
        int [] diffrences = {4,-7,2};
        int lower =3;
        int upper =6;
        int count = numberOfArrays(diffrences, lower, upper);
        System.out.println(count);
    }

    private static int numberOfArrays(int[] diffrences, int lower, int upper) {
        int curr =0;
        int n = diffrences.length;
        int max = 0;
        int min = 0;
        for(int diff : diffrences){
            curr +=diff;
            min = Math.min(curr, min);
            max = Math.max(curr, max);
            if((upper-max)-(lower-min)+1 <=0)
                return 0;
        }

        return (upper-max)-(lower-min)+1;
    }
}
