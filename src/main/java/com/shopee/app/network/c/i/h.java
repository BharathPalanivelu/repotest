package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.network.c.i.w;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class h implements w.a {
    public void a(Notification notification) {
        ar.f().e().chatDeletedProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17964a;

        /* renamed from: b  reason: collision with root package name */
        private final av f17965b;

        /* renamed from: c  reason: collision with root package name */
        private final p f17966c;

        public a(n nVar, av avVar, p pVar) {
            this.f17964a = nVar;
            this.f17965b = avVar;
            this.f17966c = pVar;
        }

        public void a(Notification notification) {
            int a2 = b.a(notification.userid);
            this.f17966c.b(a2, b.a(notification.chat_clear_time));
            this.f17965b.a(Integer.valueOf(a2));
            this.f17964a.a().bU.a();
        }
    }
}
