package com.sep;

import java.util.*;

public class MinimumNumberOfPeopleToTeach {
    public static void main(String[] args) {
        int n = 3;
        int [][] languages = {{2},{1,3},{1,2},{3}};
        int [][] friendships = {{1,4},{1,2},{3,4},{2,3}};
        int minPeople = minimumTeachings(languages, friendships, n);
        System.out.println(minPeople);
    }

    private static int minimumTeachings(int[][] languages, int[][] friendships, int n) {
        Map<Integer, Set<Integer>> userLanguageMap = new HashMap<>();
        //iterate the langage array and put those in map
        for(int i=0;i< languages.length;i++){
            for(int j=0;j<languages[i].length;j++){
                userLanguageMap.computeIfAbsent(i+1, k->new HashSet<>()).add(languages[i][j]);
            }
        }
        System.out.println(userLanguageMap);
        //identify all users in friendship cant communicate

        Set<Integer> userToTeach = new HashSet<>();
        for(int [] friendship :friendships){
            int u = friendship[0];
            int v = friendship[1];
            boolean canTalk = false;
            for( int lang:userLanguageMap.get(u)){
                if(userLanguageMap.get(v).contains(lang)){
                    canTalk = true;
                    break;
                }
            }
            //if they dont speak common language
            if(!canTalk){
                userToTeach.add(u);
                userToTeach.add(v);
            }
        }
        //if all friends talks
        if(userToTeach.isEmpty()) return 0;
        Map<Integer, Integer> languageCount = new HashMap<>();
        int maxCount = 0;
        for (int user : userToTeach) {
            for (int lang : userLanguageMap.get(user)) {
                languageCount.put(lang, languageCount.getOrDefault(lang, 0) + 1);
            }
        }
        for (int count : languageCount.values()) {
            maxCount = Math.max(maxCount, count);
        }
        return userToTeach.size() - maxCount;
    }
}
