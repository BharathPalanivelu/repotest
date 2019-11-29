package com.google.android.gms.internal.p000firebaseperf;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.net.URI;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbi  reason: invalid package */
public final class zzbi {
    private static String[] zzia;

    public static boolean zza(URI uri, Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier <= 0) {
            return true;
        }
        Log.i("FirebasePerformance", "Detected domain whitelist, only whitelisted domains will be measured.");
        if (zzia == null) {
            zzia = resources.getStringArray(identifier);
        }
        for (String str : zzia) {
            String host = uri.getHost();
            if (host == null || host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
