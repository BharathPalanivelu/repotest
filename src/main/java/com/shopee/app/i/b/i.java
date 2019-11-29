package com.shopee.app.i.b;

import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import com.shopee.sdk.modules.app.tracker.ShopeeTrackerModule;
import com.shopee.sdk.modules.app.tracker.TrackingEvent;
import com.shopee.shopeetracker.utils.GsonUtils;

public class i implements ShopeeTrackerModule {
    public void logEvent(Object obj) {
        UserActionV3.Companion.create(GsonUtils.toJson(obj, false)).log();
    }

    public void logTrackingEvent(TrackingEvent trackingEvent) {
        logEvent(trackingEvent);
    }
}
