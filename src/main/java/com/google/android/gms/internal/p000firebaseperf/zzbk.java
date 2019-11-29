package com.google.android.gms.internal.p000firebaseperf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbk  reason: invalid package */
public final class zzbk {
    private static Boolean zzib;

    public static int zza(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4 && i < bArr.length) {
            i2 |= (bArr[i] & 255) << (i << 3);
            i++;
        }
        return i2;
    }

    public static boolean zzg(Context context) {
        Boolean bool = zzib;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            zzib = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.d("isEnabled", valueOf2.length() != 0 ? "No perf logcat meta data found ".concat(valueOf2) : new String("No perf logcat meta data found "));
            return false;
        }
    }
}
