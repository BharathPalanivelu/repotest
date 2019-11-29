package com.beetalk.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.garena.d.a;
import java.util.HashMap;
import java.util.TimeZone;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f5406a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, String> f5407b;

    public static d a() {
        if (f5406a == null) {
            synchronized (d.class) {
                if (f5406a == null) {
                    f5406a = new d();
                }
            }
        }
        return f5406a;
    }

    private HashMap<String, String> b(Context context) {
        if (this.f5407b == null) {
            String[] stringArray = context.getResources().getStringArray(a.C0130a.regions);
            this.f5407b = new HashMap<>();
            for (String split : stringArray) {
                String[] split2 = split.split(":");
                this.f5407b.put(split2[0], split2[1]);
            }
        }
        return this.f5407b;
    }

    private String c(Context context) {
        if (context == null) {
            return "";
        }
        String[] split = TimeZone.getDefault().getID().toLowerCase().split(Constants.URL_PATH_DELIMITER);
        if (split.length == 2) {
            return b(context).get(split[1]);
        }
        return "";
    }

    public String a(Context context) {
        if (context == null) {
            return "";
        }
        String b2 = c.b(context);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        return c(context);
    }
}
