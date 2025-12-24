package com.dec;

import java.util.Arrays;
import java.util.Collections;

public class AppleRedistributionintoBoxes {
    public static void main(String[] args) {
        int [] capacity = {4,3,1,5,2};
        int [] apple = {1,3,2};
        int boxes = minimumBoxes(capacity, apple);
        System.out.println(boxes);
    }

    private static int minimumBoxes(int[] capacity, int[] apple) {
        int sum = 0;
        Integer [] capacities = Arrays.stream(capacity).boxed().toArray(Integer[]::new);
        for(int a:apple)
            sum +=a;
        Arrays.sort(capacities, Collections.reverseOrder());
        int boxCount = 0;
        for(int i=0;i<capacities.length;i++){
            if(sum>=capacities[i] || sum >0){
                boxCount +=1;
                sum -=capacities[i];
            }
            if(sum <=0)break;
        }
        return boxCount;
    }
}
