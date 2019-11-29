package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.network.c.i.w;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class u implements w.a {
    public int a() {
        return 14;
    }

    public void a(Notification notification) {
        ar.f().e().newItemProcessor().a(notification, a());
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final FollowCounter f17984a;

        /* renamed from: b  reason: collision with root package name */
        private final RegionConfigStore f17985b;

        /* renamed from: c  reason: collision with root package name */
        private final n f17986c;

        protected a(FollowCounter followCounter, RegionConfigStore regionConfigStore, n nVar) {
            this.f17984a = followCounter;
            this.f17985b = regionConfigStore;
            this.f17986c = nVar;
        }

        public void a(Notification notification, int i) {
            if (!this.f17985b.getRegionConfig().hideTimeline() && i == 28) {
                this.f17984a.onReceiveNewRedDot(b.a(notification.notification_time));
                this.f17986c.a().bu.a();
            }
        }
    }
}
