package com.shopee.app.ui.setting.a.a;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.network.http.a.j;
import com.shopee.app.ui.setting.a.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.n;
import com.shopee.app.util.s;

public final class b implements b.b<a> {
    public static void a(a aVar, FollowCounter followCounter) {
        aVar.f25038a = followCounter;
    }

    public static void a(a aVar, n nVar) {
        aVar.f25039b = nVar;
    }

    public static void a(a aVar, j jVar) {
        aVar.f25040c = jVar;
    }

    public static void a(a aVar, s sVar) {
        aVar.f25041d = sVar;
    }

    public static void a(a aVar, UserInfo userInfo) {
        aVar.f25042e = userInfo;
    }

    public static void a(a aVar, e eVar) {
        aVar.setPresenter(eVar);
    }

    public static void a(a aVar, bc bcVar) {
        aVar.setScope(bcVar);
    }

    public static void a(a aVar, ak akVar) {
        aVar.setNavigator(akVar);
    }

    public static void a(a aVar, al alVar) {
        aVar.setMLoginStore(alVar);
    }

    public static void a(a aVar, SettingConfigStore settingConfigStore) {
        aVar.setMSettingConfigStore(settingConfigStore);
    }
}
