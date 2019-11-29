package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.b.a;
import java.util.Set;

@KeepForSdk
public interface e {
    @KeepForSdk
    <T> T a(Class<T> cls);

    @KeepForSdk
    <T> Set<T> b(Class<T> cls);

    @KeepForSdk
    <T> a<T> c(Class<T> cls);

    @KeepForSdk
    <T> a<Set<T>> d(Class<T> cls);
}
