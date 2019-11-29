package com.garena.android.gpns.utility;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.garena.android.gpns.utility.CONSTANT;
import tencent.tls.platform.SigType;

public final class AlarmUtil {
    public static void scheduleShortPing(Context context) {
        PendingIntent initIntent = initIntent(context, 0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = (long) CONSTANT.TIME.MIN_1;
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(3, elapsedRealtime + j, j, initIntent);
    }

    public static void scheduleLongPing(Context context) {
        PendingIntent initIntent = initIntent(context, 1);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = (long) CONSTANT.TIME.MIN_5;
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(2, elapsedRealtime + j, j, initIntent);
    }

    public static void scheduleWakeConnect(Context context, int i) {
        ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + ((long) i), initIntent(context, 2));
    }

    public static void cancelShortPing(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(initIntent(context, 0));
    }

    public static void cancelLongPing(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(initIntent(context, 1));
    }

    private static PendingIntent initIntent(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(CONSTANT.ALARM.KEY_ALARM_TYPE, i);
        Intent intent = new Intent(CONSTANT.ACTION.ACTION_ALARM());
        intent.putExtra(CONSTANT.ALARM.DATA_BUNDLE, bundle);
        return PendingIntent.getBroadcast(context, i, intent, SigType.TLS);
    }

    private AlarmUtil() {
    }

    public static void cancelWakeConnect(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(initIntent(context, 2));
    }
}
