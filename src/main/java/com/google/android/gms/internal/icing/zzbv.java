package com.google.android.gms.internal.icing;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public final class zzbv {
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
