package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SettingConfigStore;

public final class ae implements b<SettingConfigStore> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15852a;

    public ae(c cVar) {
        this.f15852a = cVar;
    }

    /* renamed from: a */
    public SettingConfigStore get() {
        return (SettingConfigStore) c.a(this.f15852a.i(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ae a(c cVar) {
        return new ae(cVar);
    }
}
