package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.network.c.i.w;
import com.shopee.protocol.action.Notification;

public class d implements w.a {
    public void a(Notification notification) {
        ar.f().e().newActivityProcessor().a(notification);
    }
}
