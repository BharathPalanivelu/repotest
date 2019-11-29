package com.shopee.app.pushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.app.network.d.bi;
import com.shopee.app.network.d.f.l;
import com.shopee.app.util.c;
import e.f;

public class GPNTokenReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("DATA");
        if (!TextUtils.isEmpty(stringExtra)) {
            aa deviceStore = ar.f().e().deviceStore();
            if (ar.f().e().loggedInUser().isLoggedIn()) {
                new bi().a(deviceStore.d(), stringExtra, deviceStore.e(), c.a().c(), deviceStore.h(), deviceStore.f(), deviceStore.b());
            } else {
                new l().a(deviceStore.d(), f.a(stringExtra), "android_gpns");
            }
        }
    }
}
