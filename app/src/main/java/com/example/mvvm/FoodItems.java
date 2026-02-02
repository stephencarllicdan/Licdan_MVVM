package com.example.mvvm;

public class FoodItems {
    private final int image;
    private final String foodName;
    private final String foodPrice;
    private final String foodDesc;
    private final String category; // Breakfast, Lunch, Dinner

    public FoodItems(int image, String foodName, String foodPrice, String foodDesc, String category) {
        this.image = image;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDesc = foodDesc;
        this.category = category;
    }

    public int getImage() { return image; }
    public String getFoodName() { return foodName; }
    public String getFoodPrice() { return foodPrice; }
    public String getFoodDesc() { return foodDesc; }
    public String getCategory() { return category; }
}
