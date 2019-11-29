package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.c;
import com.shopee.app.data.store.e;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.h.o;
import com.shopee.app.network.c.i.w;
import com.shopee.app.network.d.az;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class a implements w.a {
    public void a(Notification notification) {
        if (notification != null) {
            ar.f().e().actionRequiredDeletedProcessor().a(notification);
        }
    }

    /* renamed from: com.shopee.app.network.c.i.a$a  reason: collision with other inner class name */
    public static class C0269a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17941a;

        /* renamed from: b  reason: collision with root package name */
        private final e f17942b;

        /* renamed from: c  reason: collision with root package name */
        private final c f17943c;

        /* renamed from: d  reason: collision with root package name */
        private final ActivityCounter f17944d;

        /* renamed from: e  reason: collision with root package name */
        private final ActionRequiredCounter f17945e;

        /* renamed from: f  reason: collision with root package name */
        private final com.shopee.app.data.store.a f17946f;

        public C0269a(n nVar, ActivityCounter activityCounter, ActionRequiredCounter actionRequiredCounter, e eVar, c cVar, com.shopee.app.data.store.a aVar) {
            this.f17941a = nVar;
            this.f17942b = eVar;
            this.f17943c = cVar;
            this.f17944d = activityCounter;
            this.f17945e = actionRequiredCounter;
            this.f17946f = aVar;
        }

        public void a(Notification notification) {
            long j;
            if (notification.activity_id != null) {
                this.f17942b.a(notification.activity_id.intValue());
                this.f17944d.remove((long) notification.activity_id.intValue());
                this.f17941a.a("ACTIVITY_REMOVED_SUCCESS", new com.garena.android.appkit.b.a(notification.activity_id));
                return;
            }
            long a2 = b.a(notification.groupid);
            if (a2 <= -1) {
                return;
            }
            if (notification.action_id != null && notification.action_cate != null) {
                this.f17943c.b(notification.action_id.longValue());
                if (a2 > 0) {
                    j = a2;
                } else {
                    j = notification.action_id.longValue();
                }
                this.f17945e.remove(j, notification.action_cate.intValue());
                this.f17941a.a("ACTION_REMOVE_SUCCESS", new com.garena.android.appkit.b.a(Long.valueOf(j)));
                if (a2 > 0) {
                    com.shopee.app.network.d.a.b bVar = new com.shopee.app.network.d.a.b();
                    o.a().a((az) bVar);
                    bVar.a(a2, notification.action_cate.intValue());
                }
            } else if (notification.action_id == null && notification.action_cate != null) {
                long longValue = notification.groupid.longValue();
                this.f17945e.remove(longValue, notification.action_cate.intValue());
                this.f17946f.a(notification.groupid.longValue());
                this.f17941a.a("ACTION_REMOVE_SUCCESS", new com.garena.android.appkit.b.a(Long.valueOf(longValue)));
            }
        }
    }
}
