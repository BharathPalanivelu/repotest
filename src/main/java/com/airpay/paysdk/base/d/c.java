package com.airpay.paysdk.base.d;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class c {
    public static int a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static long b() {
        return System.currentTimeMillis();
    }

    public static String a(long j) {
        return a(j, (String) null);
    }

    public static String a(long j, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        if (!TextUtils.isEmpty(str)) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
        }
        return simpleDateFormat.format(Long.valueOf(j));
    }
}
