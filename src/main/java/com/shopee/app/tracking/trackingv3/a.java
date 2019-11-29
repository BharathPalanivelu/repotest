package com.shopee.app.tracking.trackingv3;

import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.tracking.trackingv3.model.Info;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19170a = new a();

    private a() {
    }

    /* renamed from: com.shopee.app.tracking.trackingv3.a$a  reason: collision with other inner class name */
    public static final class C0294a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0294a f19171a = new C0294a();

        private C0294a() {
        }

        public final Info.InfoBuilder a(String str) {
            j.b(str, "pageType");
            return Info.InfoBuilder.Companion.builder().withTargetType(BaseEvent.SDK_CHAT).withPageSection("").withPageType(str);
        }

        public final Info.InfoBuilder b(String str) {
            j.b(str, "pageType");
            return Info.InfoBuilder.Companion.builder().withTargetType("account_settings").withPageSection("").withPageType(str);
        }
    }
}
