package com.shopee.app.pushnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import com.shopee.app.pushnotification.a.a.c;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18497a = new a();

    private a() {
    }

    public static final void a(Context context, NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= 26 && notificationManager != null) {
            try {
                notificationManager.createNotificationChannel(new NotificationChannel(a(0), "Default", 4));
                f18497a.a(context, notificationManager, a(1));
                NotificationChannel notificationChannel = new NotificationChannel(a(-1), "Silent", 4);
                notificationChannel.setSound((Uri) null, (AudioAttributes) null);
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.deleteNotificationChannel("SHOPEE_NOTIFY_RINGTONE_SHOPEEID");
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    public static final String a(int i) {
        if (i == -1) {
            return "SHOPEE_NOTIFY_SILENTLYID";
        }
        if (i == 0 || i != 1) {
            return "SHOPEE_NOTIFY_ID";
        }
        return a(c.a().a());
    }

    public static final String a(String str) {
        j.b(str, "soundId");
        return "SHOPEE_NOTIFY_RINGTONE_SHOPEEID" + str;
    }

    public static final void a(Context context, String str, String str2) {
        j.b(str, "oldChannelId");
        j.b(str2, "newChannelId");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Object obj = null;
                Object systemService = context != null ? context.getSystemService("notification") : null;
                if (systemService instanceof NotificationManager) {
                    obj = systemService;
                }
                NotificationManager notificationManager = (NotificationManager) obj;
                if (notificationManager != null) {
                    notificationManager.deleteNotificationChannel(str);
                }
                f18497a.a(context, notificationManager, str2);
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    private final void a(Context context, NotificationManager notificationManager, String str) {
        NotificationChannel notificationChannel = new NotificationChannel(str, "Custom", 4);
        notificationChannel.setSound(c.a(context), new AudioAttributes.Builder().setUsage(5).setContentType(2).build());
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
