package com.shopee.app.util;

import com.crashlytics.android.a.m;
import com.shopee.app.react.modules.app.appmanager.a;

public class r {
    public static m a() {
        return (m) new m("OppoPreInstall-v2").a("appVersion", a.c());
    }

    public static m b() {
        return (m) new m("64-Bit Architectures").a("Supported", c.i() ? "Yes" : "No");
    }
}
