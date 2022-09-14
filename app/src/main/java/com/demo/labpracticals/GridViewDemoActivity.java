package com.demo.labpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import com.demo.labpracticals.adapter.GridViewCustomAdapter;
import com.demo.labpracticals.data.Animals;
import com.demo.labpracticals.data.StaticData;
import com.demo.labpracticals.databinding.ActivityGridViewDemoBinding;

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
        binding.gridBaseComp.setNumColumns(orientation == Configuration.ORIENTATION_PORTRAIT ? 3 : 4);
        Animals[] animals = StaticData.getInstance().getAnimalList(5);
        binding.gridBaseComp.setAdapter(new GridViewCustomAdapter(animals));

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