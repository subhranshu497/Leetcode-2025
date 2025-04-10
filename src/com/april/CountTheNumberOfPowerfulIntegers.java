package com.april;

public class CountTheNumberOfPowerfulIntegers {
    public static void main(String[] args) {
        int start = 1, finish = 6000, limit = 4;
        String s = "124";
        long ans = numberOfPowerfulInt(start, finish, limit, s);
        System.out.println(ans);
    }

    private static long numberOfPowerfulInt(int start, int finish, int limit, String s) {
        String startStr = String.valueOf(start-1);
        String finishStr = String.valueOf(finish);

        return solve(finishStr, s, limit) - solve(startStr, s, limit);
    }

    private static long solve(String str, String suffix, int limit) {
        if(str.length() < suffix.length()) return 0;

        long count =0;
        String rem = str.substring(str.length()-suffix.length());
        int remLen = str.length()-suffix.length();

        for(int i=0;i<remLen;i++){
            int digit = str.charAt(i)-'0';

            if(digit <= limit){
                count += Math.pow((limit+1),(remLen-i-1));
            }else {
                count += Math.pow((limit+1),(remLen-i));
                return count;
            }
        }
        if(rem.compareTo(suffix) >=0)count++;

        return count;
    }
}
