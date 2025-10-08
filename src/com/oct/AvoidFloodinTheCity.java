package com.oct;

import java.util.*;

public class AvoidFloodinTheCity {
    public static void main(String[] args) {
        int [] rains = {1,0,2,0,1,2};
        int [] ans = avoidFlood(rains);
        for(int a:ans){
            System.out.print(a+", ");
        }
    }

    private static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int [] ans = new int[n];
        Arrays.fill(ans,1);
        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            int lake = rains[i];
            if(lake==0) set.add(i);
            else{
                ans[i] =-1;
                //now check if lake already has water
                if(map.containsKey(lake)){
                    Integer dryday = set.higher(map.get(lake));
                    if(dryday==null) return new int[]{};
                    ans[dryday]=lake;
                    set.remove(dryday);
                }
                map.put(lake, i);
            }
        }
        return ans;
    }
}
