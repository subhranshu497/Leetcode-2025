package com.oct;

import java.util.HashMap;
import java.util.Map;

public class MaximizetheNumberofPartitionsAfterOperations {
    public static void main(String[] args) {
        String s = "accca";
        int k =2;
        int partition = maxPartitionsAfterOperations(s,k);
        System.out.println(partition);
    }

    private static int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> map = new HashMap<>();
        return solveMaxPartitionAfterOperation(s,k,0,0,true, map)+1;
    }

    private static int solveMaxPartitionAfterOperation(String s, int k, long i, long uniqueChar, boolean canChange, Map<Long, Integer> map) {

        long key = (i<<27) | (uniqueChar<<1) | (canChange ? 1:0);
        if(map.containsKey(key))
            return map.get(key);
        //base conditon
        if(i>=s.length()) return 0;
        int result;
        int charIndex = s.charAt((int)i)-'a';
        long uniqueCharUpaded = uniqueChar | (1L << charIndex);
        int uniqueCharCount = Long.bitCount(uniqueCharUpaded);

        if(uniqueCharCount >k){
            result =1+ solveMaxPartitionAfterOperation(s,k,i+1,1L<<charIndex,canChange, map);
        }else{
            result = solveMaxPartitionAfterOperation(s,k,i+1,uniqueCharUpaded,canChange, map);
        }
        if(canChange){
            for(int idx=0;idx<26;idx++){
                long newUniqueChar = uniqueChar | (1L << idx);
                int newUniqueCharCount = Long.bitCount(newUniqueChar);
                if(newUniqueCharCount>k){
                    result = Math.max(result, 1+solveMaxPartitionAfterOperation(s,k,i+1, 1L<<idx,false, map));
                }else result = Math.max(result, solveMaxPartitionAfterOperation(s, k,i+1, newUniqueChar,false, map));
            }
        }
        map.put(key, result);
        return result;
    }
}
