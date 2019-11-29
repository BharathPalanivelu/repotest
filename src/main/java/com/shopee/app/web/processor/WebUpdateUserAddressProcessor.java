package com.shopee.app.web.processor;

import com.garena.android.appkit.b.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.UserLocationChangeMessage;

public class WebUpdateUserAddressProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((UserLocationChangeMessage) WebRegister.GSON.a(lVar, UserLocationChangeMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webUpdateUserAddressProcessor();
    }

    public static class Processor {
        private final n mEventBus;

        public Processor(n nVar) {
            this.mEventBus = nVar;
        }

        /* access modifiers changed from: package-private */
        public void process(UserLocationChangeMessage userLocationChangeMessage) {
            this.mEventBus.a("notifyDidUpdateUserAddress", new a(userLocationChangeMessage));
        }
    }
}
