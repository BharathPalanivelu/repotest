package com.shopee.app.ui.product.add;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final UserInfo f24131a;

    /* renamed from: b  reason: collision with root package name */
    private SettingConfigStore f24132b;

    public n(SettingConfigStore settingConfigStore, UserInfo userInfo) {
        this.f24132b = settingConfigStore;
        this.f24131a = userInfo;
    }

    public int a() {
        return this.f24132b.getDTSConfig(this.f24131a.isCrossBorder(), false)._default;
    }
}
