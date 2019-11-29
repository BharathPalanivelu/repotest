package com.shopee.app.network.c.i.a;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import com.shopee.app.h.m;
import com.shopee.app.network.c.i.w;
import com.shopee.app.tracking.f;
import com.shopee.app.util.au;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;
import java.util.Collections;
import java.util.List;

public class a implements w.a {
    public void a(Notification notification) {
        a().a(notification);
    }

    private C0270a a() {
        return ar.f().e().offerChangedProcessor();
    }

    /* renamed from: com.shopee.app.network.c.i.a.a$a  reason: collision with other inner class name */
    public static class C0270a {

        /* renamed from: a  reason: collision with root package name */
        private n f17947a;

        /* renamed from: b  reason: collision with root package name */
        private com.shopee.app.data.store.ar f17948b;

        /* renamed from: c  reason: collision with root package name */
        private final f f17949c;

        public C0270a(n nVar, com.shopee.app.data.store.ar arVar, f fVar) {
            this.f17947a = nVar;
            this.f17948b = arVar;
            this.f17949c = fVar;
        }

        public void a(Notification notification) {
            DBOffer b2 = this.f17948b.b(b.a(notification.offerid));
            if (!(b2 == null || notification.offer_status == null)) {
                b2.e(notification.offer_status.intValue());
                this.f17948b.b((List<DBOffer>) Collections.singletonList(b2));
                a(b2);
            }
            this.f17947a.a("OFFER_CHANGED", new com.garena.android.appkit.b.a());
        }

        private void a(DBOffer dBOffer) {
            if (!m.a(dBOffer.f()) && dBOffer.k() == 2) {
                this.f17949c.b(dBOffer.g(), "IDR", au.a(dBOffer.j()), dBOffer.i(), dBOffer.e());
            }
        }
    }
}
