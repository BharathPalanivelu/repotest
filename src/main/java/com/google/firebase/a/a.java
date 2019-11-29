package com.google.firebase.a;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f6748a;

    /* renamed from: b  reason: collision with root package name */
    private final T f6749b;

    @KeepForSdk
    public Class<T> a() {
        return this.f6748a;
    }

    @KeepForSdk
    public T b() {
        return this.f6749b;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", new Object[]{this.f6748a, this.f6749b});
    }
}
