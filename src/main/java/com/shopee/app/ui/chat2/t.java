package com.shopee.app.ui.chat2;

import b.a.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.am;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class t implements b<s> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f20940a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingConfigStore> f20941b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<am> f20942c;

    /* renamed from: a */
    public s get() {
        return new s(this.f20940a.get(), this.f20941b.get(), this.f20942c.get());
    }

    public static s a(n nVar, SettingConfigStore settingConfigStore, am amVar) {
        return new s(nVar, settingConfigStore, amVar);
    }
}
