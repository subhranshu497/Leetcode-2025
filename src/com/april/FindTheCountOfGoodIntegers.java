package com.april;

import java.util.*;

public class FindTheCountOfGoodIntegers {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        long ans = countGoodIntegers(n, k);
        System.out.println(ans);
    }

    private static long countGoodIntegers(int n, int k) {
        Set<String> palliSet = new HashSet<>();
        int mid = (n+1)/2;
        //find the lower and upper limit
        int lower = (int) Math.pow(10, (mid - 1)); // 100
        int upper = (int) Math.pow(10, mid)-1; // 999
        for(int num = lower;num<=upper;num++){
            String left = String.valueOf(num);
            String full ="";
            if(n%2==0){
                String right = reverseString(left);
                full = left + right;
            }else{
                String right = reverseString(left.substring(0, left.length()-1));
                full = left +right;
            }

            long kPalli = Long.parseLong(full);
            if(kPalli % k==0){
                char [] charArr = full.toCharArray();
                Arrays.sort(charArr);
                palliSet.add(new String(charArr));
            }else continue;
        }
        //iterate set
        long count =0;
        for(String s:palliSet){
            int num = Integer.parseInt(s);
            count +=checkPermutation(num);
        }
        return count;
    }

    private static long checkPermutation(int num){
        String str = String.valueOf(num);
        long possiblePermutation =0;
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch :str.toCharArray())
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        if(freq.containsKey('0')){
            int nonzero = str.length()-freq.get('0');
            int deno = calculateDeno(freq);
            possiblePermutation = nonzero*calculateFactorial(str.length()-1)/deno;
        }else{
            int deno = calculateDeno(freq);
            possiblePermutation = calculateFactorial(str.length())/deno;
        }
        return possiblePermutation;
    }

    private static int calculateDeno(Map<Character, Integer> freq) {
        int deno = 1;
        for(Map.Entry<Character, Integer> e: freq.entrySet()){
            char c = e.getKey();
            int v = e.getValue();
            if(v !=1){
                deno *=calculateFactorial(v);
            }
        }
        return deno;
    }

    private static int calculateFactorial(int n){
        //base condition
        if(n==0 || n==1)return 1;
        return n*calculateFactorial(n-1);
    }
    private static String reverseString(String s){
        StringBuilder rev = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
}
