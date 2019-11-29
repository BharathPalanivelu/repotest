package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.zzau;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import com.google.firebase.perf.internal.c;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public final class f implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Callback f14334a;

    /* renamed from: b  reason: collision with root package name */
    private final zzau f14335b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14336c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbg f14337d;

    public f(Callback callback, c cVar, zzbg zzbg, long j) {
        this.f14334a = callback;
        this.f14335b = zzau.zza(cVar);
        this.f14336c = j;
        this.f14337d = zzbg;
    }

    public final void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.url();
            if (url != null) {
                this.f14335b.zza(url.url().toString());
            }
            if (request.method() != null) {
                this.f14335b.zzb(request.method());
            }
        }
        this.f14335b.zzg(this.f14336c);
        this.f14335b.zzj(this.f14337d.zzcs());
        h.a(this.f14335b);
        this.f14334a.onFailure(call, iOException);
    }

    public final void onResponse(Call call, Response response) throws IOException {
        Response response2 = response;
        FirebasePerfOkHttpClient.a(response2, this.f14335b, this.f14336c, this.f14337d.zzcs());
        this.f14334a.onResponse(call, response);
    }
}
