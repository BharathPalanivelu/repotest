package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.network.c.i.w;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class i implements w.a {
    public void a(Notification notification) {
        if (notification != null) {
            ar.f().e().chatMarkedUnreadProcessor().a(notification);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17967a;

        /* renamed from: b  reason: collision with root package name */
        private final ChatBadgeStore f17968b;

        public a(n nVar, ChatBadgeStore chatBadgeStore) {
            this.f17967a = nVar;
            this.f17968b = chatBadgeStore;
        }

        public void a(Notification notification) {
            if (notification.userid != null) {
                this.f17968b.setChatUnreadServer(notification.userid.intValue());
                this.f17967a.a().bH.a(Integer.valueOf(this.f17968b.getTotalCount())).a();
                this.f17967a.a().ay.a();
            }
        }
    }
}
