package com.shopee.app.network.c.i;

import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.c.i.w;
import com.shopee.app.util.n;
import com.shopee.protocol.action.Notification;

public class p implements w.a {
    public void a(Notification notification) {
        ar.f().e().emailVerifiedProcessor().a(notification);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17977a;

        /* renamed from: b  reason: collision with root package name */
        private UserInfo f17978b;

        /* renamed from: c  reason: collision with root package name */
        private bh f17979c;

        public a(n nVar, UserInfo userInfo, bh bhVar) {
            this.f17977a = nVar;
            this.f17978b = userInfo;
            this.f17979c = bhVar;
        }

        public void a(Notification notification) {
            if (this.f17978b.getUserId() == b.a(notification.userid)) {
                this.f17978b.setEmailVerified(true);
                DBUserInfo a2 = this.f17979c.a(this.f17978b.getUserId());
                if (a2 != null) {
                    a2.b(true);
                    this.f17979c.a(a2);
                }
                this.f17977a.a("EMAIL_VERIFIED", new com.garena.android.appkit.b.a(this.f17978b));
            }
        }
    }
}
