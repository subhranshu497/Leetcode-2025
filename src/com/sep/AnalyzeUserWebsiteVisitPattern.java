package com.sep;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    public static void main(String[] args) {
        String [] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int [] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String [] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        List<String> res = mostVisitedPattern(username, timestamp, website);
        System.out.println(res);
    }

    private static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Pair1>> userAndtimeAndWeb = new HashMap<>();
        Map<String , Integer> webFreq = new HashMap<>();
        Map<String , Set<String>> webUser = new HashMap<>();
        for(int i=0;i<n;i++){
            webFreq.put(website[i], webFreq.getOrDefault(website[i], 0)+1);
            webUser.computeIfAbsent(website[i], k->new HashSet<>()).add(username[i]);
            userAndtimeAndWeb.computeIfAbsent(website[i], k->new ArrayList<>())
                    .add(new Pair1(username[i], timestamp[i]));

        }
        return new ArrayList<>();
    }
}
 class Pair1{
    String web;
    int tmst;
    public Pair1(){}
    public Pair1(String web, int tmst){
        this.web = web;
        this.tmst = tmst;
    }
}

