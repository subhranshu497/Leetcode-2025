package com.dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountMentionsPerUser {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("MESSAGE");
        list1 .add("10");
        list1.add("id1 id0");

        List<String> list2 = new ArrayList<>();
        list2.add("OFFLINE");
        list2 .add("11");
        list2.add("0");

        List<String> list3 = new ArrayList<>();
        list3.add("MESSAGE");
        list3 .add("71");
        list3.add("HERE");
        List<List<String>> events = new ArrayList<>();
        events.add(list1);
        events.add(list2);
        events.add(list3);
        System.out.println(events);
        int numberOfUsers =2;
        int [] mentions = countMentions(numberOfUsers,events);
        for(int mention:mentions)
            System.out.print(mention+" ");
    }

    private static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int [] mentions = new int[numberOfUsers];
        int [] offlineTime = new int[numberOfUsers];

        Collections.sort(events, (a, b) -> {

            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 == t2) {
                char c1 = a.get(0).charAt(1);
                char c2 = b.get(0).charAt(1);

                if (c1 > c2) return -1;
                if (c1 < c2) return 1;
                return 0;
            }

            return Integer.compare(t1, t2);
        });
        for(List<String> event:events){
            if(event.get(0).equals("MESSAGE")){
                applyMessageEvent(event, mentions, offlineTime);
            }else if(event.get(0).equals("OFFLINE")){
                int timeStamp = Integer.parseInt(event.get(1));
                int id = Integer.parseInt(event.get(2));
                offlineTime[id] = timeStamp;
            }
        }
        return mentions;
    }

    private static void applyMessageEvent(List<String> event, int[] mentions, int[] offlineTime) {
        int time = Integer.parseInt(event.get(1));
        String [] ids = event.get(2).split(" ");
        for(String id:ids){
            if(id.equals("ALL")){
                for(int i=0;i< mentions.length;i++)
                    mentions[i]++;
            }else if(id.equals("HERE")){
                for(int i=0;i<mentions.length;i++){
                    if(offlineTime[i]==0 || offlineTime[i]+60 <= time)
                        mentions[i]++;
                }
            } else {
                int userId = Integer.parseInt(id.substring(2));
                mentions[userId]++;
            }
        }
    }
}
