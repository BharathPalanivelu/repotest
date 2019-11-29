package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingImpressionsEvent extends TrackingEvent {
    @c(a = "info")
    public TrackingImpressions impressions;

    public TrackingImpressionsEvent() {
        super("impression");
    }
}
