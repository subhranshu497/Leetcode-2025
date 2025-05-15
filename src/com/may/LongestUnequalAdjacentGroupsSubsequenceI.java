package com.may;

import com.februry.MinimumOperationsToExceedThresholdValueII;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    public static void main(String[] args) {
        String [] words = {"a","b","c","d"};
        int [] groups = {1,0,1,1};
        List<String> res = getLongestSubsequence(words, groups);
        System.out.println(res);
    }

    private static List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for(int i=1;i<n;i++){
            if(groups[i-1]== groups[i])continue;
            res.add(words[i]);
        }
        return res;
    }
}
