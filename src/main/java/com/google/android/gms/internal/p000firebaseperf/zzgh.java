package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgh  reason: invalid package */
final class zzgh {
    private static final zzgf zzts = zzip();
    private static final zzgf zztt = new zzgi();

    static zzgf zzin() {
        return zzts;
    }

    static zzgf zzio() {
        return zztt;
    }

    private static zzgf zzip() {
        try {
            return (zzgf) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
