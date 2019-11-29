package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingRequestEvent extends TrackingEvent {
    @c(a = "info")
    public TrackingRequest request;

    public TrackingRequestEvent() {
        super("request");
    }
}
