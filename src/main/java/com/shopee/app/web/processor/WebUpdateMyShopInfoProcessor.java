package com.shopee.app.web.processor;

import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.network.d.ao;

public class WebUpdateMyShopInfoProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        processor().process();
    }

    private Processor processor() {
        return ar.f().e().webUpdateMyShopInfoProcessor();
    }

    public static class Processor {
        private final UserInfo mUserInfo;

        public Processor(UserInfo userInfo) {
            this.mUserInfo = userInfo;
        }

        /* access modifiers changed from: package-private */
        public void process() {
            new ao().a(this.mUserInfo.getShopId());
        }
    }
}
