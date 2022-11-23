package com.demo.labpracticals.notificationHandler;

import androidx.core.app.NotificationCompat;

public class NotificationObject {
    private final String channelName;
    private final NotificationCompat.Builder builder;
    private final boolean isTimed;
    private final boolean isLargeImage;
    private final boolean isIntentAttached;


    public NotificationObject(String channelName, NotificationCompat.Builder builder, boolean isTimed, boolean hasIntent, boolean isLargeImage) {
        this.channelName = channelName;
        this.builder = builder;
        this.isTimed = isTimed;
        this.isIntentAttached = hasIntent;
        this.isLargeImage = isLargeImage;
    }

    public String getChannelName() {
        return channelName;
    }

    public NotificationCompat.Builder getBuilder() {
        return builder;
    }

    public boolean isTimed() {
        return isTimed;
    }

    public boolean isLargeImage() {
        return isLargeImage;
    }

    public boolean isIntentAttached() {
        return isIntentAttached;
    }
}
