package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzau;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

public final class h {
    public static Long a(HttpMessage httpMessage) {
        try {
            Header firstHeader = httpMessage.getFirstHeader("content-length");
            if (firstHeader != null) {
                return Long.valueOf(Long.parseLong(firstHeader.getValue()));
            }
            return null;
        } catch (NumberFormatException unused) {
            Log.d("FirebasePerformance", "The content-length value is not a valid number");
            return null;
        }
    }

    public static String a(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("content-type");
        if (firstHeader == null) {
            return null;
        }
        String value = firstHeader.getValue();
        if (value != null) {
            return value;
        }
        return null;
    }

    public static void a(zzau zzau) {
        if (!zzau.zzaf()) {
            zzau.zzah();
        }
        zzau.zzai();
    }
}
