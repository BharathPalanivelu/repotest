package com.shopee.app.network.c.i;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.network.c.i.w;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class b implements w.a {
    public void a(Notification notification) {
        ar.f().e().actionSystemMessageProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.data.store.b f17956a;

        /* renamed from: b  reason: collision with root package name */
        private final ActionRequiredCounter f17957b;

        /* renamed from: c  reason: collision with root package name */
        private final n f17958c;

        a(n nVar, com.shopee.app.data.store.b bVar, ActionRequiredCounter actionRequiredCounter) {
            this.f17958c = nVar;
            this.f17956a = bVar;
            this.f17957b = actionRequiredCounter;
        }

        public void a(Notification notification) {
            long a2 = com.shopee.app.d.b.b.a(notification.action_id);
            int a3 = com.shopee.app.d.b.b.a(notification.action_cate);
            long a4 = com.shopee.app.d.b.b.a(notification.groupid);
            long j = a4 > 0 ? a4 : a2;
            if (this.f17956a.d(a3)) {
                this.f17956a.a(a3, a2);
                this.f17957b.incrementCount(j, a3);
                this.f17958c.a().al.a(new Pair(Long.valueOf(a4), Integer.valueOf(a3))).a();
            }
        }
    }
}
