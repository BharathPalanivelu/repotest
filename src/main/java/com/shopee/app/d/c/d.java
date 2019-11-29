package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.r;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class d implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16758a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<c> f16759b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ah> f16760c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<r> f16761d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<bh> f16762e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ao> f16763f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16764g;

    /* renamed from: a */
    public c get() {
        return new c(this.f16758a.get(), this.f16759b.get(), this.f16760c.get(), this.f16761d.get(), this.f16762e.get(), this.f16763f.get(), this.f16764g.get());
    }

    public static c a(n nVar, c cVar, ah ahVar, r rVar, bh bhVar, ao aoVar, SettingConfigStore settingConfigStore) {
        return new c(nVar, cVar, ahVar, rVar, bhVar, aoVar, settingConfigStore);
    }
}
