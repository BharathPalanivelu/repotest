package com.shopee.app.g;

import android.content.Context;
import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.tracking.f;
import com.shopee.app.util.bc;
import javax.inject.Provider;

public final class j implements b<h> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f17556a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<i> f17557b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bc> f17558c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SettingConfigStore> f17559d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<f> f17560e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<UserInfo> f17561f;

    /* renamed from: a */
    public h get() {
        h hVar = new h(this.f17556a.get());
        k.a(hVar, this.f17557b.get());
        k.a(hVar, this.f17558c.get());
        k.a(hVar, this.f17559d.get());
        k.a(hVar, this.f17560e.get());
        k.a(hVar, this.f17561f.get());
        return hVar;
    }

    public static h a(Context context) {
        return new h(context);
    }
}
