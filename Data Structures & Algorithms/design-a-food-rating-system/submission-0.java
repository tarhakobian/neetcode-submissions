class FoodRatings {
    private Map<String, PriorityQueue<Food>> foodMap = new HashMap<>();
    private Map<String, Integer> ratingMap = new HashMap<>();
    private Map<String, String> foodToCuisine = new HashMap<>();

    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            ratingMap.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);

            foodMap.computeIfAbsent(cuisines[i], key ->
                new PriorityQueue<>((a, b) -> {
                    if (a.rating != b.rating) {
                        return Integer.compare(b.rating, a.rating);
                    }
                    return a.name.compareTo(b.name);
                })
            ).offer(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        ratingMap.put(food, newRating);
        String cuisine = foodToCuisine.get(food);

        foodMap.get(cuisine).offer(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = foodMap.get(cuisine);

        while (pq.peek().rating != ratingMap.get(pq.peek().name)) {
            pq.poll();
        }

        return pq.peek().name;
    }
}