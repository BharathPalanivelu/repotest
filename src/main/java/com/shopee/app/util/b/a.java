package com.shopee.app.util.b;

import android.app.Activity;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.different.netserver.a;
import com.airpay.paysdk.core.b;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.al;
import com.shopee.app.react.protocol.PayWithPaymentInfoMessage;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26227a = new a();

    private a() {
    }

    public final void a(Activity activity, b bVar) {
        j.b(activity, "activity");
        j.b(bVar, "callback");
        com.airpay.paysdk.a.a().a(activity, new b.a().a(com.shopee.app.react.modules.app.appmanager.a.g()).a(), a(), bVar);
    }

    public final void a(Activity activity, PayWithPaymentInfoMessage payWithPaymentInfoMessage, com.airpay.paysdk.b bVar) {
        j.b(activity, "activity");
        j.b(payWithPaymentInfoMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        j.b(bVar, "callback");
        com.airpay.paysdk.a.a().b(activity, new b.a().a(com.shopee.app.react.modules.app.appmanager.a.g()).b(payWithPaymentInfoMessage.getQrcode()).a(), a(), bVar);
    }

    private final com.airpay.paysdk.base.different.netserver.a a() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        aa deviceStore = f2.e().deviceStore();
        a.C0072a b2 = new a.C0072a().a("ID").a(false).a(b()).b(com.shopee.app.react.modules.app.appmanager.a.c());
        j.a((Object) deviceStore, "deviceStore");
        com.airpay.paysdk.base.different.netserver.a a2 = b2.c(deviceStore.g()).a();
        j.a((Object) a2, "EnvParam.Builder()\n     …\n                .build()");
        return a2;
    }

    private final int b() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        al loginStore = f2.e().loginStore();
        j.a((Object) loginStore, "loginStore");
        if (!loginStore.c() && !loginStore.d() && !loginStore.f()) {
            return 4;
        }
        return 1;
    }
}
