package com.shopee.app.b.b;

import android.app.Activity;
import com.shopee.app.ui.setting.SettingActivity_;
import com.shopee.navigator.c.a.a;
import com.shopee.navigator.c.a.c;
import com.shopee.navigator.c.b;

public class f extends b {
    public a a() {
        return new c("settings");
    }

    public Class<? extends Activity> b() {
        return SettingActivity_.class;
    }
}
