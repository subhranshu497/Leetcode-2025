package com.sep;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    public static void main(String[] args) {
        String [] username = {"ua","ua","ua","ub","ub","ub"};
        int [] timestamp = {1,2,3,4,5,6};
        String [] website = {"a","b","a","a","b","c"};
        List<String> res = mostVisitedPattern(username, timestamp, website);
        System.out.println(res);
    }

    private static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<String>> userWebSiteMap = new HashMap<>();
        for(int i=0;i<n;i++){
            String uName = username[i];
            String wbSite = website[i];
            int time = timestamp[i];
            userWebSiteMap.computeIfAbsent(uName, k->new ArrayList<>()).add(wbSite);
        }
        //concat the website and store as map key
        Map<String, List<List<String>>> websiteMap = new TreeMap<>();
        for(Map.Entry<String, List<String>> e: userWebSiteMap.entrySet()){
            List<String> websiteList = userWebSiteMap.get(e.getKey());
            StringBuilder sb = new StringBuilder();
            for(String s:websiteList){
                sb.append(s);
            }
            websiteMap.computeIfAbsent(sb.toString(), k->new ArrayList<>()).add(websiteList);
        }
        List<String> res = new ArrayList<>();
        int size =0;
        for(Map.Entry<String, List<List<String>>> e: websiteMap.entrySet()){
            List<List<String>> value = e.getValue();
            int tempSize = value.size();
            if(size < tempSize){
                size = tempSize;
                res = value.get(0);
            }
        }
        return res;
    }
}

