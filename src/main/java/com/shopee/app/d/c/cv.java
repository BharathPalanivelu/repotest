package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.p;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cv implements b<cu> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16739a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16740b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<p> f16741c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserInfo> f16742d;

    /* renamed from: a */
    public cu get() {
        return new cu(this.f16739a.get(), this.f16740b.get(), this.f16741c.get(), this.f16742d.get());
    }

    public static cu a(n nVar, SettingConfigStore settingConfigStore, p pVar, UserInfo userInfo) {
        return new cu(nVar, settingConfigStore, pVar, userInfo);
    }
}
