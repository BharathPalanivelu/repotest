package com.shopee.app.web.processor;

import com.garena.android.appkit.b.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.UpdateItemShippingMessage;

public class WebPassDataItemShippingProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((UpdateItemShippingMessage) WebRegister.GSON.a(lVar, UpdateItemShippingMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webPassDataItemShippingProcessor();
    }

    public static class Processor {
        private final n mEventBus;

        public Processor(n nVar) {
            this.mEventBus = nVar;
        }

        /* access modifiers changed from: package-private */
        public void process(UpdateItemShippingMessage updateItemShippingMessage) {
            this.mEventBus.a("passDataItemShipping", new a(updateItemShippingMessage));
        }
    }
}
