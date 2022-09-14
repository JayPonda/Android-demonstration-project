package com.demo.labpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.MenuItem;
import com.demo.labpracticals.adapter.RecyclerViewAdapter;
import com.demo.labpracticals.data.Animals;
import com.demo.labpracticals.data.StaticData;
import com.demo.labpracticals.databinding.ActivityRecyclerViewDemoBinding;

import java.util.Objects;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    ActivityRecyclerViewDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Animals[] animals = StaticData.getInstance().getAnimalList(10);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding.revyvlerViewComp.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        );
        binding.revyvlerViewComp.setAdapter(new RecyclerViewAdapter(animals));
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