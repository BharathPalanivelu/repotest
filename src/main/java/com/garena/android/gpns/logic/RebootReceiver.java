package com.garena.android.gpns.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.garena.android.gpns.GNotificationService;

public class RebootReceiver extends BroadcastReceiver {
    /* access modifiers changed from: protected */
    public boolean isServiceToReboot(Context context) {
        return false;
    }

    public final void onReceive(Context context, Intent intent) {
        if (isServiceToReboot(context)) {
            restartService(context);
        }
    }

    private void restartService(Context context) {
        if (!GNotificationService.isServiceRunning()) {
            Intent intent = new Intent(context, GNotificationService.class);
            intent.putExtra("ALARM_RESTART_SERVICE_DIED", true);
            context.startService(intent);
        }
    }
}
