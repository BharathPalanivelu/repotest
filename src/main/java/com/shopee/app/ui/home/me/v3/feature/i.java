package com.shopee.app.ui.home.me.v3.feature;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.util.ak;
import com.shopee.app.util.s;
import com.shopee.navigator.e;
import d.d.b.j;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public b f22621a;

    /* renamed from: b  reason: collision with root package name */
    public UserInfo f22622b;

    /* renamed from: c  reason: collision with root package name */
    public ak f22623c;

    /* renamed from: d  reason: collision with root package name */
    public al f22624d;

    /* renamed from: e  reason: collision with root package name */
    public be f22625e;

    /* renamed from: f  reason: collision with root package name */
    public k f22626f;

    /* renamed from: g  reason: collision with root package name */
    public s f22627g;
    public SettingConfigStore h;
    public e i;
    private d j;
    private com.shopee.app.ui.home.me.tracking.seller.b k;

    public final void a(d dVar) {
        this.j = dVar;
    }

    public final d h() {
        return this.j;
    }

    public final void a(com.shopee.app.ui.home.me.tracking.seller.b bVar) {
        this.k = bVar;
    }

    public final com.shopee.app.ui.home.me.tracking.seller.b i() {
        return this.k;
    }

    public final void a(UserInfo userInfo) {
        j.b(userInfo, "<set-?>");
        this.f22622b = userInfo;
    }

    public final UserInfo j() {
        UserInfo userInfo = this.f22622b;
        if (userInfo == null) {
            j.b("user");
        }
        return userInfo;
    }

    public final ak k() {
        ak akVar = this.f22623c;
        if (akVar == null) {
            j.b("navigator");
        }
        return akVar;
    }

    public final al l() {
        al alVar = this.f22624d;
        if (alVar == null) {
            j.b("loginStore");
        }
        return alVar;
    }

    public final be m() {
        be beVar = this.f22625e;
        if (beVar == null) {
            j.b("uiSettingStore");
        }
        return beVar;
    }

    public final k n() {
        k kVar = this.f22626f;
        if (kVar == null) {
            j.b("rnConfigProvider");
        }
        return kVar;
    }

    public final s o() {
        s sVar = this.f22627g;
        if (sVar == null) {
            j.b("featureToggleManager");
        }
        return sVar;
    }

    public final SettingConfigStore p() {
        SettingConfigStore settingConfigStore = this.h;
        if (settingConfigStore == null) {
            j.b("settingConfigStore");
        }
        return settingConfigStore;
    }

    public final e q() {
        e eVar = this.i;
        if (eVar == null) {
            j.b("newNaviator");
        }
        return eVar;
    }
}
