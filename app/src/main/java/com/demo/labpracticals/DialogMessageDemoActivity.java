package com.demo.labpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.demo.labpracticals.databinding.ActivityDialogMessageDemoBinding;

import java.util.Objects;

public class DialogMessageDemoActivity extends AppCompatActivity {

    ActivityDialogMessageDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDialogMessageDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Dialog message demo")
                    .setMessage("this is the demo of dialog message with three options. choose any one.")
                    //.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener(){
                    .setPositiveButton(
                            getString(R.string.ok),
                            (dialog, which) -> binding.alertState.setText(getString(R.string.ok)))
                    .setNegativeButton(getString(
                            R.string.cancel),
                            (dialog, which) -> binding.alertState.setText(getString(R.string.cancel)))
                    .setNeutralButton(
                            getString(R.string.the_other_one),
                            (dialog, which) -> binding.alertState.setText(getString(R.string.the_other_one)))
                    .show();

            alertDialog.create();
        });

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