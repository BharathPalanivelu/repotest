package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingPageStateEvent extends TrackingEvent {
    @c(a = "info")
    public TrackingPageState pageState;

    public TrackingPageStateEvent() {
        super(TrackingType.PAGESTATE);
    }
}
