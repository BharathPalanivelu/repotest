package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.c.d;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.h.m;
import com.shopee.app.network.c.i.w;
import com.shopee.app.network.d.h.i;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class ac implements w.a {
    public void a(Notification notification) {
        ar.f().e().returnUpdateProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17953a;

        /* renamed from: b  reason: collision with root package name */
        private final at f17954b;

        /* renamed from: c  reason: collision with root package name */
        private final d f17955c;

        public a(n nVar, at atVar, d dVar) {
            this.f17953a = nVar;
            this.f17954b = atVar;
            this.f17955c = dVar;
        }

        public void a(Notification notification) {
            new i().a(notification.orderid.longValue(), notification.shopid.intValue());
            this.f17954b.a(new OrderKey(m.a(notification.shopid.intValue()), 5), notification.return_id.longValue());
            this.f17953a.a("RETURN_UPDATE_NOTI", new com.garena.android.appkit.b.a());
        }
    }
}
