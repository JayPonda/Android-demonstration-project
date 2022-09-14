package com.demo.labpracticals;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.demo.labpracticals.databinding.ActivityListViewDemoBinding;

import java.util.Objects;

public class ListViewDemoActivity extends AppCompatActivity {

    ActivityListViewDemoBinding binding;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewDemoBinding.inflate(getLayoutInflater());
        String[] animals = getResources().getStringArray(R.array.animalList);

        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding.listViewComp.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_gallery_item, animals)
        );
        binding.listViewComp.setOnItemClickListener((parent, view, position, id) -> {
            if(toast != null)
                toast.cancel();
            toast = Toast.makeText(this, animals[position], Toast.LENGTH_SHORT);
            toast.show();
        });
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