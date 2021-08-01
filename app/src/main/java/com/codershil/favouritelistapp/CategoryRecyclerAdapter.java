package com.codershil.favouritelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    ArrayList<Category> categories = new ArrayList<>();

    public CategoryRecyclerAdapter(ArrayList<Category> categories){
        this.categories = categories;
    }


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
        holder.getTxtCategoryName().setText(categories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public void addCategory(Category category){
        categories.add(category);
        notifyItemChanged(categories.size()-1);
    }
}
