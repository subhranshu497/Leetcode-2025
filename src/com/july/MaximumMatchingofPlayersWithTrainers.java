package com.july;

import java.util.Arrays;

public class MaximumMatchingofPlayersWithTrainers {
    public static void main(String[] args) {
        int [] players = {1,1,1};
        int [] trainers = {10};
        int maxMatchingPlayers = matchPlayersAndTrainers(players, trainers);
        System.out.println(maxMatchingPlayers);
    }

    private static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int maxMatchingPlayers = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0;
        int j = 0;
        while(i<players.length && j<trainers.length){
            if(trainers[j]<players[i])j++;
            else{
                maxMatchingPlayers +=1;
                j++;
                i++;
            }
        }
        return maxMatchingPlayers;
    }
}
