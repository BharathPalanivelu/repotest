package com.shopee.app.react;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.util.e.a;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f18559a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingConfigStore> f18560b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserInfo> f18561c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<aa> f18562d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<g> f18563e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<a> f18564f;

    public b(Provider<n> provider, Provider<SettingConfigStore> provider2, Provider<UserInfo> provider3, Provider<aa> provider4, Provider<g> provider5, Provider<a> provider6) {
        this.f18559a = provider;
        this.f18560b = provider2;
        this.f18561c = provider3;
        this.f18562d = provider4;
        this.f18563e = provider5;
        this.f18564f = provider6;
    }

    /* renamed from: a */
    public a get() {
        return new a(this.f18559a.get(), this.f18560b.get(), this.f18561c.get(), this.f18562d.get(), this.f18563e.get(), this.f18564f.get());
    }

    public static b a(Provider<n> provider, Provider<SettingConfigStore> provider2, Provider<UserInfo> provider3, Provider<aa> provider4, Provider<g> provider5, Provider<a> provider6) {
        return new b(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
