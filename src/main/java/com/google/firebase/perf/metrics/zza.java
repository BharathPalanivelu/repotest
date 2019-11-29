package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f14305a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicLong f14306b;

    public zza(String str) {
        this.f14305a = str;
        this.f14306b = new AtomicLong(0);
    }

    public int describeContents() {
        return 0;
    }

    public final void a(long j) {
        this.f14306b.addAndGet(j);
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f14305a;
    }

    /* access modifiers changed from: package-private */
    public final long b() {
        return this.f14306b.get();
    }

    /* access modifiers changed from: package-private */
    public final void b(long j) {
        this.f14306b.set(j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14305a);
        parcel.writeLong(this.f14306b.get());
    }

    private zza(Parcel parcel) {
        this.f14305a = parcel.readString();
        this.f14306b = new AtomicLong(parcel.readLong());
    }

    /* synthetic */ zza(Parcel parcel, a aVar) {
        this(parcel);
    }
}
