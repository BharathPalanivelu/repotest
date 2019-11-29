package com.shopee.app.web.processor;

import com.garena.android.appkit.b.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.t;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.FollowUserUpdateMessage;

public class WebFollowUserUpdateProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((FollowUserUpdateMessage) WebRegister.GSON.a(lVar, FollowUserUpdateMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webFollowUserUpdate();
    }

    public static class Processor {
        private final t mContactStore;
        private final n mEventBus;

        public Processor(n nVar, t tVar) {
            this.mEventBus = nVar;
            this.mContactStore = tVar;
        }

        /* access modifiers changed from: package-private */
        public void process(FollowUserUpdateMessage followUserUpdateMessage) {
            DBContactInfo a2 = this.mContactStore.a(followUserUpdateMessage.getShopId());
            if (a2 != null) {
                a2.a(followUserUpdateMessage.isFollowed());
                this.mContactStore.a(a2);
            }
            this.mEventBus.a("FOLLOW_USER_UPDATE", new a(followUserUpdateMessage));
            this.mEventBus.a("FOLLOW_USER_REFRESH", new a());
        }
    }
}
