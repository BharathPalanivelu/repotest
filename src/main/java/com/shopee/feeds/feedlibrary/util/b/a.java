package com.shopee.feeds.feedlibrary.util.b;

import a.k;
import com.google.a.o;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.sdk.modules.app.tracker.TrackingEvent;
import java.util.concurrent.Callable;

public class a {
    public static void a(final String str, final o oVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                c a2 = b.b().b().a(str);
                com.shopee.sdk.b.a().j().logTrackingEvent(new TrackingEvent.Builder().info(new TrackingEvent.TrackingInfo.Builder().operation(a2.b()).data(oVar).pageSection(a2.c()).pageType(a2.a()).targetType(a2.d()).build()).type("v3").source("android").timestamp(System.currentTimeMillis()).build());
                return null;
            }
        });
    }
}
