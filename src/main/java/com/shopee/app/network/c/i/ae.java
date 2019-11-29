package com.shopee.app.network.c.i;

import com.shopee.app.network.c.i.w;
import com.shopee.app.network.d.au;
import com.shopee.protocol.action.Notification;

public class ae implements w.a {
    public void a(Notification notification) {
        if (notification.userid != null) {
            new au().a(notification.userid.intValue());
        }
    }
}
