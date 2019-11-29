package com.shopee.app.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shopee.app.application.ar;
import com.shopee.app.ui.home.d.e;

public class ShopeeInstallReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static String f26121a = "";

    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        if (e.a(stringExtra) != null) {
            f26121a = stringExtra;
            ar.f().e().uiEventBus().a().j.a(f26121a).a();
        }
    }
}
