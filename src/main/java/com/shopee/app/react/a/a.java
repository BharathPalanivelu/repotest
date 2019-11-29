package com.shopee.app.react.a;

import com.appsflyer.share.Constants;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.f;
import com.shopee.app.util.i;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final UserInfo f18556a;

    /* renamed from: b  reason: collision with root package name */
    private SettingConfigStore f18557b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f18558c;

    public int b() {
        return 4;
    }

    public boolean g() {
        return true;
    }

    public String h() {
        return "index";
    }

    public a(SettingConfigStore settingConfigStore, UserInfo userInfo) {
        this.f18557b = settingConfigStore;
        this.f18556a = userInfo;
    }

    public String a() {
        String str = j() ? ".split" : "";
        return str + ".hermes";
    }

    public String c() {
        return i() + "rn_static/android/manifest." + 4 + a() + ".json";
    }

    public String d() {
        String e2 = f.a().e();
        return e2.concat("v" + b() + a()).concat(Constants.URL_PATH_DELIMITER);
    }

    public String e() {
        return "react_manifest_".concat("v" + b() + a());
    }

    public String f() {
        return d().concat("shopee.bundle");
    }

    public String i() {
        return i.f7040c;
    }

    public boolean j() {
        if (this.f18558c == null) {
            this.f18558c = Boolean.valueOf(this.f18557b.isSplitBundleOn(this.f18556a.getUserId()));
        }
        return this.f18558c.booleanValue();
    }

    public String toString() {
        return "ReactConfig {\n\tmanifestUrl=" + c() + "\n\treactPath=" + d() + "\n\tbundlePath=" + f() + "\n\tuseRemoteBundle=" + g() + "\n}";
    }
}
