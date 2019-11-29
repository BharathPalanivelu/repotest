package com.beetalk.sdk.e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.beetalk.sdk.f;
import java.util.Locale;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static String f5404a = "SG";

    /* renamed from: b  reason: collision with root package name */
    static String f5405b = "en";

    public static String a(Context context) {
        String a2 = d.a().a(context);
        return TextUtils.isEmpty(a2) ? a() : a2;
    }

    public static String a() {
        String country = Locale.getDefault() != null ? Locale.getDefault().getCountry() : f5404a;
        if (country != null && country.length() > 2) {
            country = country.substring(0, 2);
        }
        if (country == null || country.length() != 2) {
            return f5404a;
        }
        return country.toUpperCase();
    }

    public static String b() {
        String language = Locale.getDefault() != null ? Locale.getDefault().getLanguage() : f5405b;
        if (language != null && language.length() > 2) {
            language = language.substring(0, 2);
        }
        if (language == null || language.length() != 2) {
            return f5404a;
        }
        return language.toLowerCase();
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase() : "";
    }

    public static Locale c(Context context) {
        return new Locale(b(), a(context));
    }

    public static Locale c() {
        if (f.a() != null) {
            return c(f.a());
        }
        return new Locale(b(), a());
    }
}
