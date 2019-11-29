package com.shopee.app.pushnotification;

import android.content.Intent;
import android.text.TextUtils;
import com.garena.android.gpns.external.ServiceManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.aa;
import com.shopee.app.g.q;
import com.shopee.app.network.d.bl;
import com.shopee.app.network.d.f.l;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.util.c;
import e.f;

public class d {
    public static Intent a() {
        Intent intent = new Intent(ar.f(), HomeActivity_.class);
        intent.addFlags(536870912);
        return intent;
    }

    public static void a(boolean z, UserInfo userInfo, aa aaVar) {
        ServiceManager serviceManager = new ServiceManager(ar.f());
        if (!q.a() || !z) {
            serviceManager.requestToken();
            return;
        }
        serviceManager.stop();
        a(FirebaseInstanceId.getInstance().getToken(), userInfo, aaVar);
    }

    public static void a(String str, UserInfo userInfo, aa aaVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (userInfo.isLoggedIn()) {
            new bl().a(aaVar.d(), aaVar.b(), aaVar.e(), c.a().c(), aaVar.h(), aaVar.f(), str);
        } else {
            new l().a(aaVar.d(), f.a(str), "android_gcm");
        }
    }
}
