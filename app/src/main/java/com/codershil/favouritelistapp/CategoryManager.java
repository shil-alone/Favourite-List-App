package com.codershil.favouritelistapp;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class CategoryManager {

    private Context context;
    public CategoryManager(Context context){
        this.context = context;
    }

    public void saveCategory(Category category){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        HashSet itemHashSet = new HashSet(Arrays.asList(category.getItems()));
        editor.putStringSet(category.getName(),itemHashSet);
        editor.apply();
    }

    public ArrayList<Category> retrieveCategories(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Map<String,?> categoriesMap = sharedPreferences.getAll();
        ArrayList<Category> categories = new ArrayList<>();
        for (Map.Entry<String,?> entry : categoriesMap.entrySet()){
            Category category = new Category(entry.getKey(),new ArrayList<String>((HashSet)entry.getValue()));
            categories.add(category);
        }
        return categories;
    }
}
