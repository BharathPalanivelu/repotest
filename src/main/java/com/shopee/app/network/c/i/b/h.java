package com.shopee.app.network.c.i.b;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.c.b;
import com.shopee.app.h.m;
import com.shopee.app.network.c.i.w;
import com.shopee.app.network.d.h.i;
import com.shopee.protocol.action.Notification;

public abstract class h implements w.a {
    public void a(Notification notification) {
        ar.f().e().orderUpdateProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f17959a;

        /* renamed from: b  reason: collision with root package name */
        public final at f17960b;

        public a(b bVar, at atVar) {
            this.f17959a = bVar;
            this.f17960b = atVar;
        }

        public void a(Notification notification) {
            long a2 = com.shopee.app.d.b.b.a(notification.orderid);
            int a3 = com.shopee.app.d.b.b.a(notification.shopid);
            this.f17959a.a(m.a(a3), a2);
            this.f17960b.a(m.a(a3), a2);
            i iVar = new i();
            iVar.a(true);
            iVar.a(a2, com.shopee.app.d.b.b.a(notification.shopid));
        }
    }
}
