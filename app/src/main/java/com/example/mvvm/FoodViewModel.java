package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class FoodViewModel extends ViewModel {

    private final MutableLiveData<List<FoodItems>> foodList = new MutableLiveData<>();

    public FoodViewModel() {
        loadFoodItems();
    }

    private void loadFoodItems() {
        List<FoodItems> items = new ArrayList<>();

        // Breakfast
        items.add(new FoodItems(R.drawable.burger, "Burger", "₱100", "Juicy beef burger", "Breakfast"));
        items.add(new FoodItems(R.drawable.pancakes, "Pancakes", "₱80", "Fluffy pancakes with syrup", "Breakfast"));
        items.add(new FoodItems(R.drawable.omelette, "Omelette", "₱90", "Cheese and veggie omelette", "Breakfast"));

        // Lunch
        items.add(new FoodItems(R.drawable.pizza, "Pizza", "₱120", "Cheesy pepperoni pizza", "Lunch"));
        items.add(new FoodItems(R.drawable.fries, "Fries", "₱80", "Crispy golden fries", "Lunch"));
        items.add(new FoodItems(R.drawable.sandwich, "Sandwich", "₱95", "Ham and cheese sandwich", "Lunch"));

        // Dinner
        items.add(new FoodItems(R.drawable.chicken, "Chicken", "₱150", "Spicy fried chicken", "Dinner"));
        items.add(new FoodItems(R.drawable.spaghetti, "Spaghetti", "₱90", "Sweet-style spaghetti", "Dinner"));
        items.add(new FoodItems(R.drawable.steak, "Steak", "₱250", "Grilled beef steak", "Dinner"));

        foodList.setValue(items);
    }


    public LiveData<List<FoodItems>> getFoodList() {
        return foodList;
    }
}
