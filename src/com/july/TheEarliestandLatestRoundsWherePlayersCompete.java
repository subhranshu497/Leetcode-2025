package com.july;

import java.util.ArrayList;
import java.util.List;

public class TheEarliestandLatestRoundsWherePlayersCompete {
    public static void main(String[] args) {
        int n = 11;
        int firstPlayer = 2;
        int secondPlayer =4;
        int [] res = earliestAndLatest(n, firstPlayer, secondPlayer);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        List<Integer> playersList = new ArrayList<>();
        //initialize the list with players
        for(int i=0;i<n;i++){
            playersList.add(i+1);
        }
        System.out.println(playersList);

        return new int[]{0,0};
     }
}
