package com.may;

import java.util.Arrays;
import java.util.Collections;

public class MaximumNumberOfTasksYouCanAssign {
    public static void main(String[] args) {
        int [] tasks = {3,2,1};
        int [] workers = {3,3,0};
        int strength = 1;
        int pills = 1;
        int count = maxTaskAssign(tasks, workers, pills, strength);
        System.out.println(count);
    }

    private static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int m = workers.length;
        int n = tasks.length;
        int i = 0;
        int j = 0;
        Arrays.stream(workers).boxed().sorted(Collections.reverseOrder());
        Arrays.stream(tasks).boxed().sorted(Collections.reverseOrder());
        int res=0;
        while(i<n && j<m){
            if(workers[j]>=tasks[i]){
                res++;
            }else{
                workers[j] +=strength;
                pills--;
            }
        }
        return res;
    }
}
