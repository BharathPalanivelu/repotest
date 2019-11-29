package com.shopee.web.sdk.a;

import android.os.Handler;
import android.os.Looper;
import java.net.URLEncoder;
import org.slf4j.Marker;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f30467a = new Handler(Looper.getMainLooper());

    public static String a(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            str2 = URLEncoder.encode(str);
        }
        return str2.replace(Marker.ANY_NON_NULL_MARKER, "%20");
    }
}
