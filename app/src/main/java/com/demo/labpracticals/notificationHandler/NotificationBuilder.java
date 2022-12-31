package com.demo.labpracticals.notificationHandler;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

import com.demo.labpracticals.R;
import com.demo.labpracticals.data.Animals;
import com.demo.labpracticals.data.StaticData;
import static com.demo.labpracticals.LocalNotificationDemoActivity.CHANNEL_ID;

import java.util.Random;

public class NotificationBuilder {

    private final long DELAY;
    StaticData staticData = StaticData.getInstance();
    Animals[] animal = staticData.getAnimalList();

    public NotificationBuilder(long DELAY) {
        this.DELAY = DELAY;
    }

    public NotificationCompat.Builder generateNotificationBuilder(String[] str, Context context, boolean isTimeOut, boolean isBig, boolean isLargeImage, boolean isProcessContinue, Intent intent){
        NotificationCompat.Builder newBuilder =  new NotificationCompat.Builder(context, CHANNEL_ID )
                .setContentTitle(str[0])
                .setContentText(str[1])
                .setSmallIcon(R.drawable.ic_baseline_edit_24)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setOnlyAlertOnce(true)
                .setColor(Color.parseColor("#ff00aac2"));

        if (isBig){
            newBuilder.setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(str[2]));
        }

        if(isProcessContinue)
            newBuilder.setOngoing(true);
        else
            if(isTimeOut)
                newBuilder.setTimeoutAfter(DELAY);

        if(intent != null)
            newBuilder.setAutoCancel(true)
                    .setContentIntent(PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE));

        if(isLargeImage){

            int randomVal = (new Random()).nextInt(staticData.getListLength());
            newBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), animal[randomVal].getImgRes()));
        }

        return newBuilder;
    }

    public NotificationCompat.Builder generateNotificationBuilderObjExpandable(String[] str, Context context, boolean isTimeOut, boolean isLargeImage, boolean isProcessContinue, Intent intent){
        NotificationCompat.Builder newBuilder = generateNotificationBuilder(str, context, isTimeOut, false, isLargeImage, isProcessContinue, intent);

        int randomVal = (new Random()).nextInt(staticData.getListLength());

        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), animal[randomVal].getImgRes());
        NotificationCompat.BigPictureStyle imageBuild = new NotificationCompat.BigPictureStyle();

        imageBuild.bigPicture(largeIcon);
        imageBuild.bigLargeIcon(largeIcon).build();

        newBuilder.setStyle(imageBuild);

        return newBuilder;
    }
}
