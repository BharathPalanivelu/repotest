package com.google.android.gms.internal.icing;

final class zzfe {
    private static final zzfc zzmx = zzcu();
    private static final zzfc zzmy = new zzff();

    static zzfc zzcs() {
        return zzmx;
    }

    static zzfc zzct() {
        return zzmy;
    }

    private static zzfc zzcu() {
        try {
            return (zzfc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
