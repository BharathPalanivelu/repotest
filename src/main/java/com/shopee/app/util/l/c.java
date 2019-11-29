package com.shopee.app.util.l;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.ak;
import com.shopee.navigator.e;
import javax.inject.Provider;

public final class c implements b<b> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ak> f26441a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e> f26442b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserInfo> f26443c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UploadManager> f26444d;

    public c(Provider<ak> provider, Provider<e> provider2, Provider<UserInfo> provider3, Provider<UploadManager> provider4) {
        this.f26441a = provider;
        this.f26442b = provider2;
        this.f26443c = provider3;
        this.f26444d = provider4;
    }

    /* renamed from: a */
    public b get() {
        return new b(this.f26441a.get(), this.f26442b.get(), this.f26443c.get(), this.f26444d.get());
    }

    public static c a(Provider<ak> provider, Provider<e> provider2, Provider<UserInfo> provider3, Provider<UploadManager> provider4) {
        return new c(provider, provider2, provider3, provider4);
    }
}
