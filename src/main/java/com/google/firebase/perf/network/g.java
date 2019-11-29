package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.zzau;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public final class g<T> implements ResponseHandler<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ResponseHandler<? extends T> f14338a;

    /* renamed from: b  reason: collision with root package name */
    private final zzbg f14339b;

    /* renamed from: c  reason: collision with root package name */
    private final zzau f14340c;

    public g(ResponseHandler<? extends T> responseHandler, zzbg zzbg, zzau zzau) {
        this.f14338a = responseHandler;
        this.f14339b = zzbg;
        this.f14340c = zzau;
    }

    public final T handleResponse(HttpResponse httpResponse) throws IOException {
        this.f14340c.zzj(this.f14339b.zzcs());
        this.f14340c.zzb(httpResponse.getStatusLine().getStatusCode());
        Long a2 = h.a((HttpMessage) httpResponse);
        if (a2 != null) {
            this.f14340c.zzk(a2.longValue());
        }
        String a3 = h.a(httpResponse);
        if (a3 != null) {
            this.f14340c.zzc(a3);
        }
        this.f14340c.zzai();
        return this.f14338a.handleResponse(httpResponse);
    }
}
