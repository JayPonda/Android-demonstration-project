package com.demo.labpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.demo.labpracticals.adapter.GridViewCustomAdapter;
import com.demo.labpracticals.data.Animals;
import com.demo.labpracticals.data.StaticData;
import com.demo.labpracticals.databinding.ActivityGridViewDemoBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GridViewDemoActivity extends AppCompatActivity {

    ActivityGridViewDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGridViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        int orientation = getResources().getConfiguration().orientation;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                this,
                orientation == Configuration.ORIENTATION_PORTRAIT ? 3 : 4,
                GridLayoutManager.VERTICAL,
                false);
        binding.recyclerViewDemo.setLayoutManager(gridLayoutManager);
        Animals[] animals = StaticData.getInstance().getAnimalList(5);
        binding.recyclerViewDemo.setAdapter(new GridViewCustomAdapter(animals));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}