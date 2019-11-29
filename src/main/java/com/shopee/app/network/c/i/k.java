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

public class k implements w.a {
    public void a(Notification notification) {
        ar.f().e().checkoutCancelProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17969a;

        /* renamed from: b  reason: collision with root package name */
        private final r f17970b;

        /* renamed from: c  reason: collision with root package name */
        private final q f17971c;

        /* renamed from: d  reason: collision with root package name */
        private final at f17972d;

        public a(n nVar, r rVar, at atVar, q qVar) {
            this.f17969a = nVar;
            this.f17970b = rVar;
            this.f17972d = atVar;
            this.f17971c = qVar;
        }

        public void a(Notification notification) {
            long a2 = b.a(notification.checkoutid);
            this.f17971c.a(Long.valueOf(a2));
            this.f17970b.b(a2);
            this.f17972d.b(new OrderKey(false, 9), a2);
            this.f17969a.a("CHECKOUT_ITEM_CANCEL", new com.garena.android.appkit.b.a(Long.valueOf(a2)));
        }
    }
}
