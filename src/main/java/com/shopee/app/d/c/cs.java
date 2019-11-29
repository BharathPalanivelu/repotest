package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.ui.home.l;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cs implements b<cr> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16719a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<l> f16720b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16721c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<aa> f16722d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ThemeStore> f16723e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<bd> f16724f;

    /* renamed from: a */
    public cr get() {
        return new cr(this.f16719a.get(), this.f16720b.get(), this.f16721c.get(), this.f16722d.get(), this.f16723e.get(), this.f16724f.get());
    }

    public static cr a(n nVar, l lVar, SettingConfigStore settingConfigStore, aa aaVar, ThemeStore themeStore, bd bdVar) {
        return new cr(nVar, lVar, settingConfigStore, aaVar, themeStore, bdVar);
    }
}
