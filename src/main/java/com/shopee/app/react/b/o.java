package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.garena.reactpush.c.d;
import com.garena.reactpush.d.f;
import com.shopee.app.react.a.a;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class o implements b<f> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18623a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f18624b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<a> f18625c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.garena.reactpush.b.b> f18626d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<com.garena.reactpush.e.c.a> f18627e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<d> f18628f;

    /* renamed from: a */
    public f get() {
        return (f) c.a(this.f18623a.a(this.f18624b.get(), this.f18625c.get(), this.f18626d.get(), this.f18627e.get(), this.f18628f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static f a(e eVar, OkHttpClient okHttpClient, a aVar, com.garena.reactpush.b.b bVar, com.garena.reactpush.e.c.a aVar2, d dVar) {
        return (f) c.a(eVar.a(okHttpClient, aVar, bVar, aVar2, dVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
