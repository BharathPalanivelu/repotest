package com.shopee.app.web.processor;

import com.garena.android.appkit.b.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.CreateNewCheckoutMessage;

public class WebCreateNewCheckoutProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((CreateNewCheckoutMessage) WebRegister.GSON.a(lVar, CreateNewCheckoutMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webCreateNewCheckoutProcessor();
    }

    public static class Processor {
        private final n mEventBus;
        private final at notiStore;

        public Processor(n nVar, at atVar) {
            this.mEventBus = nVar;
            this.notiStore = atVar;
        }

        /* access modifiers changed from: package-private */
        public void process(CreateNewCheckoutMessage createNewCheckoutMessage) {
            long checkoutID = createNewCheckoutMessage.getCheckoutID();
            this.notiStore.a(new OrderKey(0, 9), checkoutID);
            this.mEventBus.a("NOTIFY_NEW_CHECKOUT", new a(createNewCheckoutMessage));
        }
    }
}
