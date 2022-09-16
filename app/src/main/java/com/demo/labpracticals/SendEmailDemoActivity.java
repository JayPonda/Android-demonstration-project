package com.demo.labpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.demo.labpracticals.HandleEmailActivity.HandleEmilStack;
import com.demo.labpracticals.databinding.ActivitySendEmailDemoBinding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SendEmailDemoActivity extends AppCompatActivity {

    ActivitySendEmailDemoBinding binding;
    Toast toast;
    LayoutInflater layoutInflater;
    HandleEmilStack handleEmilStack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendEmailDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        layoutInflater = LayoutInflater.from(this);
        handleEmilStack = new HandleEmilStack(layoutInflater, R.layout.new_email_row_templete, binding.receiverEmailGroup, this);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        binding.customToolBar.setSubtitle(dtf.format(now));
        setSupportActionBar(binding.customToolBar);

        handleEmilStack.addNewInstOfMail();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.email_functions, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.send_email:
                sendEmail();
                return true;
            case R.id.draft_email:
                draftEmail();
                return true;
            default:
                finish();
                return super.onOptionsItemSelected(item);
        }
    }

    private void draftEmail() {

    }

    @SuppressLint("QueryPermissionsNeeded")
    private void sendEmail() {
//        String sEmail = binding.senderEmail.getText().toString();
        String[] rEmail = handleEmilStack.getEmail();
        String subject = binding.emailSubject.getText().toString();
        String body = binding.emailBody.getText().toString();

        if(rEmail.length == 0)
            setToast("Receiver mail address is missing");
//        else if(sEmail.isEmpty())
//            setToast("Sender mail address is missing");
        else if(subject.isEmpty())
            setToast("Subject of the email is missing");
        else if(body.isEmpty())
            setToast("Email body is missing");
        else{
            (Objects.requireNonNull(getSupportActionBar())).setTitle("Mail is ready to send");


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.putExtra(Intent.EXTRA_EMAIL, rEmail);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            intent.setData(Uri.parse("mailto:"));

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                setToast("There is no application that support this action");
            }
        }
    }


    private void setToast(String message){
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}