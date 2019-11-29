package com.google.android.gms.internal.icing;

final class zzes {
    private static final zzeq zzmc = zzcn();
    private static final zzeq zzmd = new zzet();

    static zzeq zzcl() {
        return zzmc;
    }

    static zzeq zzcm() {
        return zzmd;
    }

    private static zzeq zzcn() {
        try {
            return (zzeq) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
