package com.april;

public class CountSymmetricIntegers {
    public static void main(String[] args) {
        int low =1200;
        int high =1230;
        int count = countSymmetricIntegers(low, high);
        System.out.println(count);
    }

    private static int countSymmetricIntegers(int low, int high) {
        int count =0;
        for(int num=low;num<=high;num++){
            String str = String.valueOf(num);
            if(str.length()%2 !=0) continue;
            else {
                int mid = str.length()/2;
                String firstPart = str.substring(0, mid);
                String lastPart = str.substring(mid, str.length());
                int first = Integer.parseInt(firstPart);
                int last = Integer.parseInt(lastPart);
                if(calculateSum(first)==calculateSum(last))
                    count++;
            }
        }
        return count;
    }

    private static int calculateSum(int num) {
        int sum =0;
        while (num !=0){
            sum +=num%10;
            num /=10;
        }
        return sum;
    }
}
