package com.google.firebase.perf.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzbi;
import com.google.android.gms.internal.p000firebaseperf.zzci;
import java.net.URI;

final class l extends q {

    /* renamed from: a  reason: collision with root package name */
    private final zzci f14256a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14257b;

    l(zzci zzci, Context context) {
        this.f14257b = context;
        this.f14256a = zzci;
    }

    private static boolean a(long j) {
        return j >= 0;
    }

    private static boolean b(long j) {
        return j >= 0;
    }

    public final boolean a() {
        boolean z;
        if (c(this.f14256a.getUrl())) {
            String valueOf = String.valueOf(this.f14256a.getUrl());
            Log.i("FirebasePerformance", valueOf.length() != 0 ? "URL is missing:".concat(valueOf) : new String("URL is missing:"));
            return false;
        }
        URI b2 = b(this.f14256a.getUrl());
        if (b2 == null) {
            Log.i("FirebasePerformance", "URL cannot be parsed");
            return false;
        }
        Context context = this.f14257b;
        if (b2 == null) {
            z = false;
        } else {
            z = zzbi.zza(b2, context);
        }
        if (!z) {
            String valueOf2 = String.valueOf(b2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 26);
            sb.append("URL fails whitelist rule: ");
            sb.append(valueOf2);
            Log.i("FirebasePerformance", sb.toString());
            return false;
        }
        String host = b2.getHost();
        if (!(host != null && !c(host) && host.length() <= 255)) {
            Log.i("FirebasePerformance", "URL host is null or invalid");
            return false;
        }
        String scheme = b2.getScheme();
        if (!(scheme != null && ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)))) {
            Log.i("FirebasePerformance", "URL scheme is null or invalid");
            return false;
        }
        if (!(b2.getUserInfo() == null)) {
            Log.i("FirebasePerformance", "URL user info is null");
            return false;
        }
        int port = b2.getPort();
        if (!(port == -1 || port > 0)) {
            Log.i("FirebasePerformance", "URL port is less than or equal to 0");
            return false;
        }
        zzci.zzb zzed = this.f14256a.zzec() ? this.f14256a.zzed() : null;
        if (!((zzed == null || zzed == zzci.zzb.HTTP_METHOD_UNKNOWN) ? false : true)) {
            String valueOf3 = String.valueOf(this.f14256a.zzed());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 32);
            sb2.append("HTTP Method is null or invalid: ");
            sb2.append(valueOf3);
            Log.i("FirebasePerformance", sb2.toString());
            return false;
        }
        if (this.f14256a.zzaf()) {
            if (!(this.f14256a.zzei() > 0)) {
                int zzei = this.f14256a.zzei();
                StringBuilder sb3 = new StringBuilder(49);
                sb3.append("HTTP ResponseCode is a negative value:");
                sb3.append(zzei);
                Log.i("FirebasePerformance", sb3.toString());
                return false;
            }
        }
        if (this.f14256a.zzee() && !b(this.f14256a.zzef())) {
            long zzef = this.f14256a.zzef();
            StringBuilder sb4 = new StringBuilder(56);
            sb4.append("Request Payload is a negative value:");
            sb4.append(zzef);
            Log.i("FirebasePerformance", sb4.toString());
            return false;
        } else if (this.f14256a.zzeg() && !b(this.f14256a.zzeh())) {
            long zzeh = this.f14256a.zzeh();
            StringBuilder sb5 = new StringBuilder(57);
            sb5.append("Response Payload is a negative value:");
            sb5.append(zzeh);
            Log.i("FirebasePerformance", sb5.toString());
            return false;
        } else if (!this.f14256a.zzek() || this.f14256a.zzel() <= 0) {
            long zzel = this.f14256a.zzel();
            StringBuilder sb6 = new StringBuilder(84);
            sb6.append("Start time of the request is null, or zero, or a negative value:");
            sb6.append(zzel);
            Log.i("FirebasePerformance", sb6.toString());
            return false;
        } else if (this.f14256a.zzem() && !a(this.f14256a.zzen())) {
            long zzen = this.f14256a.zzen();
            StringBuilder sb7 = new StringBuilder(69);
            sb7.append("Time to complete the request is a negative value:");
            sb7.append(zzen);
            Log.i("FirebasePerformance", sb7.toString());
            return false;
        } else if (this.f14256a.zzeo() && !a(this.f14256a.zzep())) {
            long zzep = this.f14256a.zzep();
            StringBuilder sb8 = new StringBuilder(112);
            sb8.append("Time from the start of the request to the start of the response is null or a negative value:");
            sb8.append(zzep);
            Log.i("FirebasePerformance", sb8.toString());
            return false;
        } else if (!this.f14256a.zzeq() || this.f14256a.zzer() <= 0) {
            long zzer = this.f14256a.zzer();
            StringBuilder sb9 = new StringBuilder(108);
            sb9.append("Time from the start of the request to the end of the response is null, negative or zero:");
            sb9.append(zzer);
            Log.i("FirebasePerformance", sb9.toString());
            return false;
        } else if (this.f14256a.zzaf()) {
            return true;
        } else {
            Log.i("FirebasePerformance", "Did not receive a HTTP Response Code");
            return false;
        }
    }

    private static URI b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e2) {
            Log.w("FirebasePerformance", "getResultUrl throws exception", e2);
            return null;
        }
    }

    private static boolean c(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }
}
