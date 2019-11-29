package com.shopee.app.web.processor;

import com.garena.android.appkit.b.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.c.e;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.ArchiveReturnMessage;

public class WebOnArchiveReturnProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((ArchiveReturnMessage) WebRegister.GSON.a(lVar, ArchiveReturnMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webOnArchiveReturnProcessor();
    }

    public static class Processor {
        private final n mEventBus;
        private final e mReturnStore;

        public Processor(n nVar, e eVar) {
            this.mEventBus = nVar;
            this.mReturnStore = eVar;
        }

        /* access modifiers changed from: package-private */
        public void process(ArchiveReturnMessage archiveReturnMessage) {
            this.mReturnStore.a(archiveReturnMessage.getReturnID());
            this.mEventBus.a("RETURN_ARCHIVE_NOTI", new a(Long.valueOf(archiveReturnMessage.getReturnID())));
        }
    }
}
