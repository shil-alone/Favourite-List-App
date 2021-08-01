package com.codershil.favouritelistapp;

import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<String> items = new ArrayList<>();

    public Category(String name ,ArrayList<String> items){
        this.name = name;
        this.items = items;
    }

    String getName(){
        return name;
    }

    ArrayList<String> getItems(){
        return items;
    }

}
