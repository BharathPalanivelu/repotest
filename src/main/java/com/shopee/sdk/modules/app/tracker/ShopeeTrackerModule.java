package com.shopee.sdk.modules.app.tracker;

public interface ShopeeTrackerModule {
    void logEvent(Object obj);

    void logTrackingEvent(TrackingEvent trackingEvent);
}
