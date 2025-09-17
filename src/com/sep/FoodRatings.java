package com.sep;

import java.util.*;

public class FoodRatings {
    private String[] foods;
    private String[] cuisines;
    private int [] ratings;
    private int n ;
    private Map<String, Integer> foodRating;
    private Map<String, String> foodCuisine;
    private Map<String, PriorityQueue<Pair>> cuisineFoodMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoodMap = new HashMap<>();
        n = foods.length;
        Comparator<Pair> customComparator = (a, b) -> {
            if (a.rating != b.rating) {
                return Integer.compare(b.rating, a.rating);
            }
            return a.food.compareTo(b.food);
        };
        for(int i=0;i<n;i++){
            String food = foods[i];
            int rating = ratings[i];
            String cuisine = cuisines[i];
            foodRating.put(food, rating);
            foodCuisine.put(food,cuisine);
            cuisineFoodMap.computeIfAbsent(cuisine,k->new PriorityQueue<>(customComparator))
                    .add(new Pair(food, rating));
        }
    }
    public void changeRating(String food, int newRating){
        foodRating.put(food, newRating);
        String cuisine = foodCuisine.get(food);
        //now store it in cuisineFoodMap
        PriorityQueue<Pair> pq = cuisineFoodMap.get(cuisine);
        pq.add(new Pair(food, newRating));
    }
    public String highestRated(String cuisine){
        PriorityQueue<Pair> pq = cuisineFoodMap.get(cuisine);

        while (true){
            Pair highestRating = pq.peek();
            //if rating in the pair matches the current rating of the map , then it is good, return
            if(foodRating.get(highestRating.food).equals(highestRating.rating))
                return highestRating.food;
            pq.poll();
        }
    }
}
class Pair{
    String food;
    int rating;
    public Pair(String food, int rating){
        this.food = food;
        this.rating = rating;
    }
}
