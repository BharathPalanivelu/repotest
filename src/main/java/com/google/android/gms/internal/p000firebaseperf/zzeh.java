package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzeh  reason: invalid package */
final class zzeh {
    private static final zzef<?> zznp = new zzei();
    private static final zzef<?> zznq = zzgw();

    private static zzef<?> zzgw() {
        try {
            return (zzef) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzef<?> zzgx() {
        return zznp;
    }

    static zzef<?> zzgy() {
        zzef<?> zzef = zznq;
        if (zzef != null) {
            return zzef;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
