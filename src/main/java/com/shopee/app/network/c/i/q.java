package com.shopee.app.network.c.i;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.network.c.i.w;
import com.shopee.protocol.action.Notification;

public class q implements w.a {
    public void a(Notification notification) {
        b.a("INVALID_ITEM", new a(), b.a.NETWORK_BUS);
    }
}
