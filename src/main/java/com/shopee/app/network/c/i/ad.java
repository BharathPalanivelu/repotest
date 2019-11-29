package com.shopee.app.network.c.i;

import com.shopee.app.network.c.i.w;
import com.shopee.app.network.d.ao;
import com.shopee.protocol.action.Notification;

public class ad implements w.a {
    public void a(Notification notification) {
        if (notification.shopid != null) {
            new ao().a(notification.shopid.intValue());
        }
    }
}
