package com.shopee.app.util;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.tracking.a;
import com.shopee.app.upload.UploadManager;
import com.shopee.navigator.e;
import javax.inject.Provider;

public final class ax implements b<aw> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UserInfo> f26215a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ak> f26216b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f26217c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<e> f26218d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UploadManager> f26219e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<a> f26220f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<al> f26221g;

    public ax(Provider<UserInfo> provider, Provider<ak> provider2, Provider<SettingConfigStore> provider3, Provider<e> provider4, Provider<UploadManager> provider5, Provider<a> provider6, Provider<al> provider7) {
        this.f26215a = provider;
        this.f26216b = provider2;
        this.f26217c = provider3;
        this.f26218d = provider4;
        this.f26219e = provider5;
        this.f26220f = provider6;
        this.f26221g = provider7;
    }

    /* renamed from: a */
    public aw get() {
        aw awVar = new aw(this.f26215a.get(), this.f26216b.get(), this.f26217c.get(), this.f26218d.get(), this.f26219e.get());
        ay.a(awVar, this.f26220f.get());
        ay.a(awVar, this.f26221g.get());
        return awVar;
    }

    public static ax a(Provider<UserInfo> provider, Provider<ak> provider2, Provider<SettingConfigStore> provider3, Provider<e> provider4, Provider<UploadManager> provider5, Provider<a> provider6, Provider<al> provider7) {
        return new ax(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static aw a(UserInfo userInfo, ak akVar, SettingConfigStore settingConfigStore, e eVar, UploadManager uploadManager) {
        return new aw(userInfo, akVar, settingConfigStore, eVar, uploadManager);
    }
}
