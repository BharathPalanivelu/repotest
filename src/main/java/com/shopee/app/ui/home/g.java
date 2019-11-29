package com.shopee.app.ui.home;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.util.s;
import javax.inject.Provider;

public final class g implements b<l> {

    /* renamed from: a  reason: collision with root package name */
    private final f f22222a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<s> f22223b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f22224c;

    /* renamed from: a */
    public l get() {
        return (l) c.a(this.f22222a.a(this.f22223b.get(), this.f22224c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static l a(f fVar, s sVar, SettingConfigStore settingConfigStore) {
        return (l) c.a(fVar.a(sVar, settingConfigStore), "Cannot return null from a non-@Nullable @Provides method");
    }
}
