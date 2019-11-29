package com.shopee.app.web.processor;

import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.tracking.f;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.CancelOrderMessage;

public class WebCancelOrderProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((CancelOrderMessage) WebRegister.GSON.a(lVar, CancelOrderMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webCancelOrderProcessor();
    }

    public static class Processor {
        private final n mEventBus;
        private final at mNotiStore;
        private final c mOrderStore;
        private final f mTracker;

        public Processor(n nVar, f fVar, c cVar, at atVar) {
            this.mEventBus = nVar;
            this.mTracker = fVar;
            this.mOrderStore = cVar;
            this.mNotiStore = atVar;
        }

        /* access modifiers changed from: package-private */
        public void process(CancelOrderMessage cancelOrderMessage) {
            this.mOrderStore.b((long) cancelOrderMessage.getOrderID());
            this.mNotiStore.a(true, (long) cancelOrderMessage.getOrderID());
            this.mNotiStore.a(new OrderKey(true, 4), (long) cancelOrderMessage.getOrderID());
        }
    }
}
