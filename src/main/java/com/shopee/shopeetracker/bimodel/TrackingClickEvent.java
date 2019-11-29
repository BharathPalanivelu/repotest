package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingClickEvent extends TrackingEvent {
    @c(a = "info")
    public TrackingClick click;

    public TrackingClickEvent() {
        super("click");
    }
}
