package com.demo.labpracticals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.demo.labpracticals.databinding.ActivityLocalNotificationDemoBinding;
import com.demo.labpracticals.notificationHandler.NotificationBuilder;

import java.util.ArrayList;
import java.util.Objects;

public class LocalNotificationDemoActivity extends AppCompatActivity {

    private ActivityLocalNotificationDemoBinding binding;
    private NotificationCompat.Builder builder;
    private int notificationId = 1000;
    private NotificationManager notificationManager;
    public static final String CHANNEL_ID = "myChannel";
    private final ArrayList<Integer> notificationIds = new ArrayList<>();

    private String[] getText(){
        String title = Objects.requireNonNull(binding.notificationTitle.getEditText()).getText().toString().trim();
        String smallText = Objects.requireNonNull(binding.notificationSmallText.getEditText()).getText().toString().trim();
        String bigText = Objects.requireNonNull(binding.bigEditText.getText()).toString().trim();
        return new String[]{title, smallText, bigText};
    }

    private boolean handleEmptyEditText(String[] str){
        for (String s: str) {
            if (s.isEmpty()){
                Toast.makeText(LocalNotificationDemoActivity.this, "please enter text in input", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocalNotificationDemoBinding.inflate(getLayoutInflater());
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        setContentView(binding.getRoot());
        NotificationBuilder buildBuilder = new NotificationBuilder(5000L);

        String CHANNEL_NAME = "testChannel";
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("My notification channel description");
        notificationManager.createNotificationChannel(channel);

        binding.notify.setOnClickListener(
                v -> {
                    String[] str = getText();
                    if(handleEmptyEditText(str)){
                        int newNotificationID = binding.UpdateOnChangeswitch.isChecked() ? notificationId : ++notificationId;
                        if(binding.showAdditionalImage.isChecked() && binding.showAdditionalImageExpandable.isChecked()){
                            builder = buildBuilder.generateNotificationBuilderObjExpandable(
                                    str,
                                    this,
                                    binding.showTimedNotification.isChecked(),
                                    binding.showAdditionalImage.isChecked(),
                                    binding.continueProcessSwitch.isChecked(),
                                    binding.TapActionswitch.isChecked() ? new Intent(this, MainActivity.class): null);
                        }
                        else{
                            builder = buildBuilder.generateNotificationBuilder(
                                    str,
                                    this,
                                    binding.showTimedNotification.isChecked(),
                                    binding.showBigText.isChecked(),
                                    binding.showAdditionalImage.isChecked(),
                                    binding.continueProcessSwitch.isChecked(),
                                    binding.TapActionswitch.isChecked() ? new Intent(this, MainActivity.class): null);
                        }

                        if(!binding.continueProcessSwitch.isChecked()){
                            notificationIds.add(newNotificationID);
                            Log.i("myTag", notificationIds.toString());
                        }
                        else
                            Log.i("myTag", String.valueOf(notificationId));


                        if (binding.singleNotificationSwitch.isChecked()){
                            binding.clearAllNotification.performClick();
                        }

                        notificationManager.notify( newNotificationID, builder.build() );
                    }
                }
        );


        binding.clearAllNotification.setOnClickListener(
                v -> {
                    notificationManager.cancelAll();
                    notificationIds.clear();
                }
        );

        binding.clearNonOnGoingNotification.setOnClickListener(
                v -> {
                    notificationIds.forEach(integer -> notificationManager.cancel(integer));
                    notificationIds.clear();
                }
        );

        binding.showBigText.setOnCheckedChangeListener(
                (v, isChecked) -> binding.showAdditionalImageExpandable.setEnabled(!isChecked)
        );

        binding.showAdditionalImage.setOnCheckedChangeListener(
                (v, isChecked) -> binding.showAdditionalImageExpandable.setEnabled(isChecked)
        );

        binding.showAdditionalImageExpandable.setEnabled(false);
    }
}