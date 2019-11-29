package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.l;

public class SalesforceNotificationManager implements NotificationManager {
    private NotificationManager mNotificationManager;
    private l mNotificationManagerCompat;

    public static SalesforceNotificationManager from(Context context) {
        return new SalesforceNotificationManager(context);
    }

    private SalesforceNotificationManager(Context context) {
        this.mNotificationManagerCompat = l.a(context);
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    public void cancel(int i) {
        this.mNotificationManagerCompat.a(i);
    }

    public void cancel(String str, int i) {
        this.mNotificationManagerCompat.a(str, i);
    }

    public void cancelAll() {
        this.mNotificationManagerCompat.a();
    }

    public void notify(int i, Notification notification) {
        this.mNotificationManagerCompat.a(i, notification);
    }

    public void notify(String str, int i, Notification notification) {
        this.mNotificationManagerCompat.a(str, i, notification);
    }

    public boolean areNotificationsEnabled() {
        return this.mNotificationManagerCompat.b();
    }

    public void createNotificationChannel(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannel(notificationChannel.asAndroidNotificationChannel());
        }
    }
}
