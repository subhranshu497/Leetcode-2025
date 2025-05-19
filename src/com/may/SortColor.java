package com.may;

public class SortColor {
    public static void main(String[] args) {
        int [] colors = {2,0,2,1,1,0};
        int [] output = sortColors(colors);
        for(int color:output)
            System.out.print(color+", ");
    }

    private static int[] sortColors(int[] colors) {
        int n = colors.length;
        int p0=0;
        int i =0;
        int p2 = n-1;
        int temp;
        while(i<=p2){
            if(colors[i]==0){
                temp = colors[p0];
                colors[p0] = colors[i];
                colors[i] = temp;
                i++;
                p0++;
            }else if(colors[i]==2){
                temp = colors[i];
                colors[i] = colors[p2];
                colors[p2] = temp;
                p2--;
            }else {
                i++;
            }
        }
        return colors;
    }
}
