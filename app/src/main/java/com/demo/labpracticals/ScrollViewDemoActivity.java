package com.demo.labpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.labpracticals.data.Animals;
import com.demo.labpracticals.data.StaticData;
import com.demo.labpracticals.databinding.ActivityScrollViewDemoBinding;

import java.util.Objects;

public class ScrollViewDemoActivity extends AppCompatActivity {

    ActivityScrollViewDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScrollViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Animals[] animals = StaticData.getInstance().getAnimalList(15);

        for (Animals animal : animals) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(animal.getImgRes());
            /* imageView.setPadding(5, 5 , 5, 5); */
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, //WIDTH
                    ViewGroup.LayoutParams.WRAP_CONTENT); //HEIGHT
            param.setMargins(0, 5, 0, 5);
            imageView.setLayoutParams(param);
            binding.parentLinearLayout.addView(imageView);
        }

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