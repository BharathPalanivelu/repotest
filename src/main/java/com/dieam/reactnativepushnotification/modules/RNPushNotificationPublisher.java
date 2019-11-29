package com.dieam.reactnativepushnotification.modules;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RNPushNotificationPublisher extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("notificationId", 0);
        long currentTimeMillis = System.currentTimeMillis();
        Log.i(RNPushNotification.LOG_TAG, "NotificationPublisher: Prepare To Publish: " + intExtra + ", Now Time: " + currentTimeMillis);
        new b((Application) context.getApplicationContext()).c(intent.getExtras());
    }
}
