package com.shopee.app.network.c.i;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.network.c.i.w;
import com.shopee.protocol.action.Notification;

class af implements w.a {
    af() {
    }

    public void a(Notification notification) {
        b.a("WALLET_TOPUP_COMPLETED", new a(), b.a.UI_BUS);
    }
}
