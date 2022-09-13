package com.demo.labpracticals;

import static com.demo.labpracticals.MainActivity.CLASS_NAME;
import static com.demo.labpracticals.MainActivity.DATA_VALUE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListViewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Intent intent = getIntent();
        int it = intent.getIntExtra(DATA_VALUE, -1);
        String str = intent.getStringExtra(CLASS_NAME);
        TextView text = findViewById(R.id.textView);
        str = str + " " + it;
        text.setText(str);
    }
}