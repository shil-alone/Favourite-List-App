package com.codershil.favouritelistapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private TextView txtCategoryNumber ,txtCategoryName;
    public CategoryViewHolder(@NotNull View itemView) {
        super(itemView);
        txtCategoryName = itemView.findViewById(R.id.category_name_textview);
        txtCategoryNumber = itemView.findViewById(R.id.category_number_textview);
    }

    public TextView getTxtCategoryNumber() {
        return txtCategoryNumber;
    }

    public TextView getTxtCategoryName() {
        return txtCategoryName;
    }
}
