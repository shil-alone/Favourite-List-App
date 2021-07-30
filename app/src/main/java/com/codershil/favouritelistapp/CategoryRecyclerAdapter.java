package com.codershil.favouritelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    String[] categories = {"Hobbies","Sports","Games","Electronic Gadgets","Foods","Countries"};
    @NotNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_item,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryViewHolder holder, int position) {
        holder.getTxtCategoryNumber().setText(String.valueOf(position+1));
        holder.getTxtCategoryName().setText(categories[position]);
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }
}
