package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.m;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.f.a;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class dw implements b<dv> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16862a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ba> f16863b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UploadStore> f16864c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<a> f16865d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<be> f16866e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<UploadManager> f16867f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<m> f16868g;
    private final Provider<af> h;
    private final Provider<SettingConfigStore> i;
    private final Provider<UserInfo> j;
    private final Provider<com.shopee.app.d.c.b.a> k;

    /* renamed from: a */
    public dv get() {
        return new dv(this.f16862a.get(), this.f16863b.get(), this.f16864c.get(), this.f16865d.get(), this.f16866e.get(), this.f16867f.get(), this.f16868g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }

    public static dv a(n nVar, ba baVar, UploadStore uploadStore, a aVar, be beVar, UploadManager uploadManager, m mVar, af afVar, SettingConfigStore settingConfigStore, UserInfo userInfo, com.shopee.app.d.c.b.a aVar2) {
        return new dv(nVar, baVar, uploadStore, aVar, beVar, uploadManager, mVar, afVar, settingConfigStore, userInfo, aVar2);
    }
}
