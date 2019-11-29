package com.dieam.reactnativepushnotification.modules;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Set;

public class RNPushNotificationBootEventReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i(RNPushNotification.LOG_TAG, "RNPushNotificationBootEventReceiver loading scheduled notifications");
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("rn_push_notification", 0);
            Set<String> keySet = sharedPreferences.getAll().keySet();
            b bVar = new b((Application) context.getApplicationContext());
            for (String next : keySet) {
                try {
                    String string = sharedPreferences.getString(next, (String) null);
                    if (string != null) {
                        a a2 = a.a(string);
                        if (a2.d() < ((double) System.currentTimeMillis())) {
                            Log.i(RNPushNotification.LOG_TAG, "RNPushNotificationBootEventReceiver: Showing notification for " + a2.c());
                            bVar.c(a2.a());
                        } else {
                            Log.i(RNPushNotification.LOG_TAG, "RNPushNotificationBootEventReceiver: Scheduling notification for " + a2.c());
                            bVar.b(a2.a());
                        }
                    }
                } catch (Exception e2) {
                    Log.e(RNPushNotification.LOG_TAG, "Problem with boot receiver loading notification " + next, e2);
                }
            }
        }
    }
}
