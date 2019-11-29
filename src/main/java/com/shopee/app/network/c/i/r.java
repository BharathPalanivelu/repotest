package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.h.o;
import com.shopee.app.network.c.i.w;
import com.shopee.app.network.d.az;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class r implements w.a {
    public void a(Notification notification) {
        ar.f().e().newActivityProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ActivityCounter f17980a;

        /* renamed from: b  reason: collision with root package name */
        private final n f17981b;

        protected a(ActivityCounter activityCounter, n nVar) {
            this.f17980a = activityCounter;
            this.f17981b = nVar;
        }

        public void a(Notification notification) {
            com.shopee.app.network.d.r rVar = new com.shopee.app.network.d.r();
            o.a().a((az) rVar);
            rVar.a(0, 1);
            com.shopee.app.network.d.r rVar2 = new com.shopee.app.network.d.r();
            o.a().a((az) rVar2);
            rVar2.a(0, 1, 4);
            this.f17980a.incrementCount((long) notification.activity_id.intValue());
            this.f17981b.a("ACTIVITY_BADGE_UPDATE", new com.garena.android.appkit.b.a(this.f17980a));
        }
    }
}
