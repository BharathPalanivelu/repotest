package com.shopee.app.network.c.i;

import com.shopee.app.d.b.b;
import com.shopee.app.network.c.i.w;
import com.shopee.app.network.d.as;
import com.shopee.protocol.action.Notification;

public class m implements w.a {
    public void a(Notification notification) {
        new as().a(b.a(notification.checkoutid));
    }
}
