package com.example.mvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private final Context context;
    private final List<FoodItems> items = new ArrayList<>();

    public FoodAdapter(Context context) {
        this.context = context;
    }

    public void setFoodList(List<FoodItems> foodItems) {
        items.clear();
        if (foodItems != null) items.addAll(foodItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(
                LayoutInflater.from(context).inflate(R.layout.items, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodItems item = items.get(position);

        holder.imageView.setImageResource(item.getImage());
        holder.foodName.setText(item.getFoodName());
        holder.foodPrice.setText(item.getFoodPrice());
        holder.foodDesc.setText(item.getFoodDesc());

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context,
                        item.getFoodName() + " - " + item.getFoodPrice(),
                        Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
