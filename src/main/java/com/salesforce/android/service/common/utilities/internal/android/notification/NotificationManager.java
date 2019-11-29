package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;

public interface NotificationManager {
    boolean areNotificationsEnabled();

    void cancel(int i);

    void cancel(String str, int i);

    void cancelAll();

    void createNotificationChannel(NotificationChannel notificationChannel);

    void notify(int i, Notification notification);

    void notify(String str, int i, Notification notification);
}
