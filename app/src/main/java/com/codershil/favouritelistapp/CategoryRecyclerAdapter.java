package com.codershil.favouritelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    interface CategoryClickListener {
        void categoryIsClicked(Category category);
    }

    ArrayList<Category> categories = new ArrayList<>();
    CategoryClickListener categoryClickListener;

    public CategoryRecyclerAdapter(ArrayList<Category> categories, CategoryClickListener categoryClickListener) {
        this.categories = categories;
        this.categoryClickListener = categoryClickListener;
    }


    @NotNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_item, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryViewHolder holder, int position) {
        holder.getTxtCategoryNumber().setText(String.valueOf(position + 1));
        holder.getTxtCategoryName().setText(categories.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryClickListener.categoryIsClicked(categories.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public void addCategory(Category category) {
        categories.add(category);
        notifyItemChanged(categories.size() - 1);
    }
}
