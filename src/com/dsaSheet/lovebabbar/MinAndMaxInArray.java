package com.dsaSheet.lovebabbar;

public class MinAndMaxInArray {
    public static void main(String[] args) {
        int [] arr = {3, 2, 1, 56, 10000, 167};
        Pair<Integer, Integer> p = getMinMax(arr);
    }

    private static Pair<Integer, Integer> getMinMax(int[] arr) {

        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a:arr){
            max = Math.max(max,a);
            min = Math.min(min, a);
        }
        Pair<Integer, Integer> p = new Pair<>(min,max);
        return p;
    }
}
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
