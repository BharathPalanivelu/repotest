package com.shopee.live.livestreaming.util;

import a.k;
import com.google.a.o;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity;
import com.shopee.sdk.modules.app.tracker.TrackingEvent;
import java.util.concurrent.Callable;

public class g {
    public static void a(String str, o oVar) {
        a(str, 0, oVar);
    }

    public static void a(final String str, final int i, final o oVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                UpLoadEventEntity b2 = b.b().b().b(str);
                com.shopee.sdk.b.a().j().logTrackingEvent(new TrackingEvent.Builder().info(new TrackingEvent.TrackingInfo.Builder().operation(b2.getOperation()).data(oVar).pageSection(b2.getPage_section()).pageType(b2.getPage_type()).targetType(b2.getTarget_type()).usageId(Integer.valueOf(i)).build()).type("v3").source("android").timestamp(System.currentTimeMillis()).build());
                return null;
            }
        });
    }

    public static void b(final String str, final o oVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                UpLoadEventEntity c2 = b.b().b().c(str);
                com.shopee.sdk.b.a().j().logTrackingEvent(new TrackingEvent.Builder().info(new TrackingEvent.TrackingInfo.Builder().operation(c2.getOperation()).data(oVar).pageSection(c2.getPage_section()).pageType(c2.getPage_type()).targetType(c2.getTarget_type()).usageId(1).build()).type("v3").source("android").timestamp(System.currentTimeMillis()).build());
                return null;
            }
        });
    }
}
