package com.shopee.app.pushnotification;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.a.a;

public class DefaultNotificationReceiver extends a {
    public void onReceive(Context context, Intent intent) {
        startWakefulService(context, intent.setComponent(new ComponentName(context.getPackageName(), GPNIntentService.class.getName())));
    }
}
