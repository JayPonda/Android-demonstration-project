package com.demo.labpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.labpracticals.databinding.ActivitySharedPreferencesDemoBinding;

public class SharedPreferencesDemoActivity extends AppCompatActivity {

    ActivitySharedPreferencesDemoBinding binding;
    SharedPreferences sharedPreferences;

    private void setNewText(boolean isClear){
        if(sharedPreferences == null)
            return;

        if(isClear){
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("name", "");
            myEdit.putInt("number", 0);
            myEdit.apply();
            return;
        }

        String name = binding.NameEt.getText().toString().trim();
        String num = binding.numberEt.getText().toString().trim();
        if(name.equals("")){
            Toast.makeText(SharedPreferencesDemoActivity.this, "empty string is not allowed", Toast.LENGTH_SHORT).show();
        }
        else if(num.equals("")){
            Toast.makeText(SharedPreferencesDemoActivity.this, "empty number is not allowed", Toast.LENGTH_SHORT).show();
        }
        else {
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("name", name);
            myEdit.putInt("number", Integer.parseInt(num));
            myEdit.apply();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySharedPreferencesDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = this.getSharedPreferences("MySharedPref",MODE_PRIVATE);

        binding.save.setOnClickListener(
                l -> setNewText(false)
        );

        binding.Load.setOnClickListener(
                l -> {
                    binding.NameEt.setText(sharedPreferences.getString("name", "~~No Value~~"));
                    String s = Integer.toString(sharedPreferences.getInt("number", 0));
                    binding.numberEt.setText(s);
                });

        binding.Clear.setOnClickListener(
          l -> {
              binding.NameEt.setText("");
              binding.numberEt.setText("0");
              setNewText(true);
          }
        );
    }
}