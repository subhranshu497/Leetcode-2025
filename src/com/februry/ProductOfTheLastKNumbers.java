package com.februry;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {
    public static void main(String[] args) {

    }
}
class ProductOfNumbers {

    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();

    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int i =0;
        int prod = 1;
        int n = list.size();
        while(i < k){
            prod *=list.get(n-k+i);
            i++;
        }
        return prod;
    }
}
