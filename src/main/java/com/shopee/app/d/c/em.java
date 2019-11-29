package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.b.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.m;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class em implements b<el> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16929a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<m> f16930b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ba> f16931c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<af> f16932d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16933e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<UserInfo> f16934f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<a> f16935g;

    /* renamed from: a */
    public el get() {
        return new el(this.f16929a.get(), this.f16930b.get(), this.f16931c.get(), this.f16932d.get(), this.f16933e.get(), this.f16934f.get(), this.f16935g.get());
    }

    public static el a(n nVar, m mVar, ba baVar, af afVar, SettingConfigStore settingConfigStore, UserInfo userInfo, a aVar) {
        return new el(nVar, mVar, baVar, afVar, settingConfigStore, userInfo, aVar);
    }
}
