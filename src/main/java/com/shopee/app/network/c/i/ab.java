package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.network.c.i.w;
import com.shopee.app.util.bi;
import com.shopee.protocol.action.Notification;

public class ab implements w.a {
    public void a(Notification notification) {
        ar.f().e().promotionCodeProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final bi f17950a;

        /* renamed from: b  reason: collision with root package name */
        private final UserInfo f17951b;

        /* renamed from: c  reason: collision with root package name */
        private final al f17952c;

        public a(bi biVar, UserInfo userInfo, al alVar) {
            this.f17950a = biVar;
            this.f17951b = userInfo;
            this.f17952c = alVar;
        }

        public void a(Notification notification) {
            com.shopee.app.data.a aVar = new com.shopee.app.data.a();
            aVar.a(b.a(notification.userid));
            aVar.a(b.a(notification.voucher_code));
            aVar.b(b.a(notification.currency));
            aVar.a(b.a(notification.voucher_min_spend));
            aVar.b(b.a(notification.voucher_discount_value));
            this.f17952c.a(aVar);
            if (this.f17951b.getUserId() == aVar.a()) {
                this.f17950a.a("PROMOTION_VOUCHER", new com.garena.android.appkit.b.a());
            }
        }
    }
}
