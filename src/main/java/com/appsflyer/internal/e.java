package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class e {

    /* renamed from: ॱ  reason: contains not printable characters */
    private IntentFilter f165 = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    static final class a {

        /* renamed from: ˋ  reason: contains not printable characters */
        static final e f166 = new e();
    }

    e() {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static e m146() {
        return a.f166;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final c m147(Context context) {
        String str = null;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, this.f165);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? FacebookRequestErrorClassification.KEY_OTHER : "wireless" : "usb" : "ac";
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra("level", -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f2 = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable unused) {
        }
        return new c(f2, str);
    }

    public static final class c {

        /* renamed from: ˎ  reason: contains not printable characters */
        public final String f167;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final float f168;

        c(float f2, String str) {
            this.f168 = f2;
            this.f167 = str;
        }

        c() {
        }
    }
}
