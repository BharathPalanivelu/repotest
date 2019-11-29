package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingInputEvent extends TrackingEvent {
    @c(a = "info")
    public TrackingInput input;

    public TrackingInputEvent() {
        super(TrackingType.INPUT);
    }
}
