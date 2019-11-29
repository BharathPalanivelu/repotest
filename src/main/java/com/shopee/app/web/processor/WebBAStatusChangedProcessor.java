package com.shopee.app.web.processor;

import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.al;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.UserBAStatusMessage;

public class WebBAStatusChangedProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process((UserBAStatusMessage) WebRegister.GSON.a(lVar, UserBAStatusMessage.class));
    }

    public Processor processor() {
        return ar.f().e().webBAStatusChangedProcessor();
    }

    public static class Processor {
        private final n mEventBus;
        private final al mLoginStore;
        private final UserInfo mUser;

        public Processor(n nVar, UserInfo userInfo, al alVar) {
            this.mEventBus = nVar;
            this.mUser = userInfo;
            this.mLoginStore = alVar;
        }

        /* access modifiers changed from: package-private */
        public void process(UserBAStatusMessage userBAStatusMessage) {
            this.mUser.setBACheckStatus(userBAStatusMessage.getBACheckStatus());
            this.mLoginStore.a(this.mUser);
        }
    }
}
