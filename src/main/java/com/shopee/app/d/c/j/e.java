package com.shopee.app.d.c.j;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.be;
import com.shopee.app.util.datapoint.a.a;
import com.shopee.app.util.datapoint.a.c;
import com.shopee.app.util.datapoint.a.d;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import javax.inject.Provider;

public final class e implements b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UserInfo> f17077a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<q> f17078b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f17079c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<n> f17080d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<aa> f17081e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<be> f17082f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<a> f17083g;
    private final Provider<d> h;
    private final Provider<c> i;
    private final Provider<com.shopee.app.util.datapoint.a.b> j;

    public e(Provider<UserInfo> provider, Provider<q> provider2, Provider<SettingConfigStore> provider3, Provider<n> provider4, Provider<aa> provider5, Provider<be> provider6, Provider<a> provider7, Provider<d> provider8, Provider<c> provider9, Provider<com.shopee.app.util.datapoint.a.b> provider10) {
        this.f17077a = provider;
        this.f17078b = provider2;
        this.f17079c = provider3;
        this.f17080d = provider4;
        this.f17081e = provider5;
        this.f17082f = provider6;
        this.f17083g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    /* renamed from: a */
    public d get() {
        return new d(this.f17077a.get(), this.f17078b.get(), this.f17079c.get(), this.f17080d.get(), this.f17081e.get(), this.f17082f.get(), this.f17083g.get(), this.h.get(), this.i.get(), this.j.get());
    }

    public static e a(Provider<UserInfo> provider, Provider<q> provider2, Provider<SettingConfigStore> provider3, Provider<n> provider4, Provider<aa> provider5, Provider<be> provider6, Provider<a> provider7, Provider<d> provider8, Provider<c> provider9, Provider<com.shopee.app.util.datapoint.a.b> provider10) {
        return new e(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }
}
