package com.shopee.app.ui.home.me.v3;

import android.app.Activity;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.tracking.a;
import com.shopee.app.util.ak;

public final class b implements b.b<a> {
    public static void a(a aVar, Activity activity) {
        aVar.w = activity;
    }

    public static void a(a aVar, ak akVar) {
        aVar.x = akVar;
    }

    public static void a(a aVar, SettingConfigStore settingConfigStore) {
        aVar.y = settingConfigStore;
    }

    public static void a(a aVar, UserInfo userInfo) {
        aVar.z = userInfo;
    }

    public static void a(a aVar, a aVar2) {
        aVar.A = aVar2;
    }

    public static void a(a aVar, MeCounter meCounter) {
        aVar.B = meCounter;
    }

    public static void a(a aVar, ChatBadgeStore chatBadgeStore) {
        aVar.C = chatBadgeStore;
    }

    public static void a(a aVar, ThemeStore themeStore) {
        aVar.D = themeStore;
    }
}
