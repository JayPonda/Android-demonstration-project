package com.demo.labpracticals;

import static com.demo.labpracticals.MainActivity.CLASS_NAME;
import static com.demo.labpracticals.MainActivity.DATA_VALUE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class DialogMessageDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_message_demo);

        Intent intent = getIntent();
        int it = intent.getIntExtra(DATA_VALUE, -1);
        String str = intent.getStringExtra(CLASS_NAME);
        TextView text = findViewById(R.id.textView);
        str = str + " " + it;
        text.setText(str);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
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