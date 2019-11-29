package com.google.android.gms.internal.icing;

final class zzdg {
    private static final zzde<?> zzgx = new zzdh();
    private static final zzde<?> zzgy = zzba();

    private static zzde<?> zzba() {
        try {
            return (zzde) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzde<?> zzbb() {
        return zzgx;
    }

    static zzde<?> zzbc() {
        zzde<?> zzde = zzgy;
        if (zzde != null) {
            return zzde;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
