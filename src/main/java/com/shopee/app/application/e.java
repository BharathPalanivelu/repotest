package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ae;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class e implements b<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15877a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ae> f15878b;

    public e(c cVar, Provider<ae> provider) {
        this.f15877a = cVar;
        this.f15878b = provider;
    }

    /* renamed from: a */
    public OkHttpClient get() {
        return (OkHttpClient) c.a(this.f15877a.a(this.f15878b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static e a(c cVar, Provider<ae> provider) {
        return new e(cVar, provider);
    }
}
