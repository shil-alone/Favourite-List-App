package com.codershil.favouritelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CategoryItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);
        Category category =(Category) getIntent().getSerializableExtra(MainActivity.CATEGORY_OBJECT_KEY);
        setTitle(category.getName());
    }
}