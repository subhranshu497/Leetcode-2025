package com.design;

import java.util.*;

public class DesignTwitter {
    private static int timeStamp=0;
   private Map<Integer, List<int[]>> userTweetMap;
    private Map<Integer, Set<Integer>> followerFolloweeMap;
    public DesignTwitter() {
        userTweetMap = new HashMap<>();
        followerFolloweeMap = new HashMap<>();
    }

    void postTweet(int userId, int tweetId) {
        userTweetMap.putIfAbsent(userId, new ArrayList<>());
        userTweetMap.get(userId).add(new int[]{timeStamp++, tweetId});
    }

    List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        Set<Integer> followeesSet = followerFolloweeMap.getOrDefault(userId, new HashSet<>());
        followeesSet.add(userId);
        for(int followee:followeesSet){
            //get the tweet list for each user
            List<int[]> tweetListAndTimeStamp = userTweetMap.getOrDefault(followee, new ArrayList<>());
            maxHeap.addAll(tweetListAndTimeStamp);
        }
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size()<10){
            result.add(maxHeap.poll()[1]);
        }
        return result;
    }

    void follow(int followerId, int followeeId) {
        followerFolloweeMap.putIfAbsent(followerId, new HashSet<>());
        followerFolloweeMap.get(followerId).add(followeeId);
    }

    void unfollow(int followerId, int followeeId) {
        if(followerFolloweeMap.containsKey(followerId))
            followerFolloweeMap.get(followerId).remove(followeeId);
    }
}
