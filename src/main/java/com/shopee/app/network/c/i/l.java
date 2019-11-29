package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.r;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.network.c.i.w;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class l implements w.a {
    public void a(Notification notification) {
        ar.f().e().checkoutPaidProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17973a;

        /* renamed from: b  reason: collision with root package name */
        private final r f17974b;

        /* renamed from: c  reason: collision with root package name */
        private final q f17975c;

        /* renamed from: d  reason: collision with root package name */
        private final at f17976d;

        public a(n nVar, r rVar, at atVar, q qVar) {
            this.f17973a = nVar;
            this.f17974b = rVar;
            this.f17976d = atVar;
            this.f17975c = qVar;
        }

        public void a(Notification notification) {
            long a2 = b.a(notification.checkoutid);
            this.f17975c.a(Long.valueOf(a2));
            this.f17974b.b(a2);
            this.f17976d.b(new OrderKey(false, 9), a2);
            this.f17973a.a("CHECKOUT_ITEM_PAID", new com.garena.android.appkit.b.a(Long.valueOf(a2)));
        }
    }
}
