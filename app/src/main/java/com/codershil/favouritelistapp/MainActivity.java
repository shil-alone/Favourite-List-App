package com.codershil.favouritelistapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codershil.favouritelistapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoryRecyclerAdapter.CategoryClickListener {

    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    public static final String CATEGORY_OBJECT_KEY = "CATEGORY_OBJECT_KEY";
    CategoryManager categoryManager = new CategoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        recyclerView = findViewById(R.id.category_recyclerview);

        ArrayList<Category> categories = categoryManager.retrieveCategories();
        recyclerView.setAdapter(new CategoryRecyclerAdapter(categories,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCreateCategoryDialog();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayCreateCategoryDialog() {
        String title = getString(R.string.create_category_title);
        String positiveButtonText = getString(R.string.positive_button_text);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        EditText edtCategoryText = new EditText(this);
        edtCategoryText.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(edtCategoryText);
        builder.setTitle(title);
        builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Category category = new Category(edtCategoryText.getText().toString(), new ArrayList<String>());
                categoryManager.saveCategory(category);

                CategoryRecyclerAdapter categoryRecyclerAdapter = (CategoryRecyclerAdapter) recyclerView.getAdapter();
                categoryRecyclerAdapter.addCategory(category);
                showCategoryItems(category);

            }
        });
        builder.create().show();
    }

    private void showCategoryItems(Category category){
        Intent intent = new Intent(MainActivity.this, CategoryItemsActivity.class);
        intent.putExtra(CATEGORY_OBJECT_KEY,category);
        startActivity(intent);
    }

    @Override
    public void categoryIsClicked(Category category) {
        showCategoryItems(category);
    }
}