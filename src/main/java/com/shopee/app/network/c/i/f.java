package com.shopee.app.network.c.i;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.network.c.i.w;
import com.shopee.protocol.action.Notification;

public class f implements w.a {
    public void a(Notification notification) {
        b.a("USER_BAN", new a(), b.a.NETWORK_BUS);
    }
}
