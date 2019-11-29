package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfa  reason: invalid package */
public class zzfa extends IOException {
    private zzga zzrl = null;

    public zzfa(String str) {
        super(str);
    }

    static zzez zzht() {
        return new zzez("Protocol message tag had invalid wire type.");
    }
}
