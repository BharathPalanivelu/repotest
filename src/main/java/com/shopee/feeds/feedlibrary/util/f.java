package com.shopee.feeds.feedlibrary.util;

import com.facebook.appevents.AppEventsConstants;
import java.text.SimpleDateFormat;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f28306a = new SimpleDateFormat("mm:ss");

    public static String a(long j) {
        if (j > 60000) {
            return b(j);
        }
        long j2 = j / 60000;
        long round = (long) Math.round(((float) (j % 60000)) / 1000.0f);
        String str = "";
        if (j2 < 10) {
            str = str + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String str2 = str + j2 + ":";
        if (round < 10) {
            str2 = str2 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        return str2 + round;
    }

    public static String b(long j) {
        try {
            return f28306a.format(Long.valueOf(j));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "0:00";
        }
    }
}
