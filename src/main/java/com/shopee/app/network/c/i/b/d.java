package com.shopee.app.network.c.i.b;

import com.shopee.app.application.ar;
import com.shopee.app.network.c.i.w;
import com.shopee.app.network.c.k.i;
import com.shopee.protocol.action.Notification;

public class d implements w.a {
    public void a(Notification notification) {
        i.a orderListProcessor = ar.f().e().orderListProcessor();
        orderListProcessor.a(notification.buyer_ordercnt_info, notification.to_rate_count);
        orderListProcessor.a(notification.seller_ordercnt_info);
    }
}
