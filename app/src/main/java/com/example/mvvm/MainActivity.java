package com.example.mvvm;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FoodAdapter adapter;
    private FoodViewModel viewModel;

    private TextView currentSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new FoodAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(FoodViewModel.class);

        // Observe all foods
        viewModel.getFoodList().observe(this, adapter::setFoodList);

        // Selection buttons
        TextView allBtn = findViewById(R.id.allButton);
        TextView breakfastBtn = findViewById(R.id.breakfastButton);
        TextView lunchBtn = findViewById(R.id.lunchButton);
        TextView dinnerBtn = findViewById(R.id.dinnerButton);

        // Default selected
        currentSelected = allBtn;
        updateSelection(allBtn);

        allBtn.setOnClickListener(v -> {
            adapter.setFoodList(viewModel.getFoodList().getValue());
            updateSelection(allBtn);
        });

        breakfastBtn.setOnClickListener(v -> {
            filterCategory("Breakfast");
            updateSelection(breakfastBtn);
        });

        lunchBtn.setOnClickListener(v -> {
            filterCategory("Lunch");
            updateSelection(lunchBtn);
        });

        dinnerBtn.setOnClickListener(v -> {
            filterCategory("Dinner");
            updateSelection(dinnerBtn);
        });
    }

    private void filterCategory(String category) {
        List<FoodItems> filtered = new ArrayList<>();
        List<FoodItems> allItems = viewModel.getFoodList().getValue();

        if (allItems != null) {
            for (FoodItems item : allItems) {
                if (item.getCategory().equals(category)) {
                    filtered.add(item);
                }
            }
        }
        adapter.setFoodList(filtered);
    }

    private void updateSelection(TextView selected) {
        if (currentSelected != null) {
            currentSelected.setTypeface(null, Typeface.NORMAL);
            currentSelected.setTextColor(getColor(R.color.menu_title));
        }

        selected.setTypeface(null, Typeface.BOLD);
        selected.setTextColor(getColor(R.color.menu_price)); // accent
        currentSelected = selected;
    }
}
