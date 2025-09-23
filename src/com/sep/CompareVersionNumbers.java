package com.sep;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "1.0.1", version2 = "1";
        int res = compareVersion(version1, version2);
        System.out.println(res);
    }

    private static int compareVersion(String version1, String version2) {
        String [] v1Arr = version1.split("\\.");
        String [] v2Arr = version2.split("\\.");
        int n = v1Arr.length> v2Arr.length?v1Arr.length: v2Arr.length;
        int [] num1Arr = new int[n];
        num1Arr[0] = Integer.parseInt(v1Arr[0]);
        int j=1;
        for(int i=1;i<v1Arr.length;i++){
            int num = Integer.parseInt(v1Arr[i]);
            if(num==0)continue;
            num1Arr[i] = Integer.parseInt(v1Arr[i]);
        }
        int [] num2Arr = new int[n];
        num2Arr[0] = Integer.parseInt(v2Arr[0]);
        j=1;
        for(int i=1;i<v2Arr.length;i++){
            int num = Integer.parseInt(v2Arr[i]);
            if(num==0)continue;
            num2Arr[i] = Integer.parseInt(v2Arr[i]);
        }
        //parse and compare
        int l=0;
        int m =0;
        while (l<n){
            int num1 = num1Arr[l];
            int num2 = num2Arr[l];
            if(num1<num2)return -1;
            else if(num1 > num2) return 1;
            l++;
        }
        return 0;
    }
}
