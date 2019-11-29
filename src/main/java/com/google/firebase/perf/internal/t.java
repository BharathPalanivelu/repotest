package com.google.firebase.perf.internal;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzax;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import com.google.android.gms.internal.p000firebaseperf.zzcn;
import java.util.concurrent.TimeUnit;

final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final long f14275a = TimeUnit.MINUTES.toMicros(1);

    /* renamed from: b  reason: collision with root package name */
    private long f14276b;

    /* renamed from: c  reason: collision with root package name */
    private long f14277c;

    /* renamed from: d  reason: collision with root package name */
    private zzbg f14278d = new zzbg();

    /* renamed from: e  reason: collision with root package name */
    private long f14279e;

    /* renamed from: f  reason: collision with root package name */
    private final zzax f14280f;

    /* renamed from: g  reason: collision with root package name */
    private long f14281g;
    private long h;
    private long i;
    private long j;
    private final boolean k;

    t(long j2, long j3, zzax zzax, RemoteConfigManager remoteConfigManager, u uVar, boolean z) {
        this.f14280f = zzax;
        this.f14276b = j3;
        this.f14277c = j2;
        this.f14279e = j3;
        long zzc = remoteConfigManager.zzc(uVar.zzbv(), 0);
        zzc = zzc == 0 ? (long) uVar.zzbr() : zzc;
        long zzc2 = remoteConfigManager.zzc(uVar.zzbw(), (long) uVar.zzbs());
        this.f14281g = zzc2 / zzc;
        this.h = zzc2;
        if (!(this.h == ((long) uVar.zzbs()) && this.f14281g == ((long) (uVar.zzbs() / uVar.zzbr())))) {
            Log.d("FirebasePerformance", String.format("Foreground %s logging rate:%d, burst capacity:%d", new Object[]{uVar.toString(), Long.valueOf(this.f14281g), Long.valueOf(this.h)}));
        }
        long zzc3 = remoteConfigManager.zzc(uVar.zzbx(), 0);
        zzc3 = zzc3 == 0 ? (long) uVar.zzbt() : zzc3;
        long zzc4 = remoteConfigManager.zzc(uVar.zzby(), (long) uVar.zzbu());
        this.i = zzc4 / zzc3;
        this.j = zzc4;
        if (!(this.j == ((long) uVar.zzbu()) && this.i == ((long) (uVar.zzbu() / uVar.zzbt())))) {
            Log.d("FirebasePerformance", String.format("Background %s logging rate:%d, capacity:%d", new Object[]{uVar.toString(), Long.valueOf(this.i), Long.valueOf(this.j)}));
        }
        this.k = z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(zzcn zzcn) {
        zzbg zzbg = new zzbg();
        this.f14279e = Math.min(this.f14279e + Math.max(0, (this.f14278d.zza(zzbg) * this.f14277c) / f14275a), this.f14276b);
        if (this.f14279e > 0) {
            this.f14279e--;
            this.f14278d = zzbg;
            return true;
        }
        if (this.k) {
            Log.w("FirebasePerformance", "Exceeded log rate limit, dropping the log.");
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.f14277c = z ? this.f14281g : this.i;
        this.f14276b = z ? this.h : this.j;
    }
}
