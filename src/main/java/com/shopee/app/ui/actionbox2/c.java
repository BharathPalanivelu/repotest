package com.shopee.app.ui.actionbox2;

import android.app.Activity;
import b.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;

public final class c implements b<a> {
    public static void a(a aVar, ak akVar) {
        aVar.s = akVar;
    }

    public static void a(a aVar, ActionRequiredCounter actionRequiredCounter) {
        aVar.t = actionRequiredCounter;
    }

    public static void a(a aVar, ActivityCounter activityCounter) {
        aVar.u = activityCounter;
    }

    public static void a(a aVar, bi biVar) {
        aVar.v = biVar;
    }

    public static void a(a aVar, be beVar) {
        aVar.w = beVar;
    }

    public static void a(a aVar, UserInfo userInfo) {
        aVar.x = userInfo;
    }

    public static void a(a aVar, SettingConfigStore settingConfigStore) {
        aVar.y = settingConfigStore;
    }

    public static void a(a aVar, Activity activity) {
        aVar.z = activity;
    }

    public static void a(a aVar, com.shopee.app.tracking.trackingv3.b bVar) {
        aVar.A = bVar;
    }
}
