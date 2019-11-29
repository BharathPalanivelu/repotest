package com.google.android.libraries.places.internal;

final class ko {

    /* renamed from: a  reason: collision with root package name */
    public static final kn<?> f12882a = new kn<>((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static final kn<?> f12883b = b();

    private static kn<?> b() {
        try {
            return (kn) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static kn<?> a() {
        kn<?> knVar = f12883b;
        if (knVar != null) {
            return knVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
