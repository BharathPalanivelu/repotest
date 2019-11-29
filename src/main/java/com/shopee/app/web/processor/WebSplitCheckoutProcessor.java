package com.shopee.app.web.processor;

import com.garena.android.appkit.b.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.r;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.SplitCheckoutMessage;

public class WebSplitCheckoutProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((SplitCheckoutMessage) WebRegister.GSON.a(lVar, SplitCheckoutMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webSplitCheckoutProcessor();
    }

    public static class Processor {
        private final q checkoutIdStore;
        private final r checkoutStore;
        private final n mEventBus;
        private final at notiStore;

        public Processor(n nVar, r rVar, q qVar, at atVar) {
            this.mEventBus = nVar;
            this.checkoutStore = rVar;
            this.checkoutIdStore = qVar;
            this.notiStore = atVar;
        }

        /* access modifiers changed from: package-private */
        public void process(SplitCheckoutMessage splitCheckoutMessage) {
            long checkoutID = splitCheckoutMessage.getCheckoutID();
            this.checkoutIdStore.a(Long.valueOf(checkoutID));
            this.checkoutStore.b(checkoutID);
            for (Long longValue : splitCheckoutMessage.getSplitCheckoutIDs()) {
                this.notiStore.a(new OrderKey(0, 9), longValue.longValue());
            }
            this.mEventBus.a("NOTIFY_SPLIT_CHECKOUT", new a(splitCheckoutMessage));
        }
    }
}
