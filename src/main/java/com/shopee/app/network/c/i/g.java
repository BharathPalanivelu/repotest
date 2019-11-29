package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.network.c.i.w;
import com.shopee.protocol.action.Notification;

public class g implements w.a {
    public void a(Notification notification) {
        ar.f().e().meCounter().setCartCount(b.a(notification.cart_item_count));
    }
}
