package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Locale;
import java.util.UUID;

class x {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32631a = "com.threatmetrix.TrustDefenderMobile.x";

    x() {
    }

    static String a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ThreatMetrixMobileSDK", 0);
        String string = sharedPreferences.getString("ThreatMetrixMobileSDK", (String) null);
        if (string != null) {
            return string;
        }
        Log.d(f32631a, "Found nothing in shared prefs, generating GUID");
        String lowerCase = UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.US);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("ThreatMetrixMobileSDK", lowerCase);
        edit.commit();
        return lowerCase;
    }

    static String b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null && !string.equals("9774d56d682e549c") && string.length() >= 15) {
            return string;
        }
        Log.d(f32631a, "ANDROID_ID contains nothing useful");
        return null;
    }

    static String c(Context context) {
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            String str = f32631a;
            Log.d(str, "imei: " + deviceId);
            return deviceId;
        } catch (SecurityException e2) {
            Log.d(f32631a, "imei failed", e2);
            return "";
        }
    }

    static boolean a() {
        String str = Build.SERIAL;
        return str != null && (str.equals("unknown") || str.equals("1234567890ABCDEF"));
    }

    private static String a(String str, String str2, String str3) {
        String str4 = Build.SERIAL == null ? "" : Build.SERIAL;
        if (str3 != null && !str3.isEmpty() && !str3.equals("000000000000000")) {
            return str4 + str3;
        } else if (str != null) {
            return str4 + str;
        } else {
            return str4 + str2;
        }
    }

    static String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 32) {
            return str;
        }
        if (str.length() >= 32) {
            return v.b(str);
        }
        return str + v.b(str).substring(0, 32 - str.length());
    }

    static String a(String str, boolean z) {
        if (z) {
            str = v.b(str);
        }
        String str2 = f32631a;
        Log.d(str2, "using generated ID for LSC:" + str);
        return a(str);
    }

    static String b(String str, boolean z) {
        if (str != null) {
            if (z) {
                str = v.b(str);
            }
            String str2 = f32631a;
            Log.d(str2, "using ANDROID_ID for TPC:" + str);
        }
        return a(str);
    }

    static String a(Context context, String str, String str2, String str3, boolean z) {
        String a2 = a(str, str2, str3);
        if (z) {
            a2 = v.b(a2);
        }
        return a(v.b(a2));
    }
}
