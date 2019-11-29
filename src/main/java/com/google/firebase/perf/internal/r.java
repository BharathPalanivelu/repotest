package com.google.firebase.perf.internal;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.p000firebaseperf.zzax;
import com.google.android.gms.internal.p000firebaseperf.zzaz;
import com.google.android.gms.internal.p000firebaseperf.zzbk;
import com.google.android.gms.internal.p000firebaseperf.zzcn;
import com.google.android.gms.internal.p000firebaseperf.zzcr;
import com.google.android.gms.internal.p000firebaseperf.zzcv;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final long f14270a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14271b;

    /* renamed from: c  reason: collision with root package name */
    private t f14272c;

    /* renamed from: d  reason: collision with root package name */
    private t f14273d;

    /* renamed from: e  reason: collision with root package name */
    private final RemoteConfigManager f14274e;

    public r(Context context, long j, long j2) {
        this(100, 500, new zzax(), a(Settings.Secure.getString(context.getContentResolver(), "android_id")), RemoteConfigManager.zzbz());
        this.f14271b = zzbk.zzg(context);
    }

    private r(long j, long j2, zzax zzax, long j3, RemoteConfigManager remoteConfigManager) {
        this.f14271b = false;
        this.f14272c = null;
        this.f14273d = null;
        this.f14270a = j3;
        this.f14274e = remoteConfigManager;
        zzax zzax2 = zzax;
        RemoteConfigManager remoteConfigManager2 = remoteConfigManager;
        this.f14272c = new t(100, 500, zzax2, remoteConfigManager2, u.TRACE, this.f14271b);
        this.f14273d = new t(100, 500, zzax2, remoteConfigManager2, u.NETWORK, this.f14271b);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(zzcn zzcn) {
        if (zzcn.zzfc()) {
            if (!(this.f14270a <= ((long) (this.f14274e.zza("trace_sampling_rate", 100.0f) * 1000000.0f))) && !a(zzcn.zzfd().zzes())) {
                return false;
            }
        }
        if (zzcn.zzfe()) {
            if (!(this.f14270a <= ((long) (this.f14274e.zza("network_sampling_rate", 100.0f) * 1000000.0f))) && !a(zzcn.zzff().zzes())) {
                return false;
            }
        }
        if (!((!zzcn.zzfc() || ((!zzcn.zzfd().getName().equals(zzaz.FOREGROUND_TRACE_NAME.toString()) && !zzcn.zzfd().getName().equals(zzaz.BACKGROUND_TRACE_NAME.toString())) || zzcn.zzfd().zzfn() <= 0)) && !zzcn.zzfg())) {
            return true;
        }
        if (zzcn.zzfe()) {
            return this.f14273d.a(zzcn);
        }
        if (zzcn.zzfc()) {
            return this.f14272c.a(zzcn);
        }
        return false;
    }

    private static boolean a(List<zzcr> list) {
        if (list.size() <= 0 || list.get(0).zzfk() <= 0 || list.get(0).zzn(0) != zzcv.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    private static long a(String str) {
        int i;
        try {
            i = zzbk.zza(MessageDigest.getInstance(Hash.ALGORITHM_SHA1).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            i = zzbk.zza(str.getBytes());
        }
        return (((((long) i) % 100000000) + 100000000) % 100000000) + 1;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.f14272c.a(z);
        this.f14273d.a(z);
    }
}
