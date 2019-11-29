package com.shopee.app.web.processor;

import com.garena.android.appkit.b.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.c.e;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.app.h.m;
import com.shopee.app.network.d.h.i;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.ReturnUpdateMessage;
import java.util.Arrays;
import java.util.List;

public class WebReturnUpdateProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((ReturnUpdateMessage) WebRegister.GSON.a(lVar, ReturnUpdateMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webReturnUpdateProcessor();
    }

    public static class Processor {
        private final n mEventBus;
        private final at mNotiStore;
        private final e mReturnStore;

        public Processor(n nVar, e eVar, at atVar) {
            this.mEventBus = nVar;
            this.mReturnStore = eVar;
            this.mNotiStore = atVar;
        }

        /* access modifiers changed from: package-private */
        public void process(ReturnUpdateMessage returnUpdateMessage) {
            DBReturnItem a2 = this.mReturnStore.a(returnUpdateMessage.getReturnID());
            if (a2 != null) {
                a2.d(returnUpdateMessage.getReturnStatus());
                this.mReturnStore.a((List<DBReturnItem>) Arrays.asList(new DBReturnItem[]{a2}));
                new i().a(a2.c(), a2.d());
                this.mNotiStore.a(new OrderKey(m.a(a2.d()), 5), a2.b());
                this.mEventBus.a("RETURN_UPDATE_NOTI", new a(Long.valueOf(returnUpdateMessage.getReturnID())));
            }
        }
    }
}
