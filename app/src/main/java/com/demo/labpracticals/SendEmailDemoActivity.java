package com.demo.labpracticals;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.demo.labpracticals.databinding.ActivitySendEmailDemoBinding;


public class SendEmailDemoActivity extends AppCompatActivity {

    ActivitySendEmailDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendEmailDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}