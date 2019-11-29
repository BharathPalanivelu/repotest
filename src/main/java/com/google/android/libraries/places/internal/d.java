package com.google.android.libraries.places.internal;

import com.google.android.gms.location.FusedLocationProviderClient;
import java.util.concurrent.TimeUnit;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final long f12427a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b  reason: collision with root package name */
    public static final long f12428b = TimeUnit.SECONDS.toNanos(24);

    /* renamed from: c  reason: collision with root package name */
    public static final long f12429c = TimeUnit.SECONDS.toMillis(59);

    /* renamed from: d  reason: collision with root package name */
    public final FusedLocationProviderClient f12430d;

    /* renamed from: e  reason: collision with root package name */
    public final fv f12431e;

    public d(FusedLocationProviderClient fusedLocationProviderClient, fv fvVar) {
        this.f12430d = fusedLocationProviderClient;
        this.f12431e = fvVar;
    }
}
