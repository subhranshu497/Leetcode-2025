package com.june;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumDeletionstoMakeStringKSpecial {
    public static void main(String[] args) {
        String word = "aabcaba";
        int k = 0;
        int res = minimumDeletions(word, k);
        System.out.println(res);
    }

    private static int minimumDeletions(String word, int k) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:word.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        //collect all the frequencies
        List<Integer> valueList = map.values().stream()
                .sorted().collect(Collectors.toList());
        int minDeletion =Integer.MAX_VALUE;
        for(int i=0;i<valueList.size();i++){
            int deletion = 0;
            for(int j=0;j<valueList.size();j++){
                if(j==i)continue;
                int diff = Math.abs(valueList.get(j)-valueList.get(i));
                if(valueList.get(j)<valueList.get(i)){
                    deletion +=valueList.get(j);
                }
                else if(diff > k){
                    deletion += diff-k;
                }
            }
            minDeletion = Math.min(minDeletion, deletion);
        }

        return minDeletion;
    }
}
