package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfv  reason: invalid package */
final class zzfv {
    private static final zzft zzsx = zzii();
    private static final zzft zzsy = new zzfw();

    static zzft zzig() {
        return zzsx;
    }

    static zzft zzih() {
        return zzsy;
    }

    private static zzft zzii() {
        try {
            return (zzft) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
